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
		JPanel panel_reservations = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_reservations, null);
		JPanel panel_movies = new JPanel();
		tabbedPane.addTab("Filme", null, panel_movies, null);
		JPanel panel_halls = new JPanel();
		tabbedPane.addTab("Kinosäle", null, panel_halls, null);
		JPanel panel_projections = new JPanel();
		tabbedPane.addTab("Aufführungen", null, panel_projections, null);
		JPanel panel_users = new JPanel();
		tabbedPane.addTab("User", null, panel_users, null);
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
		
		this.btn_deleteSelectedMovies = new JButton("Löschen");
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
}
