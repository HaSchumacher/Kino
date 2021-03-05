/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class book_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = -1391741653L;
   private Reservation r;
   public book_Command(Reservation r){
      super();
      this.r = r;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().book(r);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
