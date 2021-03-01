/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getOptions_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -542779545L;
   private User u;
   public getOptions_Command(User u){
      super();
      this.u = u;
   }
   public void execute(){
      try{CinemaService.getInstance().getOptions(u);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
