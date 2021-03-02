/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booking_constructor_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = 1048689949L;
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
