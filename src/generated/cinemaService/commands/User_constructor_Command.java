/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class User_constructor_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 1905752256L;
   private String  name;
   private String  email;
   private String  username;
   private String  password;
   public User_constructor_Command(String  name, String  email, String  username, String  password){
      super();
      this.name = name;
      this.email = email;
      this.username = username;
      this.password = password;
   }
   public void execute(){
      try{this.result = User.createFresh(name, email, username, password);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
