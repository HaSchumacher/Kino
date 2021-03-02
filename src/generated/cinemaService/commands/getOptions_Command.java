/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getOptions_Command extends ServiceCommand<String>{
   private static final long serialVersionUID = 379846925L;
   private User u;
   public getOptions_Command(User u){
      super();
      this.u = u;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getOptions(u);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
