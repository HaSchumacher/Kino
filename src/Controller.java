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

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import commands.Command;
import db.executer.PersistenceException;
import generated.cinemaService.CinemaService;
import generated.cinemaService.LoginError;
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
	private void login() throws NoSuchAlgorithmException, PersistenceException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, LoginError {
		ArrayList<String> result = this.model.generatePublicKey();
		Integer id = Integer.getInteger(result.get(0));
		String publicKey = result.get(1);
		String username = null;
		//verhashen
		String ushash = 
		String uscrypt = encrypt(username, publicKey).toString();
		String password = null;
		//verhashen
		String pwcrypt = encrypt(password, publicKey).toString();
		this.model.login(uscrypt, pwcrypt, id);
	}
	private byte[] encrypt(String arg, String pkey) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		 Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		 cipher.init(Cipher.ENCRYPT_MODE, getKey(pkey));
		 return cipher.doFinal(arg.getBytes());
		 
	}
	public static PublicKey getKey(String key){
	    try{
	    	byte[] byteKey = Base64.getDecoder().decode(key.getBytes());
	        X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
	        KeyFactory kf = KeyFactory.getInstance("RSA");
	        return kf.generatePublic(X509publicKey);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	    return null;
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
				JOptionPane.showMessageDialog(null, "Film gel�scht : " + result, "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}




	

 
}