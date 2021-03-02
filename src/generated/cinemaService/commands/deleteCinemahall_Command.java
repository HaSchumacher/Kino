/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteCinemahall_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 701616028L;
   private Cinemahall c;
   public deleteCinemahall_Command(Cinemahall c){
      super();
      this.c = c;
   }
   public void execute(){
      try{CinemaService.getInstance().deleteCinemahall(c);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
