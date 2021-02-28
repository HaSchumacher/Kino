/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class BackRow_constructor_Command extends ServiceCommand<BackRow>{
   private static final long serialVersionUID = 1719924044L;
   private Integer  price;
   private Boolean  bookedUp;
   public BackRow_constructor_Command(Integer  price, Boolean  bookedUp){
      super();
      this.price = price;
      this.bookedUp = bookedUp;
   }
   public void execute(){
      try{this.result = BackRow.createFresh(price, bookedUp);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
