/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.ReservationProxy;
import observation.Observable;
import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaService.proxies.IBooking;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservation extends Observable implements java.io.Serializable, IReservation
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation(Integer id, Seat mySeat, Filmprojection myFilmprojection, User myCustomer, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      Reservation_SeatSupervisor.getInstance().set(this, mySeat);
      Reservation_FpSupervisor.getInstance().set(this, myFilmprojection);
      Reservation_UserSupervisor.getInstance().set(this, myCustomer);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reservation createAlreadyPersistent(ReservationProxy proxy, Seat mySeat, Filmprojection myFilmprojection, User myCustomer)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reservation(proxy.getId(), mySeat, myFilmprojection, myCustomer, true);
   }
   public static Reservation createFresh(Seat mySeat, Filmprojection myFilmprojection, User myCustomer)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reservation", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Reservation").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reservation me = new Reservation(id, mySeat, myFilmprojection, myCustomer, false);
      CinemaService.getInstance().addReservationProxy(new ReservationProxy(me));
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
      return Reservation_SeatSupervisor.getInstance().getMySeat(this).getTheObject();
   }
   public void setMySeat(Seat newMySeat)throws PersistenceException{
      Reservation_SeatSupervisor.getInstance().change(this, this.getMySeat(), newMySeat);
   }
   public Filmprojection getMyFilmprojection() throws PersistenceException{
      return Reservation_FpSupervisor.getInstance().getMyFilmprojection(this).getTheObject();
   }
   public void setMyFilmprojection(Filmprojection newMyFilmprojection)throws PersistenceException{
      Reservation_FpSupervisor.getInstance().change(this, this.getMyFilmprojection(), newMyFilmprojection);
   }
   public User getMyCustomer() throws PersistenceException{
      return Reservation_UserSupervisor.getInstance().getMyCustomer(this).getTheObject();
   }
   public void setMyCustomer(User newMyCustomer)throws PersistenceException{
      Reservation_UserSupervisor.getInstance().change(this, this.getMyCustomer(), newMyCustomer);
   }
   public Set<Booking> getMyBooking() throws PersistenceException{
      Set<Booking> result = new HashSet<>();
      for (IBooking i : Booking_ReservationSupervisor.getInstance().getMyBooking(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
