/**--- Generated at Thu Feb 25 17:02:37 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.ReservationProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.IReservation;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaBookingService.proxies.IBooking;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservation extends Observable implements java.io.Serializable, IReservation
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation(Integer id, Seat mySeat, FilmProjection myfilmprojection, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      reservation_seatSupervisor.getInstance().set(this, mySeat);
      reservation_filmprojectionSupervisor.getInstance().set(this, myfilmprojection);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reservation createAlreadyPersistent(ReservationProxy proxy, Seat mySeat, FilmProjection myfilmprojection)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reservation(proxy.getId(), mySeat, myfilmprojection, true);
   }
   public static Reservation createFresh(Seat mySeat, FilmProjection myfilmprojection)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reservation", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "Reservation").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reservation me = new Reservation(id, mySeat, myfilmprojection, false);
      CinemaBookingService.getInstance().addReservationProxy(new ReservationProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Reservation getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Seat getMySeat() throws PersistenceException{
      return reservation_seatSupervisor.getInstance().getMySeat(this).getTheObject();
   }
   public void setMySeat(Seat newMySeat)throws PersistenceException{
      reservation_seatSupervisor.getInstance().change(this, this.getMySeat(), newMySeat);
   }
   public FilmProjection getMyfilmprojection() throws PersistenceException{
      return reservation_filmprojectionSupervisor.getInstance().getMyfilmprojection(this).getTheObject();
   }
   public void setMyfilmprojection(FilmProjection newMyfilmprojection)throws PersistenceException{
      reservation_filmprojectionSupervisor.getInstance().change(this, this.getMyfilmprojection(), newMyfilmprojection);
   }
   public Set<Booking> getMyBooking() throws PersistenceException{
      Set<Booking> result = new HashSet<>();
      for (IBooking i : reservation_bookingSupervisor.getInstance().getMyBooking(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
