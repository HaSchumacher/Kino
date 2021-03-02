/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Filmprojection_constructor_Command extends ServiceCommand<Filmprojection>{
   private static final long serialVersionUID = 821775453L;
   private Cinemahall myHall;
   private Movie myMovie;
   public Filmprojection_constructor_Command(Cinemahall myHall, Movie myMovie){
      super();
      this.myHall = myHall;
      this.myMovie = myMovie;
   }
   public void execute(){
      try{this.result = Filmprojection.createFresh(myHall, myMovie);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
