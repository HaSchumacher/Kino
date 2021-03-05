/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class cancelReservation_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -279444260L;
   private Reservation r;
   public cancelReservation_Command(Reservation r){
      super();
      this.r = r;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().cancelReservation(r);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
