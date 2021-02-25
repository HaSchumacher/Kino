/**--- Generated at Thu Feb 25 15:23:55 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class FilmProjection_constructor_Command extends ServiceCommand<FilmProjection>{
   private static final long serialVersionUID = -1749200194L;
   private Cinemahall myCinemahall;
   private Movie myMovie;
   public FilmProjection_constructor_Command(Cinemahall myCinemahall, Movie myMovie){
      super();
      this.myCinemahall = myCinemahall;
      this.myMovie = myMovie;
   }
   public void execute(){
      try{this.result = FilmProjection.createFresh(myCinemahall, myMovie);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
