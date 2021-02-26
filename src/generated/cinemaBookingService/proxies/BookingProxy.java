/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.Booking;
import java.sql.ResultSet;
import generated.cinemaBookingService.Reservation;
import generated.cinemaBookingService.relationControl.reservation_bookingSupervisor;
public class BookingProxy implements IBooking{
   private Integer id;
   private Optional<Booking> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public BookingProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BookingProxy(Booking theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Booking getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Booking";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooking)) return false;
      return ((IBooking)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Booking load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Booking", this.id);
         Reservation myReservation = reservation_bookingSupervisor.getInstance().getMyReservation(this).getTheObject();
         return Booking.createAlreadyPersistent(this, myReservation);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Reservation getMyReservation() throws PersistenceException{
      return this.getTheObject().getMyReservation();
   }
   public void setMyReservation(Reservation newMyReservation)throws PersistenceException{
      this.getTheObject().setMyReservation(newMyReservation);
   }
}
