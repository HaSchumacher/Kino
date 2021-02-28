/**--- Generated at Sun Feb 28 16:02:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteCinemahall_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -1025308583L;
   private Cinemahall c;
   public deleteCinemahall_Command(Cinemahall c){
      super();
      this.c = c;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().deleteCinemahall(c);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
