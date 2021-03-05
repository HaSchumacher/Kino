/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class login_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 1350021763L;
   private String username;
   private String password;
   private Integer id;
   public login_Command(String username, String password, Integer id){
      super();
      this.username = username;
      this.password = password;
      this.id = id;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().login(username, password, id);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
