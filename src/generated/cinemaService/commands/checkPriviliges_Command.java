/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class checkPriviliges_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = 552630648L;
   private User u;
   public checkPriviliges_Command(User u){
      super();
      this.u = u;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().checkPriviliges(u);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
