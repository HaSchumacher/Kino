/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class book_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1616192437L;
   private Reservation r;
   public book_Command(Reservation r){
      super();
      this.r = r;
   }
   public void execute(){
      try{CinemaService.getInstance().book(r);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
