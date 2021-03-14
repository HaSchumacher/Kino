/**--- Generated at Sun Mar 14 13:22:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reservation_constructor_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = -1158602337L;
   private Seat mySeat;
   private Filmprojection myFilmprojection;
   private User myCustomer;
   private Boolean  deleted;
   private Boolean  booked;
   public Reservation_constructor_Command(Seat mySeat, Filmprojection myFilmprojection, User myCustomer, Boolean  deleted, Boolean  booked){
      super();
      this.mySeat = mySeat;
      this.myFilmprojection = myFilmprojection;
      this.myCustomer = myCustomer;
      this.deleted = deleted;
      this.booked = booked;
   }
   public void execute(){
      try{this.result = Reservation.createFresh(mySeat, myFilmprojection, myCustomer, deleted, booked);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
