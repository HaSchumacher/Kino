/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class OwnerService_calculateOutcome_Command extends ObjectCommand<OwnerService, Integer>{
   private static final long serialVersionUID = -698266477L;
   private FilmProjection ofFilm;
   public OwnerService_calculateOutcome_Command(OwnerService receiver, FilmProjection ofFilm){
      super(receiver);
      this.ofFilm = ofFilm;
   }
   public void execute(){
      try{this.result = this.receiver.calculateOutcome(ofFilm);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
