/**--- Generated at Thu Feb 25 13:22:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Cinemahall_addRow_Command extends ObjectCommand<Cinemahall, Void>{
   private static final long serialVersionUID = -1142629783L;
   private String row;
   public Cinemahall_addRow_Command(Cinemahall receiver, String row){
      super(receiver);
      this.row = row;
   }
   public void execute(){
      try{this.receiver.addRow(row);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
