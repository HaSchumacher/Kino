/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getOptions_Command extends ServiceCommand<Collection<String>>{
   private static final long serialVersionUID = 1976947545L;
   private Role r;
   public getOptions_Command(Role r){
      super();
      this.r = r;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getOptions(r);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
