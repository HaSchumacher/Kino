/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class logout_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -1358134786L;
   private String username;
   public logout_Command(String username){
      super();
      this.username = username;
   }
   public void execute(){
      try{this.result = CinemaBookingService.getInstance().logout(username);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
