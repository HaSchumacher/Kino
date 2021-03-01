/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class cancelReservation_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -147845809L;
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
