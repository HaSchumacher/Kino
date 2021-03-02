/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class logout_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = 227229581L;
   private User user;
   public logout_Command(User user){
      super();
      this.user = user;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().logout(user);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
