package client;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import db.executer.PersistenceException;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.Movie;
import generated.cinemaService.User;

import javax.swing.JSplitPane;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class View extends JFrame {
	private JSplitPane contentPane;
	private CardLayout cardLayout;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelFilmprojections;
	private JPanel panelLogin;
	private JPanel panelTickets;
	private JPanel panelEditing;
	private JPanel panelUsers;
	private JButton btnNavFilmprojections;
	private JButton btnNavLogin;
	private JButton btnNavTickets;
	private JButton btnNavEditing;
	private JButton btnNavUsers;
	private JTextField textField_loginUsername;
	private JPasswordField textField_loginPassword;
	private JButton btn_login;
	private JButton btn_logout;
	private JTextField textField_registerUsername;
	private JPasswordField textField_registerPassword;
	private JTextField textField_registerEmail;
	private JTextField textField_registerName;
	private JButton btn_register;
	private JTextField textField_movieInput;
	private JButton btn_createMovie;
	private DefaultListModel<Movie> movieListModel;
	private JList<Movie> list_movies;
	private JButton btn_deleteSelectedMovies;
	private JLabel label_currentUser;
	private JList<Cinemahall> list_halls;
	private DefaultListModel<Cinemahall> hallListModel;
	private JButton btn_deleteSelectedHall;
	private JTextField textField_hallName;
	private JComboBox<Integer> comboBox_hallRows;
	private JComboBox<Integer> comboBox_hallSeats;
	private JButton btn_createHall;
	private JButton btn_deleteProjection;
	private JButton btn_createProjection;
	private DefaultListModel<Filmprojection> projectionListModel;
	private JList<Filmprojection> list_projections;
	private JButton btn_calculateTotalProfit;
	private JButton btn_calculateProfit;
	private JList<Filmprojection> list_projectionsCustomer;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_roles;
	private JButton btn_removeRole;
	private JButton btn_addRole;
	private DefaultListModel<User> usersListModel;
	private JList<User> list_users;

	
	public View() throws PersistenceException {

		this.initPanes();
		
		this.projectionListModel = new DefaultListModel<Filmprojection>();
		
		this.buildFilmprojectionsPane();
		this.buildLoginPane();
		this.buildEditingPane();
		this.buildUsersPane();
		
	}
	
	private void initPanes() {
		this.cardLayout = new CardLayout();
		this.panelRight = new JPanel();
		this.panelRight.setLayout(this.cardLayout);
		this.panelLeft = new JPanel();
		this.panelLeft.setLayout(new BoxLayout(this.panelLeft, BoxLayout.Y_AXIS));

		this.panelFilmprojections = new JPanel();
		this.panelFilmprojections.setBackground(Color.BLUE);
		this.panelLogin = new JPanel();
		this.panelLogin.setBackground(Color.GREEN);
		this.panelTickets = new JPanel();
		this.panelTickets.setBackground(Color.CYAN);
		this.panelEditing = new JPanel();
		this.panelEditing.setBackground(Color.LIGHT_GRAY);
		this.panelUsers = new JPanel();
		this.panelEditing.setBackground(Color.GRAY);
		
		this.btnNavFilmprojections = new JButton("Filmaufführungen");
		this.btnNavFilmprojections.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.btnNavLogin = new JButton("Login");
		this.btnNavLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.btnNavTickets = new JButton("Tickets");
		this.btnNavTickets.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.btnNavTickets.setVisible(false);
		this.btnNavEditing = new JButton("Kino-Bearbeitung");
		this.btnNavEditing.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.btnNavEditing.setVisible(false);
		this.btnNavUsers = new JButton("Users");
		this.btnNavUsers.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.btnNavUsers.setVisible(false);
		
		this.panelLeft.add(Box.createRigidArea(new Dimension(0, 5)));
		this.panelLeft.add(this.btnNavFilmprojections);
		this.panelLeft.add(Box.createRigidArea(new Dimension(0, 5)));
		this.panelLeft.add(this.btnNavLogin);
		this.panelLeft.add(Box.createRigidArea(new Dimension(0, 5)));
		this.panelLeft.add(this.btnNavTickets);
		this.panelLeft.add(Box.createRigidArea(new Dimension(0, 5)));
		this.panelLeft.add(this.btnNavEditing);
		this.panelLeft.add(Box.createRigidArea(new Dimension(0, 5)));
		this.panelLeft.add(this.btnNavUsers);
		
		this.panelRight.add(this.panelFilmprojections,"panelFilmprojections");
		this.panelRight.add(this.panelLogin, "panelLogin");
		this.panelRight.add(this.panelTickets, "panelTickets");
		this.panelRight.add(this.panelEditing, "panelEditing");
		this.panelRight.add(this.panelUsers, "panelUsers");
		this.cardLayout.show(this.panelRight, "panelFilmprojections");
		
		this.btnNavFilmprojections.addActionListener(e -> {
			this.cardLayout.show(this.panelRight,"panelFilmprojections");
		});
		this.btnNavLogin.addActionListener(e -> {
			this.cardLayout.show(this.panelRight,"panelLogin");
		});
		this.btnNavTickets.addActionListener(e -> {
			this.cardLayout.show(this.panelRight,"panelTickets");
		});
		this.btnNavEditing.addActionListener(e -> {
			this.cardLayout.show(this.panelRight,"panelEditing");
		});
		this.btnNavUsers.addActionListener(e -> {
			this.cardLayout.show(this.panelRight,"panelUsers");
		});
		
		this.label_currentUser = new JLabel();
		panelLeft.add(this.label_currentUser);
		this.label_currentUser.setText("Nicht angemeldet");
		
		this.contentPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.panelLeft, this.panelRight);
		this.contentPane.setResizeWeight(0.03);

		setTitle("Cinema Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(this.contentPane);
		setBounds(100, 100, 1150, 600);
	}
	
	private void buildFilmprojectionsPane() {
		this.panelFilmprojections.setLayout(null);

		JScrollPane listScroller_projectionsCustomer = new JScrollPane();
		listScroller_projectionsCustomer.setBounds(260, 64, 341, 230);
		this.panelFilmprojections.add(listScroller_projectionsCustomer);
		this.list_projectionsCustomer = new JList<Filmprojection>(this.projectionListModel);
		listScroller_projectionsCustomer.setViewportView(list_projectionsCustomer);
		this.list_projectionsCustomer.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	}

	private void buildLoginPane() {
		JLabel label_loginUsername = new JLabel("Username");
		label_loginUsername.setBounds(10, 8, 81, 32);
		
		this.textField_loginUsername = new JTextField();
		this.textField_loginUsername.setBounds(95, 10, 102, 30);
		this.textField_loginUsername.setHorizontalAlignment(SwingConstants.LEFT);
		this.textField_loginUsername.setToolTipText("Please insert your Username");
		this.textField_loginUsername.setColumns(10);
		this.textField_loginUsername.setColumns(2);
		
		JLabel label_loginPassword = new JLabel("Password");
		label_loginPassword.setBounds(10, 64, 81, 32);
		label_loginPassword.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.textField_loginPassword = new JPasswordField(10);
		this.textField_loginPassword.setBounds(95, 65, 102, 32);
		this.textField_loginPassword.setHorizontalAlignment(SwingConstants.LEFT);
		this.textField_loginPassword.setToolTipText("Please Insert your Password here.");
		this.textField_loginPassword.setColumns(10);
		this.panelLogin.setLayout(null);
		this.panelLogin.add(label_loginUsername);
		this.panelLogin.add(textField_loginUsername);
		
		this.panelLogin.add(label_loginPassword);
		this.panelLogin.add(textField_loginPassword);
		
		this.btn_login = new JButton("Login");
		this.btn_login.setBounds(95, 117, 102, 32);
		this.panelLogin.add(this.btn_login);
		
		this.textField_registerUsername = new JTextField();
		this.textField_registerUsername.setBounds(305, 250, 102, 30);
		this.textField_registerUsername.setColumns(10);
		this.panelLogin.add(textField_registerUsername);

		JLabel label_registerUsername = new JLabel("Username");
		label_registerUsername.setBounds(220, 250, 75, 30);
		this.panelLogin.add(label_registerUsername);
		
		JLabel label_registerPassword = new JLabel("Password");
		label_registerPassword.setBounds(10, 250, 75, 30);
		this.panelLogin.add(label_registerPassword);
		
		this.textField_registerPassword = new JPasswordField(10);
		textField_registerPassword.setFont(UIManager.getFont("PasswordField.font"));
		this.textField_registerPassword.setColumns(10);
		this.textField_registerPassword.setBounds(95, 250, 102, 30);
		this.panelLogin.add(textField_registerPassword);
		
		JLabel label_registerEmail = new JLabel("Email");
		label_registerEmail.setBounds(220, 203, 75, 30);
		this.panelLogin.add(label_registerEmail);
		
		this.textField_registerEmail = new JTextField();
		this.textField_registerEmail.setColumns(10);
		this.textField_registerEmail.setBounds(305, 203, 102, 30);
		this.panelLogin.add(textField_registerEmail);
		
		JLabel label_registerName = new JLabel("Name");
		label_registerName.setBounds(10, 210, 75, 30);
		this.panelLogin.add(label_registerName);
		
		this.textField_registerName = new JTextField();
		this.textField_registerName.setColumns(10);
		this.textField_registerName.setBounds(95, 210, 102, 30);
		this.panelLogin.add(textField_registerName);
		
		this.btn_register = new JButton("Register");
		this.btn_register.setBounds(95, 305, 320, 32);
		this.panelLogin.add(btn_register);
		
		this.btn_logout = new JButton("Logout");
		this.btn_logout.setBounds(210, 117, 102, 32);
		this.panelLogin.add(this.btn_logout);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void buildEditingPane() {
		this.panelEditing.setLayout(null);
		
		this.textField_movieInput = new JTextField();
		this.textField_movieInput.setBounds(9, 35, 170, 19);
		this.panelEditing.add(this.textField_movieInput);
		this.textField_movieInput.setColumns(10);
		
		this.btn_createMovie = new JButton("Film erstellen");
		this.btn_createMovie.setBounds(198, 34, 170, 21);
		this.panelEditing.add(this.btn_createMovie);
		
		this.movieListModel = new DefaultListModel<Movie>();
		JScrollPane listScroller_movies = new JScrollPane();
		listScroller_movies.setBounds(8, 135, 360, 84);
		this.panelEditing.add(listScroller_movies);
		this.list_movies = new JList<Movie>(this.movieListModel);
		listScroller_movies.setViewportView(list_movies);
		this.list_movies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.btn_deleteSelectedMovies = new JButton("Film loeschen");
		this.btn_deleteSelectedMovies.setBounds(9, 64, 170, 21);
		this.panelEditing.add(this.btn_deleteSelectedMovies);
		
		JLabel label_movieList = new JLabel("Filme:");
		label_movieList.setBounds(9, 112, 45, 13);
		this.panelEditing.add(label_movieList);
		
		this.hallListModel = new DefaultListModel<Cinemahall>();
		JScrollPane listScroller_halls = new JScrollPane();
		listScroller_halls.setBounds(402, 135, 545, 84);
		this.panelEditing.add(listScroller_halls);
		this.list_halls = new JList<Cinemahall>(this.hallListModel);
		listScroller_halls.setViewportView(list_halls);
		this.list_halls.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel label_hallList = new JLabel("Kinosaele:");
		label_hallList.setBounds(402, 112, 76, 13);
		this.panelEditing.add(label_hallList);
		
		this.btn_deleteSelectedHall = new JButton("Saal loeschen");
		this.btn_deleteSelectedHall.setBounds(402, 64, 201, 21);
		this.panelEditing.add(this.btn_deleteSelectedHall);
		
		this.textField_hallName = new JTextField();
		this.textField_hallName.setBounds(402, 35, 88, 19);
		this.panelEditing.add(this.textField_hallName);
		this.textField_hallName.setColumns(10);
		
		Integer[] rowOptions = { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 };
		this.comboBox_hallRows = new JComboBox(rowOptions);
		this.comboBox_hallRows.setBounds(502, 34, 127, 21);
		this.panelEditing.add(this.comboBox_hallRows);
		
		Integer[] seatOptions = new Integer[50];
		for (int i = 0;i <50;i++){
		seatOptions[i]=i+1;
		}
		this.comboBox_hallSeats = new JComboBox(seatOptions);
		this.comboBox_hallSeats.setBounds(639, 34, 128, 21);
		this.panelEditing.add(this.comboBox_hallSeats);
		
		this.btn_createHall = new JButton("Saal erstellen");
		this.btn_createHall.setBounds(777, 34, 170, 21);
		this.panelEditing.add(this.btn_createHall);
		
		JLabel label_movieTitle = new JLabel("Titel:");
		label_movieTitle.setBounds(9, 12, 45, 13);
		this.panelEditing.add(label_movieTitle);
		
		JLabel label_hallName = new JLabel("Name:");
		label_hallName.setBounds(402, 12, 45, 13);
		this.panelEditing.add(label_hallName);
		
		JLabel label_rowNumber = new JLabel("Anzahl Reihen:");
		label_rowNumber.setBounds(502, 12, 127, 13);
		this.panelEditing.add(label_rowNumber);
		
		JLabel label_seatNumber = new JLabel("Anzahl Sitze pro Reihe:");
		label_seatNumber.setBounds(639, 11, 156, 13);
		this.panelEditing.add(label_seatNumber);
		
		JScrollPane listScroller_projections = new JScrollPane();
		listScroller_projections.setBounds(9, 391, 938, 147);
		this.panelEditing.add(listScroller_projections);
		this.list_projections = new JList<Filmprojection>(this.projectionListModel);
		listScroller_projections.setViewportView(list_projections);
		this.list_projections.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		JLabel label_projections = new JLabel("Filmaufführungen:");
		label_projections.setBounds(9, 368, 127, 13);
		this.panelEditing.add(label_projections);
		
		this.btn_deleteProjection = new JButton("Filmaufführung loeschen");
		this.btn_deleteProjection.setBounds(10, 290, 337, 21);
		this.panelEditing.add(btn_deleteProjection);
		
		this.btn_createProjection = new JButton("Filmaufführung erstellen");
		this.btn_createProjection.setBounds(370, 290, 295, 21);
		this.panelEditing.add(this.btn_createProjection);
		
		this.btn_calculateTotalProfit = new JButton("Gesamtumsatz berechnen");
		this.btn_calculateTotalProfit.setBounds(9, 321, 338, 21);
		this.panelEditing.add(this.btn_calculateTotalProfit);
		
		this.btn_calculateProfit = new JButton("Umsatz für ausgewählte Filmaufführung berechnen");
		this.btn_calculateProfit.setBounds(370, 321, 577, 21);
		this.panelEditing.add(this.btn_calculateProfit);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void buildUsersPane() throws PersistenceException {
		panelUsers.setLayout(null);
		
		JLabel label_userList = new JLabel("Alle User:");
		label_userList.setBounds(28, 31, 90, 13);
		this.panelUsers.add(label_userList);
		
		this.usersListModel = new DefaultListModel<User>();
		JScrollPane listScroller_users = new JScrollPane();
		listScroller_users.setBounds(28, 54, 474, 293);
		this.panelUsers.add(listScroller_users);
		this.list_users = new JList<User>(this.usersListModel);
		listScroller_users.setViewportView(list_users);
		this.list_users.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		String[] rowOptions = { "Customer", "Admin" };
		this.comboBox_roles = new JComboBox(rowOptions);
		
		this.comboBox_roles.setBounds(512, 84, 187, 21);
		this.panelUsers.add(this.comboBox_roles);
		
		this.btn_removeRole = new JButton("Berechtigung entfernen");
		this.btn_removeRole.setBounds(512, 129, 187, 21);
		this.panelUsers.add(this.btn_removeRole);
		
		this.btn_addRole = new JButton("Berechtigung geben");
		this.btn_addRole.setBounds(512, 160, 187, 21);
		this.panelUsers.add(this.btn_addRole);
		
		JLabel label_roles = new JLabel("Berechtigungen:");
		label_roles.setBounds(512, 54, 145, 13);
		this.panelUsers.add(label_roles);
		
	}
	
	public JButton getBtnNavFilmprojections() {
		return btnNavFilmprojections;
	}

	public JButton getBtnNavLogin() {
		return btnNavLogin;
	}

	public JButton getBtnNavTickets() {
		return btnNavTickets;
	}

	public JButton getBtnNavEditing() {
		return btnNavEditing;
	}

	public JButton getBtnNavUsers() {
		return btnNavUsers;
	}

	public JTextField getTextField_loginUsername() {
		return textField_loginUsername;
	}

	public JPasswordField getTextField_loginPassword() {
		return textField_loginPassword;
	}

	public JButton getBtn_login() {
		return btn_login;
	}
	
	public JButton getBtn_logout() {
		return btn_logout;
	}

	public JTextField getTextField_registerUsername() {
		return textField_registerUsername;
	}

	public JPasswordField getTextField_registerPassword() {
		return textField_registerPassword;
	}

	public JTextField getTextField_registerEmail() {
		return textField_registerEmail;
	}

	public JTextField getTextField_registerName() {
		return textField_registerName;
	}

	public JButton getBtn_register() {
		return btn_register;
	}

	public JTextField getTextField_movieInput() {
		return textField_movieInput;
	}

	public JButton getBtn_createMovie() {
		return btn_createMovie;
	}

	public DefaultListModel<Movie> getMovieListModel() {
		return movieListModel;
	}

	public JList<Movie> getList_movies() {
		return list_movies;
	}

	public JButton getBtn_deleteSelectedMovies() {
		return btn_deleteSelectedMovies;
	}
	
	public JLabel getLabel_currentUser() {
		return label_currentUser;
	}
	
	public JButton getBtn_deleteSelectedHall() {
		return btn_deleteSelectedHall;
	}

	public JComboBox<Integer> getComboBox_hallRows() {
		return comboBox_hallRows;
	}

	public JComboBox<Integer> getComboBox_hallSeats() {
		return comboBox_hallSeats;
	}

	public JButton getBtn_createHall() {
		return btn_createHall;
	}

	public JTextField getTextField_hallName() {
		return textField_hallName;
	}

	public DefaultListModel<Cinemahall> getHallListModel() {
		return hallListModel;
	}

	public JList<Cinemahall> getList_halls() {
		return list_halls;
	}

	public JButton getBtn_deleteProjection() {
		return btn_deleteProjection;
	}

	public JButton getBtn_createProjection() {
		return btn_createProjection;
	}

	public DefaultListModel<Filmprojection> getProjectionListModel() {
		return projectionListModel;
	}

	public JList<Filmprojection> getList_projections() {
		return list_projections;
	}

	public JButton getBtn_calculateTotalProfit() {
		return btn_calculateTotalProfit;
	}

	public JButton getBtn_calculateProfit() {
		return btn_calculateProfit;
	}

	public JList<Filmprojection> getList_projectionsCustomer() {
		return list_projectionsCustomer;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_roles() {
		return comboBox_roles;
	}

	public JButton getBtn_addRole() {
		return btn_addRole;
	}

	public DefaultListModel<User> getUsersListModel() {
		return usersListModel;
	}

	public JList<User> getList_users() {
		return list_users;
	}

	public JButton getBtn_removeRole() {
		return btn_removeRole;
	}
	
}
