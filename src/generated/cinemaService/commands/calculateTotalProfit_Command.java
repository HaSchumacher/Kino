/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class calculateTotalProfit_Command extends ServiceCommand<Integer>{
   private static final long serialVersionUID = -352481900L;
   public calculateTotalProfit_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().calculateTotalProfit();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
