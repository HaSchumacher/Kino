/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booking_constructor_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = -1729601039L;
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
