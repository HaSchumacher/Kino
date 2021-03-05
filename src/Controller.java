import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import commands.Command;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Movie;
import generated.cinemaService.commands.addMovie_Command;
import generated.cinemaService.commands.deleteMovie_Command;
import generated.cinemaService.proxies.MovieProxy;
import observation.Observer;

public class Controller implements Observer {
	private CinemaService model;
	private View view;
	private Pipe myPipe;
	
	public Controller(CinemaService m, View v, Pipe p) {
		this.model = m;
		this.view = v;
		this.myPipe = p;
		initView();
	}
	
	public void initView() {

	}
 
	public void registerForEvents() {
		view.getBtnCreateMovie().addActionListener(e -> {
			this.addMovie();
		});
		view.getBtnRefreshMovieList().addActionListener(e -> {
			this.refreshMovieList();
		});
		view.getBtnDeleteSelectedMovie().addActionListener(e -> {
			this.deleteSelectedMovies();
		});
	}
	
	private void refreshMovieList() {
		this.view.getMovieListModel().clear();
		for(Iterator<MovieProxy> iterator = this.model.getMovieCache().values().iterator(); iterator.hasNext();) {
			this.view.getMovieListModel().addElement(iterator.next().getTheObject());
		}
	}
	private void addMovie() {
		try {
			this.myPipe.put(new addMovie_Command(this.view.getTextFieldMovieInput().getText()));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	private void deleteSelectedMovies() {
		List<Movie> movies = this.view.getListMovies().getSelectedValuesList();
		for(Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
			try {
				this.myPipe.put(new deleteMovie_Command(iterator.next()));
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public void update(Command<?> command) {
		if(command instanceof addMovie_Command) {
			try {
				addMovie_Command result = (addMovie_Command) command.getResult();
				JOptionPane.showMessageDialog(null, "Film erstellt : " + result, "Info", JOptionPane.INFORMATION_MESSAGE);
				this.view.getTextFieldMovieInput().setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(command instanceof deleteMovie_Command) {
			try {
				deleteMovie_Command result = (deleteMovie_Command) command.getResult();
				JOptionPane.showMessageDialog(null, "Film gelöscht : " + result, "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}




	

 
}