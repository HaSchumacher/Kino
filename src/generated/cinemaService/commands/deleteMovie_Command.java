/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteMovie_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -2122940106L;
   private Movie m;
   public deleteMovie_Command(Movie m){
      super();
      this.m = m;
   }
   public void execute(){
      try{CinemaService.getInstance().deleteMovie(m);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
