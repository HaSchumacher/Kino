/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Filmprojection_calculateProfit_Command extends ObjectCommand<Filmprojection, Integer>{
   private static final long serialVersionUID = 829047331L;
   public Filmprojection_calculateProfit_Command(Filmprojection receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.calculateProfit();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
