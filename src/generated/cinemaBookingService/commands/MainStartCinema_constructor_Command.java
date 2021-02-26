/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class MainStartCinema_constructor_Command extends ServiceCommand<MainStartCinema>{
   private static final long serialVersionUID = -2016917188L;
   public MainStartCinema_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = MainStartCinema.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
