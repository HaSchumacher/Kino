/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class book_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = -733404411L;
   private Integer reservation_id;
   public book_Command(Integer reservation_id){
      super();
      this.reservation_id = reservation_id;
   }
   public void execute(){
      try{this.result = CinemaBookingService.getInstance().book(reservation_id);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
