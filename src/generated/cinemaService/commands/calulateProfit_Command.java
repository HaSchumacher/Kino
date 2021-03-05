/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class calulateProfit_Command extends ServiceCommand<Integer>{
   private static final long serialVersionUID = -1605005030L;
   private Collection<Filmprojection> fp;
   public calulateProfit_Command(Collection<Filmprojection> fp){
      super();
      this.fp = fp;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().calulateProfit(fp);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
