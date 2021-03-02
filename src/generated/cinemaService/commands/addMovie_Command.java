/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addMovie_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1267814276L;
   private String title;
   public addMovie_Command(String title){
      super();
      this.title = title;
   }
   public void execute(){
      try{CinemaService.getInstance().addMovie(title);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
