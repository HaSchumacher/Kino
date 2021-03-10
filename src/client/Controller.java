package client;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import commands.Command;
import db.executer.PersistenceException;
import generated.cinemaService.CinemaService;
import generated.cinemaService.LoginError;
import generated.cinemaService.Movie;
import generated.cinemaService.RegisterError;
import generated.cinemaService.Role;
import generated.cinemaService.Unknown;
import generated.cinemaService.User;
import generated.cinemaService.commands.addMovie_Command;
import generated.cinemaService.commands.deleteMovie_Command;
import generated.cinemaService.proxies.MovieProxy;
import generated.cinemaService.proxies.UserProxy;
import observation.Observer;

public class Controller implements Observer {
	private CinemaService model;
	private View view;
	private Pipe myPipe;
	private User loggedUser;
	public Cipher cipher;

	public Controller(CinemaService m, View v, Pipe p) throws NoSuchAlgorithmException, NoSuchPaddingException, PersistenceException {
		this.model = m;
		this.view = v;
		this.myPipe = p;
		this.cipher = Cipher.getInstance("RSA");
		this.loggedUser = this.model.getUser(999);
		initView();
	}

	public void initView() throws PersistenceException   {
		
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
		view.getBtnLogin().addActionListener(e -> {
			try {
				this.login();
			} catch (InvalidKeyException | NoSuchAlgorithmException | PersistenceException | IllegalBlockSizeException
					| BadPaddingException | NoSuchPaddingException | LoginError | UnsupportedEncodingException e1) {
				System.out.println(e1);
			} 
		});
		view.getBtnRegister().addActionListener(e -> {
			try {
				this.registerUsertoCinema();
			} catch (PersistenceException | RegisterError | NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
		});
	}

	private void registerUsertoCinema() throws PersistenceException, RegisterError, NoSuchAlgorithmException {
		this.model.register(this.view.getTextFieldRegisterName().getText(),
				this.view.getTextFieldRegisterEmail().getText(), createHashValue(this.view.getTextFieldRegisterUsername().getText()),
				createHashValue(this.view.getTextFieldRegisterPassword().getText()));
		System.out.println("Registered= " + this.view.getTextFieldRegisterName().getText());
	}

	private void refreshMovieList() {
		this.view.getMovieListModel().clear();
		for (Iterator<MovieProxy> iterator = this.model.getMovieCache().values().iterator(); iterator.hasNext();) {
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
		for (Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
			try {
				this.myPipe.put(new deleteMovie_Command(iterator.next()));
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	private void login()
			throws NoSuchAlgorithmException, PersistenceException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchPaddingException, LoginError, UnsupportedEncodingException {
		ArrayList<Object> result = this.model.generatePublicKey();
		Integer id = (Integer) result.get(0);
		PublicKey publicKey = (PublicKey) result.get(1);
		String username = this.view.getTextFieldLoginUsername().getText();
		String userhash = createHashValue(username);
		byte[] uscrypt = encrypt(userhash, publicKey);
		String password = this.view.getTextFieldLoginPassword().getText();
		String passwordhash = createHashValue(password);
		byte[] pwcrypt = encrypt(passwordhash, publicKey);
		this.setLoggedUser(this.model.login(uscrypt, pwcrypt, id));
		//TODO neue View Laden.... anhand der Roles !
		updateView();
	}
	
	private void updateView() {
		this.view.getBtnLogin().getParent().setVisible(false);
		
	}

	private void logout() {
		updateView();
	}
	public static String createHashValue(String tohash) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] digest = md.digest(tohash.getBytes());
		StringBuilder hexString = new StringBuilder();

	    for (int i = 0; i < digest.length; i++) {
	        String hex = Integer.toHexString(0xFF & digest[i]);
	        if (hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }

	    return hexString.toString();
		}
	
	public static byte[] encrypt(String message, PublicKey pk) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pk);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		byte[] chiffrat = null;
		try {
			chiffrat = cipher.doFinal(message.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
		}
		return chiffrat;
	}
	
	@Override
	public void update(Command<?> command) {
		if (command instanceof addMovie_Command) {
			try {
				Movie result = (Movie) command.getResult();

				JOptionPane.showMessageDialog(null, "Film erstellt : " + result.getTitle(), "Info",
						JOptionPane.INFORMATION_MESSAGE);
				this.view.getTextFieldMovieInput().setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (command instanceof deleteMovie_Command) {
			try {
				command.getResult();
				JOptionPane.showMessageDialog(null, "Film gelöscht", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
}