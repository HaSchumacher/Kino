/**--- Generated at Thu Feb 25 15:08:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class OwnerService_deleteGivenFilmFromCinemahall_Command extends ObjectCommand<OwnerService, Boolean>{
   private static final long serialVersionUID = 1014369879L;
   private Movie movie;
   public OwnerService_deleteGivenFilmFromCinemahall_Command(OwnerService receiver, Movie movie){
      super(receiver);
      this.movie = movie;
   }
   public void execute(){
      try{this.result = this.receiver.deleteGivenFilmFromCinemahall(movie);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
