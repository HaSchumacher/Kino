/**--- Generated at Thu Feb 25 15:08:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class OwnerService_buildCinema_Command extends ObjectCommand<OwnerService, Void>{
   private static final long serialVersionUID = -1007586737L;
   public OwnerService_buildCinema_Command(OwnerService receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.buildCinema();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
