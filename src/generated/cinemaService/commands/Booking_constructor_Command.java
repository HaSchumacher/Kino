/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booking_constructor_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = 1763756092L;
   private Reservation myReservation;
   public Booking_constructor_Command(Reservation myReservation){
      super();
      this.myReservation = myReservation;
   }
   public void execute(){
      try{this.result = Booking.createFresh(myReservation);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
