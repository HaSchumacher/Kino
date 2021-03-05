/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class CinemaRow_constructor_Command extends ServiceCommand<CinemaRow>{
   private static final long serialVersionUID = -868213068L;
   private PriceCategory priceCategory;
   private Integer  number;
   private Boolean  bookedUp;
   public CinemaRow_constructor_Command(PriceCategory priceCategory, Integer  number, Boolean  bookedUp){
      super();
      this.priceCategory = priceCategory;
      this.number = number;
      this.bookedUp = bookedUp;
   }
   public void execute(){
      try{this.result = CinemaRow.createFresh(priceCategory, number, bookedUp);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
