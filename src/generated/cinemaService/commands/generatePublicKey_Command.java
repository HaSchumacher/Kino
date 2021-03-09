/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class generatePublicKey_Command extends ServiceCommand<Collection<Object>>{
   private static final long serialVersionUID = 1625899470L;
   public generatePublicKey_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().generatePublicKey();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
