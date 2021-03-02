/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class book_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 1176824414L;
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
