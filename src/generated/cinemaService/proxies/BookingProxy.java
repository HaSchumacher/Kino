/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import java.util.Optional;

import db.executer.DBExecuterFactory;
import db.executer.PersistenceException;
import generated.cinemaService.Booking;
import generated.cinemaService.Reservation;
import generated.cinemaService.relationControl.Booking_ReservationSupervisor;
public class BookingProxy implements IBooking{
   private Integer id;
   private Optional<Booking> theObject;
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
      try {
         DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Booking", this.id);
         Reservation myReservation = Booking_ReservationSupervisor.getInstance().getMyReservation(this).getTheObject();
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
