import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import generated.cinemaService.Booking;
import generated.cinemaService.Movie;
import generated.cinemaService.Reservation;

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
	private JTextField textField_loginUsername;
	private JTextField textField_loginPassword;
	private JButton btn_login;
	private JTextField textField_registerUsername;
	private JTextField textField_registerPassword;
	private JTextField textField_registerEmail;
	private JTextField textField_registerName;
	private JButton btn_register;
	private JScrollPane scrollPane_loggedUserReservations;
	private JScrollPane scrollPane_loggedUserBookings;
	private JList<Reservation> list_loggedUserReservations;
	private JList<Booking> list_loggedUserBookings;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 749);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.LIGHT_GRAY);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 10, 1166, 679);
		this.contentPane.add(tabbedPane);
		
		JPanel panel_users = new JPanel();
		tabbedPane.addTab("User", null, panel_users, null);
		
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
		
		this.textField_loginPassword = new JTextField();
		this.textField_loginPassword.setBounds(95, 65, 102, 32);
		this.textField_loginPassword.setHorizontalAlignment(SwingConstants.LEFT);
		this.textField_loginPassword.setToolTipText("Please Insert your Password here.");
		this.textField_loginPassword.setColumns(10);
		panel_users.setLayout(null);
		panel_users.add(label_loginUsername);
		panel_users.add(textField_loginUsername);
		
		panel_users.add(label_loginPassword);
		panel_users.add(textField_loginPassword);
		
		this.btn_login = new JButton("Login");
		this.btn_login.setBounds(112, 128, 85, 21);
		panel_users.add(this.btn_login);
		
		this.textField_registerUsername = new JTextField();
		this.textField_registerUsername.setBounds(305, 250, 102, 30);
		this.textField_registerUsername.setColumns(10);
		panel_users.add(textField_registerUsername);

		JLabel label_registerUsername = new JLabel("Username");
		label_registerUsername.setBounds(220, 250, 75, 30);
		panel_users.add(label_registerUsername);
		
		JLabel label_registerPassword = new JLabel("Password");
		label_registerPassword.setBounds(10, 250, 75, 30);
		panel_users.add(label_registerPassword);
		
		this.textField_registerPassword = new JTextField();
		this.textField_registerPassword.setColumns(10);
		this.textField_registerPassword.setBounds(95, 250, 102, 30);
		panel_users.add(textField_registerPassword);
		
		JLabel label_registerEmail = new JLabel("Email");
		label_registerEmail.setBounds(220, 203, 75, 30);
		panel_users.add(label_registerEmail);
		
		this.textField_registerEmail = new JTextField();
		this.textField_registerEmail.setColumns(10);
		this.textField_registerEmail.setBounds(305, 203, 102, 30);
		panel_users.add(textField_registerEmail);
		
		JLabel label_registerName = new JLabel("Name");
		label_registerName.setBounds(10, 210, 75, 30);
		panel_users.add(label_registerName);
		
		this.textField_registerName = new JTextField();
		this.textField_registerName.setColumns(10);
		this.textField_registerName.setBounds(95, 210, 102, 30);
		panel_users.add(textField_registerName);
		
		this.btn_register = new JButton("Register");
		this.btn_register.setBounds(192, 330, 85, 21);
		panel_users.add(btn_register);
		JPanel panel_projections = new JPanel();
		tabbedPane.addTab("Auff�hrungen", null, panel_projections, null);
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
		JPanel panel_movies = new JPanel();
		tabbedPane.addTab("Filme", null, panel_movies, null);
		JPanel panel_halls = new JPanel();
		tabbedPane.addTab("Kinos�le", null, panel_halls, null);
		panel_movies.setLayout(null);
		
		this.textField_movieInput = new JTextField();
		this.textField_movieInput.setBounds(10, 10, 142, 19);
		panel_movies.add(this.textField_movieInput);
		this.textField_movieInput.setColumns(10);
		
		this.btn_createMovie = new JButton("Film erstellen");
		this.btn_createMovie.setBounds(162, 9, 125, 21);
		panel_movies.add(this.btn_createMovie);
		
		this.movieListModel = new DefaultListModel<Movie>();
		this.list_movies = new JList<Movie>(this.movieListModel);
		
		JScrollPane listScroller_movies = new JScrollPane(this.list_movies);
		listScroller_movies.setBounds(10, 59, 277, 125);
		panel_movies.add(listScroller_movies);
		
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

}
