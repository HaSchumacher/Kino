/**--- Generated at Thu Feb 25 15:08:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class reserve_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = 1300503148L;
   private String name;
   private Movie movie;
   private Integer seats;
   private String categorie;
   public reserve_Command(String name, Movie movie, Integer seats, String categorie){
      super();
      this.name = name;
      this.movie = movie;
      this.seats = seats;
      this.categorie = categorie;
   }
   public void execute(){
      try{this.result = CinemaBookingService.getInstance().reserve(name, movie, seats, categorie);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
