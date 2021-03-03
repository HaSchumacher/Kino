import java.util.Iterator;
import java.util.Scanner;

import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.cinemaService.Back;
import generated.cinemaService.CinemaHallCreation;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.Front;
import generated.cinemaService.LoginError;
import generated.cinemaService.Middle;
import generated.cinemaService.PriceCategory;
import generated.cinemaService.User;
import generated.cinemaService.proxies.CinemahallProxy;

public class StartCinemaService {

	public static void main(String[] args) throws CinemaHallCreation, PersistenceException, ConstraintViolation, LoginError {
		CinemaService service = CinemaService.getInstance();
		
		service.addCinemahall("test", 6, 4);
		
		for(Iterator<CinemahallProxy> iterator = service.getCinemahallCache().values().iterator(); iterator.hasNext();) {
			String name = iterator.next().getTheObject().getName();
			System.out.println(name);
		}
		
		System.out.println("finished");
		/**
		Scanner choose = new Scanner(System.in);
	    String choice= null;
	    int j = 0;
	    while (!"end".equals(choice)) {
	        System.out.println("\nType 1, 2, or 3 and press enter to interact with the CinemaService."
	        		+"\n1: Login in your UserAccount"
	        		+"\n2: See all Filmprojections reservable in this cinema."
	        		
	        		+ "\nTo end the program type \"end\".");
	        choice = choose.nextLine();
	        if ("1".equals(choice)) {
	           //calculation code
	        	System.out.println("\nPlease type your username:");
	        	String username = choose.nextLine();
	        	System.out.println("\n Now you can type your password:");
	        	String password = choose.nextLine();
	        	service.login(username, password);
	        	System.out.println("\n now you are succesfully loged in.");
	        	//TODO new Menü
	        	choice = null;
	        }
	        if ("2".equals(choice)) {
	           System.out.println(service.getFilmprojectionCache().values().toString());     
	        }
	        if ("3".equals(choice)) {
	                if (j < 29) {
	                    System.out.println("Press enter to get the mortgage information for year " + (j + 2));
	                    choice = choose.nextLine();
	                } else {
	                    System.out.println("Congratulations, your mortgage has been paid off.");
	                }
	            choice = null;
	        }
	    }
	    choose.close();
	    **/
	}

}
