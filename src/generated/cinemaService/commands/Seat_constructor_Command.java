/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_constructor_Command extends ServiceCommand<Seat>{
   private static final long serialVersionUID = 439318132L;
   private Integer  number;
   private CinemaRow  myRow;
   public Seat_constructor_Command(Integer  number, CinemaRow  myRow){
      super();
      this.number = number;
      this.myRow = myRow;
   }
   public void execute(){
      try{this.result = Seat.createFresh(number, myRow);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}