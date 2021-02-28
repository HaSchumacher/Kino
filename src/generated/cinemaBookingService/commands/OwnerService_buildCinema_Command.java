/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class OwnerService_buildCinema_Command extends ObjectCommand<OwnerService, Void>{
   private static final long serialVersionUID = -398988636L;
   public OwnerService_buildCinema_Command(OwnerService receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.buildCinema();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
