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
import generated.cinemaService.Admin;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Customer;
import generated.cinemaService.LoginError;
import generated.cinemaService.Movie;
import generated.cinemaService.RegisterError;
import generated.cinemaService.Role;
import generated.cinemaService.Unknown;
import generated.cinemaService.User;
import generated.cinemaService.commands.addMovie_Command;
import generated.cinemaService.commands.deleteMovie_Command;
import generated.cinemaService.commands.login_Command;
import generated.cinemaService.commands.logout_Command;
import generated.cinemaService.commands.register_Command;
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
		this.loggedUser = null;
		initView();
	}

	public void initView() throws PersistenceException   {
		updateView();
	}

	
	public void registerForEvents() {
		view.getBtn_createMovie().addActionListener(e -> {
			this.addMovie();
		});
		view.getBtn_refreshMovieList().addActionListener(e -> {
			this.refreshMovieList();
		});
		view.getBtn_deleteSelectedMovies().addActionListener(e -> {
			this.deleteSelectedMovies();
		});
		view.getBtn_login().addActionListener(e -> {
			try {
				this.login();
			} catch (InvalidKeyException | NoSuchAlgorithmException | PersistenceException | IllegalBlockSizeException
					| BadPaddingException | NoSuchPaddingException | LoginError | UnsupportedEncodingException | InterruptedException e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
			} 
		});
		view.getBtn_register().addActionListener(e -> {
			try {
				this.registerUserToCinema();
			} catch (PersistenceException | RegisterError | NoSuchAlgorithmException | InterruptedException e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		view.getBtn_logout().addActionListener(e -> {
			try {
				this.logout();
			} catch (PersistenceException | InterruptedException e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	@SuppressWarnings("deprecation")
	private void registerUserToCinema() throws PersistenceException, RegisterError, NoSuchAlgorithmException, InterruptedException {
		this.myPipe.put(
			new register_Command(
					this.view.getTextField_registerName().getText(),
					this.view.getTextField_registerEmail().getText(), 
					createHashValue(this.view.getTextField_registerUsername().getText()),
					createHashValue(this.view.getTextField_registerPassword().getText())

			)
		);
	}

	private void refreshMovieList() {
		this.view.getMovieListModel().clear();
		for (Iterator<MovieProxy> iterator = this.model.getMovieCache().values().iterator(); iterator.hasNext();) {
			this.view.getMovieListModel().addElement(iterator.next().getTheObject());
		}
	}

	private void addMovie() {
		try {
			this.myPipe.put(new addMovie_Command(this.view.getTextField_movieInput().getText()));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	private void deleteSelectedMovies() {
		List<Movie> movies = this.view.getList_movies().getSelectedValuesList();
		for (Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
			try {
				this.myPipe.put(new deleteMovie_Command(iterator.next()));
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void login()
			throws NoSuchAlgorithmException, PersistenceException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchPaddingException, LoginError, UnsupportedEncodingException, InterruptedException {
		ArrayList<Object> result = this.model.generatePublicKey();
		Integer id = (Integer) result.get(0);
		PublicKey publicKey = (PublicKey) result.get(1);
		String username = this.view.getTextField_loginUsername().getText();
		String userhash = createHashValue(username);
		byte[] uscrypt = encrypt(userhash, publicKey);
		String password = this.view.getTextField_loginPassword().getText();
		String passwordhash = createHashValue(password);
		byte[] pwcrypt = encrypt(passwordhash, publicKey);
		this.myPipe.put(new login_Command(uscrypt, pwcrypt, id));
	}

	private void logout() throws PersistenceException, InterruptedException {
		if(this.loggedUser != null) {
			this.myPipe.put(new logout_Command(this.loggedUser));
		} else {
			JOptionPane.showMessageDialog(null, "Kein User angemeldet...", "Error", JOptionPane.ERROR_MESSAGE);
		}
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
	
	private void updateView() throws PersistenceException {
		String currentUserName = "Nicht angemeldet";
		boolean showTickets = false;
		boolean showEditing = false;
		boolean showUsers = false;
		if(this.loggedUser != null) {
			currentUserName = "Angemeldet: " + this.loggedUser.getName();
			if(this.loggedUser.getMyRoles().contains(Customer.getInstance())) {
				showTickets = true;
				showEditing = false;
				showUsers = false;
			}
			if(this.loggedUser.getMyRoles().contains(Admin.getInstance())) {
				showTickets = true;
				showEditing = true;
				showUsers = true;
			}
		}
		this.view.getLabel_currentUser().setText(currentUserName);
		this.view.getBtnNavTickets().setVisible(showTickets);
		this.view.getBtnNavEditing().setVisible(showEditing);
		this.view.getBtnNavUsers().setVisible(showUsers);
	}
	
	@Override
	public void update(Command<?> command) {
		if( command instanceof login_Command) {
			try {
				this.setLoggedUser((User) command.getResult());
				this.updateView();
				this.view.getTextField_loginUsername().setText("");
				this.view.getTextField_loginPassword().setText("");
				JOptionPane.showMessageDialog(null, "Anmelden erfolgreich!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof logout_Command) {
			try {
				command.getResult();
				this.loggedUser = null;
				updateView();
				JOptionPane.showMessageDialog(null, "Ausloggen erfolgreich!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof register_Command) {
			try {
				this.setLoggedUser((User) command.getResult());
				this.updateView();
				this.view.getTextField_registerEmail().setText("");
				this.view.getTextField_registerName().setText("");
				this.view.getTextField_registerPassword().setText("");
				this.view.getTextField_registerUsername().setText("");
				JOptionPane.showMessageDialog(null, "Registrieren erfolgreich!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (command instanceof addMovie_Command) {
			try {
				Movie result = (Movie) command.getResult();

				JOptionPane.showMessageDialog(null, "Film erstellt : " + result.getTitle(), "Info",
						JOptionPane.INFORMATION_MESSAGE);
				this.view.getTextField_movieInput().setText("");
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