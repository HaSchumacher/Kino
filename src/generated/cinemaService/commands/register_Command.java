/**--- Generated at Mon Mar 01 12:40:20 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class register_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 648537153L;
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
      try{CinemaService.getInstance().register(name, mail, username, passwort);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}