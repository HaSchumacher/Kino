package client;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.List;

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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import generated.cinemaService.Booking;
import generated.cinemaService.Movie;
import generated.cinemaService.Reservation;
import javax.swing.JSplitPane;

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
	private JButton btn_refreshMovieList;
	private JButton btn_deleteSelectedMovies;
	private JLabel label_currentUser;

	
	public View() {

		this.initPanes();
		this.buildLoginPane();
		this.buildEditingPane();
		
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
		this.label_currentUser.setText("");
		
		this.contentPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.panelLeft, this.panelRight);

		setTitle("Cinema Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(this.contentPane);
		setBounds(100, 100, 1000, 600);
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
		this.btn_login.setBounds(112, 128, 85, 21);
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
		this.btn_register.setBounds(192, 330, 85, 21);
		this.panelLogin.add(btn_register);
		
		this.btn_logout = new JButton("Logout");
		this.btn_logout.setBounds(322, 128, 85, 21);
		this.panelLogin.add(this.btn_logout);
	}
	
	private void buildEditingPane() {
		this.panelEditing.setLayout(null);
		
		this.textField_movieInput = new JTextField();
		this.textField_movieInput.setBounds(10, 10, 142, 19);
		this.panelEditing.add(this.textField_movieInput);
		this.textField_movieInput.setColumns(10);
		
		this.btn_createMovie = new JButton("Film erstellen");
		this.btn_createMovie.setBounds(162, 9, 125, 21);
		this.textField_movieInput.add(this.btn_createMovie);
		
		this.movieListModel = new DefaultListModel<Movie>();
		this.list_movies = new JList<Movie>(this.movieListModel);
		
		JScrollPane listScroller_movies = new JScrollPane(this.list_movies);
		listScroller_movies.setBounds(10, 59, 277, 84);
		this.panelEditing.add(listScroller_movies);
		
		this.btn_refreshMovieList = new JButton("Aktualisieren");
		this.btn_refreshMovieList.setBounds(297, 56, 142, 21);
		this.panelEditing.add(this.btn_refreshMovieList);
		
		this.btn_deleteSelectedMovies = new JButton("L�schen");
		this.btn_deleteSelectedMovies.setBounds(297, 87, 142, 21);
		this.panelEditing.add(this.btn_deleteSelectedMovies);
		
		Label lbselectMovie = new Label("Film Wählen");
		lbselectMovie.setBounds(10, 164, 114, 21);
		this.panelEditing.add(lbselectMovie);
		
		Choice SelectMovie = new Choice();
		SelectMovie.setBounds(10, 191, 142, 18);
		this.panelEditing.add(SelectMovie);
		
		Label lbCinemahallSelect = new Label("Kinosaal wählen");
		lbCinemahallSelect.setBounds(162, 164, 125, 21);
		this.panelEditing.add(lbCinemahallSelect);
		
		Choice SelectCinemahall = new Choice();
		SelectCinemahall.setBounds(162, 191, 125, 18);
		this.panelEditing.add(SelectCinemahall);
		
		JButton btnFilmProjection = new JButton("Filmaufführung erstellen");
		btnFilmProjection.setBounds(140, 239, 299, 21);
		this.panelEditing.add(btnFilmProjection);
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

	public JButton getBtn_refreshMovieList() {
		return btn_refreshMovieList;
	}

	public JButton getBtn_deleteSelectedMovies() {
		return btn_deleteSelectedMovies;
	}
	
	public JLabel getLabel_currentUser() {
		return label_currentUser;
	}


	/**

	public View() {


		panel_projections.setLayout(null);
		
		FilmSelectionGroup = new JScrollPane();
		FilmSelectionGroup.setBounds(28, 23, 343, 90);
		panel_projections.add(FilmSelectionGroup);
		
		List Filmliste = new List();
		FilmSelectionGroup.setViewportView(Filmliste);
		
		JLabel selectionfilm = new JLabel("Bitte Wählen Sie einen Film aus.");
		FilmSelectionGroup.setColumnHeaderView(selectionfilm);
		
		CategorySelectionGroup = new JScrollPane();
		CategorySelectionGroup.setBounds(28, 119, 343, 95);
		panel_projections.add(CategorySelectionGroup);
		
		category = new List();
		CategorySelectionGroup.setViewportView(category);
		
		JLabel lblNewLabel = new JLabel("Wählen Sie nun Ihre Kategory.");
		CategorySelectionGroup.setColumnHeaderView(lblNewLabel);
		
		JButton btnreserveSeat = new JButton("Platz Reservieren");
		btnreserveSeat.setBounds(28, 224, 343, 21);
		panel_projections.add(btnreserveSeat);
		JPanel panel_reservations = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_reservations, null);
		panel_reservations.setLayout(null);
		
		this.scrollPane_loggedUserReservations = new JScrollPane();
		this.scrollPane_loggedUserReservations.setBounds(31, 21, 256, 115);
		panel_reservations.add(this.scrollPane_loggedUserReservations);
		
		this.list_loggedUserReservations = new JList<Reservation>();
		this.scrollPane_loggedUserReservations.setViewportView(this.list_loggedUserReservations);
		
		JLabel label_loggedUserReservations = new JLabel("Reservierungen");
		this.scrollPane_loggedUserReservations.setColumnHeaderView(label_loggedUserReservations);
		
		this.scrollPane_loggedUserBookings = new JScrollPane();
		this.scrollPane_loggedUserBookings.setBounds(33, 159, 256, 115);
		panel_reservations.add(this.scrollPane_loggedUserBookings);
		
		JLabel label_loggedUserBookings = new JLabel("Buchungen");
		this.scrollPane_loggedUserBookings.setColumnHeaderView(label_loggedUserBookings);
		
		this.list_loggedUserBookings = new JList<Booking>();
		this.scrollPane_loggedUserBookings.setViewportView(this.list_loggedUserBookings);
		
		JButton btnCancelReservation = new JButton("Reservierung Aufheben");
		btnCancelReservation.setBounds(297, 39, 283, 21);
		panel_reservations.add(btnCancelReservation);
		
		JButton btnBookReservation = new JButton("Reservierung buchen");
		btnBookReservation.setBounds(297, 93, 283, 21);
		panel_reservations.add(btnBookReservation);
		JPanel panel_movies = new JPanel();
		tabbedPane.addTab("Filme", null, panel_movies, null);
		JPanel panel_halls = new JPanel();
		tabbedPane.addTab("Kinos�le", null, panel_halls, null);
		panel_halls.setLayout(null);
		
		nameforCinemahall = new JTextField();
		nameforCinemahall.setBounds(155, 23, 96, 19);
		panel_halls.add(nameforCinemahall);
		nameforCinemahall.setColumns(10);
		
		JSpinner selectRows = new JSpinner();
		selectRows.setBounds(72, 96, 30, 20);
		panel_halls.add(selectRows);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(192, 96, 30, 20);
		panel_halls.add(spinner_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name für den neuen Kinosaal.");
		lblNewLabel_1.setBounds(10, 26, 158, 13);
		panel_halls.add(lblNewLabel_1);
		
		JLabel lbRows = new JLabel("Reihenanzahl");
		lbRows.setHorizontalAlignment(SwingConstants.LEFT);
		lbRows.setBounds(10, 99, 61, 13);
		panel_halls.add(lbRows);
		
		JLabel lbselectSeats = new JLabel("Sitze pro Reihe");
		lbselectSeats.setBounds(112, 99, 70, 13);
		panel_halls.add(lbselectSeats);
		
		JButton btncreateCinemahall = new JButton("Kinosaal erstellen");
		btncreateCinemahall.setBounds(10, 165, 241, 21);
		panel_halls.add(btncreateCinemahall);

		
		JPanel panel_roles = new JPanel();
		tabbedPane.addTab("Rollen", null, panel_roles, null);
		panel_roles.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 169, 99);
		panel_roles.add(scrollPane);
		
		JList<Movie> listUsers = new JList();
		scrollPane.setViewportView(listUsers);
		
		Label lbSelectUser = new Label("Benutzer auswählen");
		scrollPane.setColumnHeaderView(lbSelectUser);
		
		Choice chRoles = new Choice();
		chRoles.setBounds(238, 63, 167, 18);
		panel_roles.add(chRoles);
		
		Label lbRoleSelection = new Label("Rolle wählen");
		lbRoleSelection.setBounds(238, 26, 167, 21);
		panel_roles.add(lbRoleSelection);
		
		Button btnRole = new Button("neue Rolle zuweisen");
		btnRole.setBounds(175, 149, 197, 21);
		panel_roles.add(btnRole);
		
		JPanel panel_outcome = new JPanel();
		tabbedPane.addTab("Umsätze", null, panel_outcome, null);
		panel_outcome.setLayout(null);
		
		Choice chOutcomeOneFilm = new Choice();
		chOutcomeOneFilm.setBounds(117, 34, 86, 18);
		panel_outcome.add(chOutcomeOneFilm);
		
		Label lbfilmprojection = new Label("Film auswählen");
		lbfilmprojection.setBounds(10, 31, 101, 21);
		panel_outcome.add(lbfilmprojection);
		
		JLabel lbOutcomeOneFilm = new JLabel("Berechnung des Umsatzes für ein Film");
		lbOutcomeOneFilm.setBounds(10, 58, 175, 13);
		panel_outcome.add(lbOutcomeOneFilm);
		
		Button btnOutcome = new Button("Berechne Umsatz");
		btnOutcome.setBounds(228, 34, 175, 21);
		panel_outcome.add(btnOutcome);
		
		Label lbOutcometotal = new Label("Gesamt Umsatz berechnen");
		lbOutcometotal.setBounds(10, 106, 176, 21);
		panel_outcome.add(lbOutcometotal);
		
		Button btnOutcomeTotal = new Button("Berechne Gesamt Umsatz");
		btnOutcomeTotal.setFont(UIManager.getFont("Button.font"));
		btnOutcomeTotal.setBounds(228, 106, 203, 21);
		panel_outcome.add(btnOutcomeTotal);
		
		JTextPane txtforOneOutcome = new JTextPane();
		txtforOneOutcome.setEditable(false);
		txtforOneOutcome.setBounds(488, 34, 69, 19);
		panel_outcome.add(txtforOneOutcome);
		
		JTextPane txtForTotalOutcome = new JTextPane();
		txtForTotalOutcome.setEditable(false);
		txtForTotalOutcome.setBounds(488, 106, 69, 19);
		panel_outcome.add(txtForTotalOutcome);
		
		
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JTextField getTextFieldMovieInput() {
		return this.textField_movieInput;
	}
	public JButton getBtnCreateMovie() {
		return this.btn_createMovie;
	}
	public JButton getBtnRefreshMovieList() {
		return this.btn_refreshMovieList;
	}
	public JButton getBtnDeleteSelectedMovie() {
		return this.btn_deleteSelectedMovies;
	}
	public JList<Movie> getListMovies() {
		return this.list_movies;
	}
	public DefaultListModel<Movie> getMovieListModel() {
		return this.movieListModel;
	}
	public JButton getBtnLogin() {
		return this.btn_login;
	}
	public JTextField getTextFieldLoginUsername() {
		return this.textField_loginUsername;
	}
	public JTextField getTextFieldLoginPassword() {
		return this.textField_loginPassword;
	}
	public JButton getBtnRegister() {
		return this.btn_register;
	}
	public JTextField getTextFieldRegisterName() {
		return this.textField_registerName;
	}
	public JTextField getTextFieldRegisterEmail() {
		return this.textField_registerEmail;
	}
	public JTextField getTextFieldRegisterUsername() {
		return this.textField_registerUsername;
	}
	public JTextField getTextFieldRegisterPassword() {
		return this.textField_registerPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextField_movieInput() {
		return textField_movieInput;
	}

	public JButton getBtn_createMovie() {
		return btn_createMovie;
	}

	public JButton getBtn_refreshMovieList() {
		return btn_refreshMovieList;
	}

	public JButton getBtn_deleteSelectedMovies() {
		return btn_deleteSelectedMovies;
	}

	public JList<Movie> getList_movies() {
		return list_movies;
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

	public JScrollPane getScrollPane_loggedUserReservations() {
		return scrollPane_loggedUserReservations;
	}

	public JScrollPane getScrollPane_loggedUserBookings() {
		return scrollPane_loggedUserBookings;
	}

	public JList<Reservation> getList_loggedUserReservations() {
		return list_loggedUserReservations;
	}

	public JList<Booking> getList_loggedUserBookings() {
		return list_loggedUserBookings;
	}

	public JScrollPane getFilmSelectionGroup() {
		return FilmSelectionGroup;
	}

	public List getCategory() {
		return category;
	}

	public JScrollPane getCategorySelectionGroup() {
		return CategorySelectionGroup;
	}

	public JTextField getNameforCinemahall() {
		return nameforCinemahall;
	}
	
	**/

}
