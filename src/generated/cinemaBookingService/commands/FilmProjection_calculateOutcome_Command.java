/**--- Generated at Thu Feb 25 15:08:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class FilmProjection_calculateOutcome_Command extends ObjectCommand<FilmProjection, Integer>{
   private static final long serialVersionUID = 2032985303L;
   public FilmProjection_calculateOutcome_Command(FilmProjection receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.calculateOutcome();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
