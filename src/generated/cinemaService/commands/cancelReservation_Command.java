/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class cancelReservation_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -2132818632L;
   private Reservation r;
   public cancelReservation_Command(Reservation r){
      super();
      this.r = r;
   }
   public void execute(){
      try{CinemaService.getInstance().cancelReservation(r);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
