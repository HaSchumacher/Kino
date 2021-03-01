/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class changePriceCategory_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 336426816L;
   private PriceCategory c;
   private Integer price;
   public changePriceCategory_Command(PriceCategory c, Integer price){
      super();
      this.c = c;
      this.price = price;
   }
   public void execute(){
      try{CinemaService.getInstance().changePriceCategory(c, price);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
