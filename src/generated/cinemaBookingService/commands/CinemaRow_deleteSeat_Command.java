/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class CinemaRow_deleteSeat_Command extends ObjectCommand<CinemaRow, Boolean>{
   private static final long serialVersionUID = -5353964L;
   private Seat seat;
   public CinemaRow_deleteSeat_Command(CinemaRow receiver, Seat seat){
      super(receiver);
      this.seat = seat;
   }
   public void execute(){
      try{this.result = this.receiver.deleteSeat(seat);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
