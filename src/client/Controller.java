package client;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import commands.Command;
import db.executer.PersistenceException;
import generated.cinemaService.CinemaService;
import generated.cinemaService.LoginError;
import generated.cinemaService.Movie;
import generated.cinemaService.RegisterError;
import generated.cinemaService.User;
import generated.cinemaService.commands.addMovie_Command;
import generated.cinemaService.commands.deleteMovie_Command;
import generated.cinemaService.proxies.MovieProxy;
import observation.Observer;

public class Controller implements Observer {
	private CinemaService model;
	private View view;
	private Pipe myPipe;
	private User loggedUser;
	public Cipher cipher;

	public Controller(CinemaService m, View v, Pipe p) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.model = m;
		this.view = v;
		this.myPipe = p;
		this.cipher = Cipher.getInstance("RSA");
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
		view.getBtnLogin().addActionListener(e -> {
			try {
				this.login();
			} catch (InvalidKeyException | NoSuchAlgorithmException | PersistenceException | IllegalBlockSizeException
					| BadPaddingException | NoSuchPaddingException | LoginError e1) {
				System.out.println(e1);
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBtnRegister().addActionListener(e -> {
			try {
				this.registerUsertoCinema();
			} catch (PersistenceException | RegisterError e1) {
				System.out.println(e1);
			}
		});
	}

	private void registerUsertoCinema() throws PersistenceException, RegisterError {
		this.model.register(this.view.getTextFieldRegisterName().getText(),
				this.view.getTextFieldRegisterEmail().getText(), this.view.getTextFieldRegisterUsername().getText(),
				this.view.getTextFieldRegisterPassword().getText());
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
		// verhashen
		byte[] uscrypt = encrypt(username, publicKey);

		System.out.println("username login: " + uscrypt);
		String password = this.view.getTextFieldLoginPassword().getText();
		// verhashen
		byte[] pwcrypt = encrypt(password, publicKey);
		System.out.println("password login: " + pwcrypt);
		this.loggedUser = this.model.login(uscrypt, pwcrypt, id);
	}

	public static byte[] encrypt(String message, PublicKey pk) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pk);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] chiffrat = null;
		try {
			chiffrat = cipher.doFinal(message.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}