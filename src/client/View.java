package client;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JTextPane;

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
	private JPasswordField textField_loginPassword;
	private JButton btn_login;
	private JTextField textField_registerUsername;
	private JPasswordField textField_registerPassword;
	private JTextField textField_registerEmail;
	private JTextField textField_registerName;
	private JButton btn_register;
	private JScrollPane scrollPane_loggedUserReservations;
	private JScrollPane scrollPane_loggedUserBookings;
	private JList<Reservation> list_loggedUserReservations;
	private JList<Booking> list_loggedUserBookings;
	private JScrollPane FilmSelectionGroup;
	private List category;
	private JScrollPane CategorySelectionGroup;
	private JTextField nameforCinemahall;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 503);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.LIGHT_GRAY);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 10, 922, 455);
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
		
		this.textField_loginPassword = new JPasswordField(10);
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
		
		this.textField_registerPassword = new JPasswordField(10);
		textField_registerPassword.setFont(UIManager.getFont("PasswordField.font"));
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
		panel_projections.setLayout(null);
		
		FilmSelectionGroup = new JScrollPane();
		FilmSelectionGroup.setBounds(28, 23, 171, 90);
		panel_projections.add(FilmSelectionGroup);
		
		List Filmliste = new List();
		FilmSelectionGroup.setViewportView(Filmliste);
		
		JLabel selectionfilm = new JLabel("Bitte Wählen Sie einen Film aus.");
		FilmSelectionGroup.setColumnHeaderView(selectionfilm);
		
		CategorySelectionGroup = new JScrollPane();
		CategorySelectionGroup.setBounds(28, 119, 169, 95);
		panel_projections.add(CategorySelectionGroup);
		
		category = new List();
		CategorySelectionGroup.setViewportView(category);
		
		JLabel lblNewLabel = new JLabel("Wählen Sie nun Ihre Kategory.");
		CategorySelectionGroup.setColumnHeaderView(lblNewLabel);
		
		JButton btnreserveSeat = new JButton("Platz Reservieren");
		btnreserveSeat.setBounds(67, 219, 130, 21);
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
		btnCancelReservation.setBounds(297, 39, 139, 21);
		panel_reservations.add(btnCancelReservation);
		
		JButton btnBookReservation = new JButton("Reservierung buchen");
		btnBookReservation.setBounds(297, 93, 139, 21);
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
		
		JButton btncreateCinemahall = new JButton("Kinosaal erstellen.");
		btncreateCinemahall.setBounds(136, 165, 115, 21);
		panel_halls.add(btncreateCinemahall);
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
		listScroller_movies.setBounds(10, 59, 277, 84);
		panel_movies.add(listScroller_movies);
		
		this.btn_refreshMovieList = new JButton("Aktualisieren");
		this.btn_refreshMovieList.setBounds(297, 56, 142, 21);
		panel_movies.add(this.btn_refreshMovieList);
		
		this.btn_deleteSelectedMovies = new JButton("L�schen");
		this.btn_deleteSelectedMovies.setBounds(297, 87, 142, 21);
		panel_movies.add(this.btn_deleteSelectedMovies);
		
		Label lbselectMovie = new Label("Film Wählen");
		lbselectMovie.setBounds(10, 164, 114, 21);
		panel_movies.add(lbselectMovie);
		
		Choice SelectMovie = new Choice();
		SelectMovie.setBounds(10, 191, 142, 18);
		panel_movies.add(SelectMovie);
		
		Label lbCinemahallSelect = new Label("Kinosaal wählen");
		lbCinemahallSelect.setBounds(162, 164, 125, 21);
		panel_movies.add(lbCinemahallSelect);
		
		Choice SelectCinemahall = new Choice();
		SelectCinemahall.setBounds(162, 191, 125, 18);
		panel_movies.add(SelectCinemahall);
		
		JButton btnFilmProjection = new JButton("Filmaufführung erstellen");
		btnFilmProjection.setBounds(140, 239, 147, 21);
		panel_movies.add(btnFilmProjection);
		
		JPanel panel_Roles = new JPanel();
		tabbedPane.addTab("Rollen", null, panel_Roles, null);
		panel_Roles.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 169, 99);
		panel_Roles.add(scrollPane);
		
		JList<Movie> listUsers = new JList();
		scrollPane.setViewportView(listUsers);
		
		Label lbSelectUser = new Label("Benutzer auswählen");
		scrollPane.setColumnHeaderView(lbSelectUser);
		
		Choice chRoles = new Choice();
		chRoles.setBounds(238, 63, 167, 18);
		panel_Roles.add(chRoles);
		
		Label lbRoleSelection = new Label("Rolle wählen");
		lbRoleSelection.setBounds(238, 26, 167, 21);
		panel_Roles.add(lbRoleSelection);
		
		Button btnRole = new Button("neue Rolle zuweisen");
		btnRole.setBounds(175, 149, 197, 21);
		panel_Roles.add(btnRole);
		
		JPanel panel_Outcome = new JPanel();
		tabbedPane.addTab("Umsätze", null, panel_Outcome, null);
		panel_Outcome.setLayout(null);
		
		Choice chOutcomeOneFilm = new Choice();
		chOutcomeOneFilm.setBounds(117, 34, 86, 18);
		panel_Outcome.add(chOutcomeOneFilm);
		
		Label lbfilmprojection = new Label("Film auswählen");
		lbfilmprojection.setBounds(10, 31, 101, 21);
		panel_Outcome.add(lbfilmprojection);
		
		JLabel lbOutcomeOneFilm = new JLabel("Berechnung des Umsatzes für ein Film");
		lbOutcomeOneFilm.setBounds(10, 58, 175, 13);
		panel_Outcome.add(lbOutcomeOneFilm);
		
		Button btnOutcome = new Button("Berechne Umsatz");
		btnOutcome.setBounds(228, 34, 175, 21);
		panel_Outcome.add(btnOutcome);
		
		Label lbOutcometotal = new Label("Gesamt Umsatz berechnen");
		lbOutcometotal.setBounds(10, 106, 176, 21);
		panel_Outcome.add(lbOutcometotal);
		
		Button btnOutcomeTotal = new Button("Berechne Gesamt Umsatz");
		btnOutcomeTotal.setFont(UIManager.getFont("Button.font"));
		btnOutcomeTotal.setBounds(228, 106, 203, 21);
		panel_Outcome.add(btnOutcomeTotal);
		
		JTextPane txtforOneOutcome = new JTextPane();
		txtforOneOutcome.setEditable(false);
		txtforOneOutcome.setBounds(488, 34, 69, 19);
		panel_Outcome.add(txtforOneOutcome);
		
		JTextPane txtForTotalOutcome = new JTextPane();
		txtForTotalOutcome.setEditable(false);
		txtForTotalOutcome.setBounds(488, 106, 69, 19);
		panel_Outcome.add(txtForTotalOutcome);
		
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
