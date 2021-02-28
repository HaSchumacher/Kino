/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class login_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = 2018160858L;
   private String username;
   private String password;
   public login_Command(String username, String password){
      super();
      this.username = username;
      this.password = password;
   }
   public void execute(){
      try{this.result = CinemaBookingService.getInstance().login(username, password);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
