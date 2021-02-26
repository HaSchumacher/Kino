/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Booking_constructor_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = 911054827L;
   private Reservation myReservation;
   public Booking_constructor_Command(Reservation myReservation){
      super();
      this.myReservation = myReservation;
   }
   public void execute(){
      try{this.result = Booking.createFresh(myReservation);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
