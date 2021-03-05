import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import generated.cinemaService.Movie;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.List;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_movieInput;
	private JButton btn_createMovie;
	private JButton btn_refreshMovieList;
	private JButton btn_deleteSelectedMovies;
	private JList<Movie> list_movies;
	private DefaultListModel<Movie> movieListModel;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton login;
	private JTextField textField;
	private JLabel registerUsername;
	private JLabel registerPassword;
	private JTextField textField_1;
	private JLabel registerEmail;
	private JTextField textField_2;
	private JLabel registerName;
	private JTextField textField_3;
	private JButton btnRegisterUser;
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneforBookings;
	private JLabel lblBuchungen;
	private JList loggedUserBookings;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 749);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 10, 1166, 679);
		contentPane.add(tabbedPane);
		JPanel panel_users = new JPanel();
		tabbedPane.addTab("User", null, panel_users, null);
		
		JLabel Username = new JLabel("Username");
		Username.setBounds(10, 8, 81, 32);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(95, 10, 102, 30);
		textFieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsername.setToolTipText("Please insert your Username");
		textFieldUsername.setColumns(10);
		textFieldUsername.setColumns(2);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(10, 64, 81, 32);
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(95, 65, 102, 32);
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setToolTipText("Please Insert your Password here.");
		textFieldPassword.setColumns(10);
		panel_users.setLayout(null);
		panel_users.add(Username);
		panel_users.add(textFieldUsername);
		
		panel_users.add(Password);
		panel_users.add(textFieldPassword);
		
		this.login = new JButton("Login");
		this.login.setBounds(112, 128, 85, 21);
		panel_users.add(this.login);
		
		textField = new JTextField();
		textField.setBounds(305, 250, 102, 30);
		panel_users.add(textField);
		textField.setColumns(10);
		
		registerUsername = new JLabel("Username");
		registerUsername.setBounds(220, 250, 75, 30);
		panel_users.add(registerUsername);
		
		registerPassword = new JLabel("Password");
		registerPassword.setBounds(10, 250, 75, 30);
		panel_users.add(registerPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 250, 102, 30);
		panel_users.add(textField_1);
		
		registerEmail = new JLabel("Email");
		registerEmail.setBounds(220, 203, 75, 30);
		panel_users.add(registerEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(305, 203, 102, 30);
		panel_users.add(textField_2);
		
		registerName = new JLabel("Name");
		registerName.setBounds(10, 210, 75, 30);
		panel_users.add(registerName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 210, 102, 30);
		panel_users.add(textField_3);
		
		btnRegisterUser = new JButton("Register");
		btnRegisterUser.setBounds(192, 330, 85, 21);
		panel_users.add(btnRegisterUser);
		JPanel panel_projections = new JPanel();
		tabbedPane.addTab("Auff�hrungen", null, panel_projections, null);
		JPanel panel_reservations = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_reservations, null);
		panel_reservations.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 21, 256, 115);
		panel_reservations.add(scrollPane);
		
		JList<Movie> loggedUserReservation = new JList();
		scrollPane.setViewportView(loggedUserReservation);
		
		JLabel lblNewLabel = new JLabel("Reservierungen");
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		scrollPaneforBookings = new JScrollPane();
		scrollPaneforBookings.setBounds(33, 159, 256, 115);
		panel_reservations.add(scrollPaneforBookings);
		
		lblBuchungen = new JLabel("Buchungen");
		scrollPaneforBookings.setColumnHeaderView(lblBuchungen);
		
		loggedUserBookings = new JList();
		scrollPaneforBookings.setViewportView(loggedUserBookings);
		JPanel panel_movies = new JPanel();
		tabbedPane.addTab("Filme", null, panel_movies, null);
		JPanel panel_halls = new JPanel();
		tabbedPane.addTab("Kinos�le", null, panel_halls, null);
		panel_movies.setLayout(null);
		
		textField_movieInput = new JTextField();
		textField_movieInput.setBounds(10, 10, 142, 19);
		panel_movies.add(textField_movieInput);
		textField_movieInput.setColumns(10);
		
		this.btn_createMovie = new JButton("Film erstellen");
		this.btn_createMovie.setBounds(162, 9, 125, 21);
		panel_movies.add(this.btn_createMovie);
		
		this.movieListModel = new DefaultListModel<Movie>();
		this.list_movies = new JList<Movie>(this.movieListModel);
		
		JScrollPane listScroller = new JScrollPane(this.list_movies);
		listScroller.setBounds(10, 59, 277, 125);
		panel_movies.add(listScroller);
		
		this.btn_refreshMovieList = new JButton("Aktualisieren");
		this.btn_refreshMovieList.setBounds(297, 56, 142, 21);
		panel_movies.add(this.btn_refreshMovieList);
		
		this.btn_deleteSelectedMovies = new JButton("L�schen");
		this.btn_deleteSelectedMovies.setBounds(297, 87, 142, 21);
		panel_movies.add(this.btn_deleteSelectedMovies);
		
		

		
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
	public JButton getLogin() {
		return this.login;
	}
	
	
	public JLabel getRegisterUsername() {
		return registerUsername;
	}

	public JLabel getRegisterPassword() {
		return registerPassword;
	}

	public JLabel getRegisterEmail() {
		return registerEmail;
	}

	public JLabel getRegisterName() {
		return registerName;
	}

	public JButton getBtnRegisterUser() {
		return btnRegisterUser;
	}

	public JList<Movie> getListMovies() {
		return this.list_movies;
	}
	public DefaultListModel<Movie> getMovieListModel() {
		return this.movieListModel;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}
}
