/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class calculateTotalProfit_Command extends ServiceCommand<Integer>{
   private static final long serialVersionUID = -1651873283L;
   public calculateTotalProfit_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().calculateTotalProfit();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
