/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class Cinemahall_constructor_Command extends ServiceCommand<Cinemahall>{
   private static final long serialVersionUID = -2027740777L;
   private Boolean  open;
   public Cinemahall_constructor_Command(Boolean  open){
      super();
      this.open = open;
   }
   public void execute(){
      try{this.result = Cinemahall.createFresh(open);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
