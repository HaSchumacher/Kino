/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.commands;
import generated.cinemaBookingService.*;
import commands.*;
public class MiddleRow_constructor_Command extends ServiceCommand<MiddleRow>{
   private static final long serialVersionUID = 1204409536L;
   private Integer  price;
   private Boolean  bookedUp;
   public MiddleRow_constructor_Command(Integer  price, Boolean  bookedUp){
      super();
      this.price = price;
      this.bookedUp = bookedUp;
   }
   public void execute(){
      try{this.result = MiddleRow.createFresh(price, bookedUp);
      }catch(Exception e){this.e = e;
      }finally{CinemaBookingService.getInstance().notifyObservers(this);}
   }
}
