/**--- Generated at Fri Mar 05 15:48:47 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class generatePublicKey_Command extends ServiceCommand<Collection<String>>{
   private static final long serialVersionUID = 553828758L;
   public generatePublicKey_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().generatePublicKey();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
