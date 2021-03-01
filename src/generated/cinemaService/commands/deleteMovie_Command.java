/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class deleteMovie_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -273204457L;
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
