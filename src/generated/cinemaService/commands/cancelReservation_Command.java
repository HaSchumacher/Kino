/**--- Generated at Sun Mar 14 13:22:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class cancelReservation_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = 1799944930L;
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
