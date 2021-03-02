/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Reservation;
import java.sql.ResultSet;
import generated.cinemaService.Seat;
import generated.cinemaService.relationControl.Reservation_SeatSupervisor;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.relationControl.Reservation_FpSupervisor;
import generated.cinemaService.User;
import generated.cinemaService.relationControl.Reservation_UserSupervisor;
import generated.cinemaService.Booking;
import java.util.Set;
public class ReservationProxy implements IReservation{
   private Integer id;
   private Optional<Reservation> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReservationProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservationProxy(Reservation theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reservation getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reservation";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reservation load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reservation", this.id);
         Seat mySeat = Reservation_SeatSupervisor.getInstance().getMySeat(this).getTheObject();
         Filmprojection myFilmprojection = Reservation_FpSupervisor.getInstance().getMyFilmprojection(this).getTheObject();
         User myCustomer = Reservation_UserSupervisor.getInstance().getMyCustomer(this).getTheObject();
         return Reservation.createAlreadyPersistent(this, mySeat, myFilmprojection, myCustomer);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Seat getMySeat() throws PersistenceException{
      return this.getTheObject().getMySeat();
   }
   public void setMySeat(Seat newMySeat)throws PersistenceException{
      this.getTheObject().setMySeat(newMySeat);
   }
   public Filmprojection getMyFilmprojection() throws PersistenceException{
      return this.getTheObject().getMyFilmprojection();
   }
   public void setMyFilmprojection(Filmprojection newMyFilmprojection)throws PersistenceException{
      this.getTheObject().setMyFilmprojection(newMyFilmprojection);
   }
   public User getMyCustomer() throws PersistenceException{
      return this.getTheObject().getMyCustomer();
   }
   public void setMyCustomer(User newMyCustomer)throws PersistenceException{
      this.getTheObject().setMyCustomer(newMyCustomer);
   }
   public Set<Booking> getMyBooking() throws PersistenceException{
      return this.getTheObject().getMyBooking();
   }
}
