/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.BookingProxy;
import generated.cinemaService.proxies.IBooking;
import generated.cinemaService.relationControl.Booking_ReservationSupervisor;
import observation.Observable;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Booking extends Observable implements java.io.Serializable, IBooking
{
   private static final long serialVersionUID = -5317472923721924044L;
//30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Booking(Integer id, Reservation myReservation, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      Booking_ReservationSupervisor.getInstance().set(this, myReservation);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Booking createAlreadyPersistent(BookingProxy proxy, Reservation myReservation)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Booking(proxy.getId(), myReservation, true);
   }
   public static Booking createFresh(Reservation myReservation)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Booking", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Booking").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Booking me = new Booking(id, myReservation, false);
      CinemaService.getInstance().addBookingProxy(new BookingProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Booking getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooking)) return false;
      return ((IBooking)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Reservation getMyReservation() throws PersistenceException{
      return Booking_ReservationSupervisor.getInstance().getMyReservation(this).getTheObject();
   }
   public void setMyReservation(Reservation newMyReservation)throws PersistenceException{
      Booking_ReservationSupervisor.getInstance().change(this, this.getMyReservation(), newMyReservation);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
