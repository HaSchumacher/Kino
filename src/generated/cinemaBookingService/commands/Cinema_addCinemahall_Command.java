/**--- Generated at Thu Feb 25 13:22:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Cinema_addCinemahall_Command extends ObjectCommand<Cinema, Void>{
   private static final long serialVersionUID = 296187750L;
   private Integer id;
   public Cinema_addCinemahall_Command(Cinema receiver, Integer id){
      super(receiver);
      this.id = id;
   }
   public void execute(){
      try{this.receiver.addCinemahall(id);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
