/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addRoleToUser_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -1101656452L;
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
