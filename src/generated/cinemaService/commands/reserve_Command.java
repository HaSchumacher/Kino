/**--- Generated at Mon Mar 01 12:40:20 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class reserve_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 585848143L;
   private User u;
   private Filmprojection fp;
   private PriceCategory c;
   public reserve_Command(User u, Filmprojection fp, PriceCategory c){
      super();
      this.u = u;
      this.fp = fp;
      this.c = c;
   }
   public void execute(){
      try{CinemaService.getInstance().reserve(u, fp, c);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
