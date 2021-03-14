/**--- Generated at Sun Mar 14 13:22:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class register_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = -880712126L;
   private String name;
   private String mail;
   private String username;
   private String passwort;
   public register_Command(String name, String mail, String username, String passwort){
      super();
      this.name = name;
      this.mail = mail;
      this.username = username;
      this.passwort = passwort;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().register(name, mail, username, passwort);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
