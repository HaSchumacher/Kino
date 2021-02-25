/**--- Generated at Thu Feb 25 15:08:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Seat_getPrice_Command extends ObjectCommand<Seat, Integer>{
   private static final long serialVersionUID = -1060864195L;
   public Seat_getPrice_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPrice();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
