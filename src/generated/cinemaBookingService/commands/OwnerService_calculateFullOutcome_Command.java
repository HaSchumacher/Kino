/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class OwnerService_calculateFullOutcome_Command extends ObjectCommand<OwnerService, Integer>{
   private static final long serialVersionUID = 1157039208L;
   public OwnerService_calculateFullOutcome_Command(OwnerService receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.calculateFullOutcome();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
