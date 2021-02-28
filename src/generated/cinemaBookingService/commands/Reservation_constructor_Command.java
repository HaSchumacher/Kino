/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Reservation_constructor_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = 386884784L;
   private Seat mySeat;
   private FilmProjection myfilmprojection;
   public Reservation_constructor_Command(Seat mySeat, FilmProjection myfilmprojection){
      super();
      this.mySeat = mySeat;
      this.myfilmprojection = myfilmprojection;
   }
   public void execute(){
      try{this.result = Reservation.createFresh(mySeat, myfilmprojection);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
