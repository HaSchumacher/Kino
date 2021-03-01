/**--- Generated at Mon Mar 01 12:40:20 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addRoleToUser_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -1341203861L;
   private User u;
   private Role r;
   public addRoleToUser_Command(User u, Role r){
      super();
      this.u = u;
      this.r = r;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().addRoleToUser(u, r);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
