/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class CinemaRow_addSeat_Command extends ObjectCommand<CinemaRow, Void>{
   private static final long serialVersionUID = -1939129992L;
   private Seat seat;
   public CinemaRow_addSeat_Command(CinemaRow receiver, Seat seat){
      super(receiver);
      this.seat = seat;
   }
   public void execute(){
      try{this.receiver.addSeat(seat);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
