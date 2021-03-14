/**--- Generated at Sun Mar 14 13:22:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class reserve_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = 1254516339L;
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
      try{this.result = CinemaService.getInstance().reserve(u, fp, c);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
