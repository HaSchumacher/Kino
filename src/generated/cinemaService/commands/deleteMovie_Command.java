/**--- Generated at Sun Feb 28 15:10:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteMovie_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = 1814281859L;
   private Movie m;
   public deleteMovie_Command(Movie m){
      super();
      this.m = m;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().deleteMovie(m);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
