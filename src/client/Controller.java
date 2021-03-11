package client;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import commands.Command;
import db.executer.PersistenceException;
import generated.cinemaService.Admin;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.Customer;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.LoginError;
import generated.cinemaService.Movie;
import generated.cinemaService.RegisterError;
import generated.cinemaService.Role;
import generated.cinemaService.User;
import generated.cinemaService.commands.addCinemahall_Command;
import generated.cinemaService.commands.addFilmprojection_Command;
import generated.cinemaService.commands.addMovie_Command;
import generated.cinemaService.commands.addRoleToUser_Command;
import generated.cinemaService.commands.calculateTotalProfit_Command;
import generated.cinemaService.commands.calulateProfit_Command;
import generated.cinemaService.commands.deleteCinemahall_Command;
import generated.cinemaService.commands.deleteFilmprojection_Command;
import generated.cinemaService.commands.deleteMovie_Command;
import generated.cinemaService.commands.deleteRoleFromUser_Command;
import generated.cinemaService.commands.login_Command;
import generated.cinemaService.commands.logout_Command;
import generated.cinemaService.commands.register_Command;
import generated.cinemaService.proxies.CinemahallProxy;
import generated.cinemaService.proxies.FilmprojectionProxy;
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
		view.getBtn_refreshProjections().addActionListener(e -> {
			this.refreshProjectionListCustomer();
		});
		view.getBtn_createMovie().addActionListener(e -> {
			this.addMovie();
		});
		view.getBtn_refreshMovieList().addActionListener(e -> {
			this.refreshMovieList();
		});
		view.getBtn_deleteSelectedMovies().addActionListener(e -> {
			this.deleteSelectedMovies();
		});
		view.getBtn_createHall().addActionListener(e -> {
			this.addHall();
		});
		view.getBtn_refreshHallList().addActionListener(e -> {
			this.refreshHallList();
		});
		view.getBtn_deleteSelectedHall().addActionListener(e -> {
			this.deleteSelectedHall();
		});
		view.getBtn_createProjection().addActionListener(e -> {
			this.addProjection();
		});
		view.getBtn_refreshProjectionList().addActionListener(e -> {
			this.refreshProjectionList();
		});
		view.getBtn_deleteProjection().addActionListener(e -> {
			this.deleteSelectedProjection();
		});
		view.getBtn_calculateProfit().addActionListener(e -> {
			this.calculateProfit();
		});
		view.getBtn_calculateTotalProfit().addActionListener(e -> {
			this.calculateTotalProfit();
		});
		view.getBtn_refreshUserList().addActionListener(e -> {
			this.refreshUserList();
		});
		view.getBtn_addRole().addActionListener(e -> {
			this.addRoleToUser();
		});
		view.getBtn_removeRole().addActionListener(e -> {
			this.removeRoleFromUser();
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

	private void calculateTotalProfit() {
		try {
			this.myPipe.put(new calculateTotalProfit_Command());
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}

	private void calculateProfit() {
		try {
			this.myPipe.put(new calulateProfit_Command(
					this.view.getList_projections().getSelectedValuesList()
			));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
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
	
	private void addRoleToUser() {
		Map<String, Role> roles = new HashMap<String,Role>();
		try {
			roles.put("Admin", Admin.getInstance());
		} catch (PersistenceException e2) {
			System.out.println(e2);
		}
		try {
			roles.put("Customer", Customer.getInstance());
		} catch (PersistenceException e1) {
			System.out.println(e1);
		}
		try {
			this.myPipe.put(new addRoleToUser_Command(
					this.view.getList_users().getSelectedValue(),
					roles.get(this.view.getComboBox_roles().getSelectedItem().toString())
			));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	private void removeRoleFromUser() {
		Map<String, Role> roles = new HashMap<String,Role>();
		try {
			roles.put("Admin", Admin.getInstance());
		} catch (PersistenceException e2) {
			System.out.println(e2);
		}
		try {
			roles.put("Customer", Customer.getInstance());
		} catch (PersistenceException e1) {
			System.out.println(e1);
		}
		try {
			this.myPipe.put(new deleteRoleFromUser_Command(
					this.view.getList_users().getSelectedValue(),
					roles.get(this.view.getComboBox_roles().getSelectedItem().toString())
			));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	private void refreshUserList() {
		this.view.getUsersListModel().clear();
		for (Iterator<UserProxy> iterator = this.model.getUserCache().values().iterator(); iterator.hasNext();) {
			this.view.getUsersListModel().addElement(iterator.next().getTheObject());
		}
	}

	private void refreshMovieList() {
		this.view.getMovieListModel().clear();
		for (Iterator<MovieProxy> iterator = this.model.getMovieCache().values().iterator(); iterator.hasNext();) {
			this.view.getMovieListModel().addElement(iterator.next().getTheObject());
		}
	}
	
	private void refreshHallList() {
		this.view.getHallListModel().clear();
		for (Iterator<CinemahallProxy> iterator = this.model.getCinemahallCache().values().iterator(); iterator.hasNext();) {
			this.view.getHallListModel().addElement(iterator.next().getTheObject());
		}
	}
	
	private void refreshProjectionList() {
		this.view.getProjectionListModel().clear();
		for (Iterator<FilmprojectionProxy> iterator = this.model.getFilmprojectionCache().values().iterator(); iterator.hasNext();) {
			this.view.getProjectionListModel().addElement(iterator.next().getTheObject());
		}
	}
	
	private void refreshProjectionListCustomer() {
		this.view.getProjectionListModelCustomer().clear();
		for (Iterator<FilmprojectionProxy> iterator = this.model.getFilmprojectionCache().values().iterator(); iterator.hasNext();) {
			this.view.getProjectionListModelCustomer().addElement(iterator.next().getTheObject());
		}
	}

	private void addMovie() {
		try {
			this.myPipe.put(new addMovie_Command(this.view.getTextField_movieInput().getText()));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	private void addHall() {
		try {
			this.myPipe.put(new addCinemahall_Command(
				this.view.getTextField_hallName().getText(),
				(Integer) this.view.getComboBox_hallRows().getSelectedItem(),
				(Integer) this.view.getComboBox_hallSeats().getSelectedItem()
			));
		} catch (InterruptedException e) {
			System.out.println(e);
		}	
	}
	
	private void addProjection() {
		try {
			this.myPipe.put(new addFilmprojection_Command(
				this.view.getList_halls().getSelectedValue(),
				this.view.getList_movies().getSelectedValue()
			));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
	private void deleteSelectedHall() {
		try {
			this.myPipe.put(new deleteCinemahall_Command(this.view.getList_halls().getSelectedValue()));
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
	
	private void deleteSelectedProjection() {
		try {
			this.myPipe.put(new deleteFilmprojection_Command(
				this.view.getList_projections().getSelectedValue()
			));
		} catch (InterruptedException e) {
			System.out.println(e);
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
		if( command instanceof addCinemahall_Command) {
			try {
				Cinemahall result = (Cinemahall) command.getResult();
				JOptionPane.showMessageDialog(null, "Saal erstellt : " + result.getName(), "Info",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof deleteCinemahall_Command) {
			try {
				command.getResult();
				JOptionPane.showMessageDialog(null, "Saal gelöscht", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (command instanceof addFilmprojection_Command) {
			try {
				Filmprojection result = (Filmprojection) command.getResult();
				JOptionPane
						.showMessageDialog(
								null, "Filmaufführung erstellt: " + " Saal -> " + result.getMyHall().getName()
										+ " Film -> " + result.getMyMovie().getTitle(),
								"Info", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof deleteFilmprojection_Command) {
			try {
				command.getResult();
				JOptionPane.showMessageDialog(null, "Filmaufführung gelöscht", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof calulateProfit_Command) {
			try {
				Integer result = (Integer) command.getResult();
				JOptionPane.showMessageDialog(null, "Umsatz: " + result, "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof calculateTotalProfit_Command) {
			try {
				Integer result = (Integer) command.getResult();
				JOptionPane.showMessageDialog(null, "Gesamter Umsatz: " + result, "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof addRoleToUser_Command) {
			try {
				command.getResult();
				JOptionPane.showMessageDialog(null, "Rolle hinzugefügt", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if( command instanceof deleteRoleFromUser_Command) {
			try {
				command.getResult();
				JOptionPane.showMessageDialog(null, "Rolle entfernt", "Info", JOptionPane.INFORMATION_MESSAGE);
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