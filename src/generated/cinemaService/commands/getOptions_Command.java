/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getOptions_Command extends ServiceCommand<String>{
   private static final long serialVersionUID = 313171086L;
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
