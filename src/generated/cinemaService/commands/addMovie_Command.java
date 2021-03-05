/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addMovie_Command extends ServiceCommand<Movie>{
   private static final long serialVersionUID = 801170260L;
   private String title;
   public addMovie_Command(String title){
      super();
      this.title = title;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().addMovie(title);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
