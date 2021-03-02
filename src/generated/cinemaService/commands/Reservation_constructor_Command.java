/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reservation_constructor_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = 1790467660L;
   private Seat mySeat;
   private Filmprojection myFilmprojection;
   private User myCustomer;
   public Reservation_constructor_Command(Seat mySeat, Filmprojection myFilmprojection, User myCustomer){
      super();
      this.mySeat = mySeat;
      this.myFilmprojection = myFilmprojection;
      this.myCustomer = myCustomer;
   }
   public void execute(){
      try{this.result = Reservation.createFresh(mySeat, myFilmprojection, myCustomer);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
