import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import db.executer.PersistenceException;
import generated.cinemaService.DeleteError;
import generated.cinemaService.Movie;
import generated.cinemaService.proxies.MovieProxy;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model m, View v) {
		model = m;
		view = v;
		initView();
	}
	
	public void initView() {

	}
 
	public void initController() {
		view.getBtnCreateMovie().addActionListener(e -> {
			this.addFilm();
		});
		view.getBtnRefreshMovieList().addActionListener(e -> {
			this.refreshMovieList();
		});
		view.getBtnDeleteSelectedMovie().addActionListener(e -> {
			this.deleteSelectedMovies();
		});
	}
 
	private void addFilm() {
		try {
			this.model.getService().addMovie(this.view.getTextFieldMovieInput().getText());
		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Filme erstellt : " + this.view.getTextFieldMovieInput().getText(), "Info", JOptionPane.INFORMATION_MESSAGE);
		this.view.getTextFieldMovieInput().setText("");
	}
	private void refreshMovieList() {
		this.view.getMovieListModel().clear();
		for(Iterator<MovieProxy> iterator = this.model.getService().getMovieCache().values().iterator(); iterator.hasNext();) {
			this.view.getMovieListModel().addElement(iterator.next().getTheObject());
		}
	}
	private void deleteSelectedMovies() {
		List<Movie> movies = this.view.getListMovies().getSelectedValuesList();
		for(Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
			try {
				this.model.getService().deleteMovie(iterator.next());
			} catch (DeleteError e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "Filme gelöscht : " + movies, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
 
}