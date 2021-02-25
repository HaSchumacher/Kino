/**--- Generated at Thu Feb 25 15:23:55 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.SeatProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.ISeat;
import generated.cinemaBookingService.relationControl.*;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaBookingService.proxies.ICinemaRow;
import generated.cinemaBookingService.proxies.IReservation;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Seat extends Observable implements java.io.Serializable, ISeat
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Seat(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Seat createAlreadyPersistent(SeatProxy proxy){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Seat(proxy.getId(), true);
   }
   public static Seat createFresh()throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Seat", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "Seat").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Seat me = new Seat(id, false);
      CinemaBookingService.getInstance().addSeatProxy(new SeatProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Seat getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<CinemaRow> getMyRow() throws PersistenceException{
      Set<CinemaRow> result = new HashSet<>();
      for (ICinemaRow i : Row_to_SeatSupervisor.getInstance().getMyRow(this)) result.add(i.getTheObject());
      return result;
   }
   public Set<Reservation> getMyReservation() throws PersistenceException{
      Set<Reservation> result = new HashSet<>();
      for (IReservation i : reservation_seatSupervisor.getInstance().getMyReservation(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
/**
 * get the Price from the CinemaRow
 */
   public Integer getPrice(){
      // TODO: Implement Operation getPrice
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
