/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class login_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 2039713797L;
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
