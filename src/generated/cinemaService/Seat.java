/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.SeatProxy;
import observation.Observable;
import generated.cinemaService.proxies.ISeat;
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import exceptions.ConstraintViolation;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaService.proxies.IReservation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Seat extends Observable implements java.io.Serializable, ISeat
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer number;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Seat(Integer id, Integer number, CinemaRow myRow, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      this.number = number;
      if(objectOnly) return;
      try{CinemaRow_SeatsSupervisor.getInstance().add(myRow,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Seat createAlreadyPersistent(SeatProxy proxy, Integer number, CinemaRow myRow)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Seat(proxy.getId(), number, myRow, true);
   }
   public static Seat createFresh(Integer number, CinemaRow myRow)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Seat", "id, typeKey, number", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Seat").toString() + ", " + number.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Seat me = new Seat(id, number, myRow, false);
      CinemaService.getInstance().addSeatProxy(new SeatProxy(me));
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
   public Integer getNumber() {
      return this.number;
   }
   public void setNumber(Integer newNumber) throws PersistenceException{
      this.number = newNumber;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Seat", "number", newNumber.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public CinemaRow getMyRow() throws PersistenceException{
      return CinemaRow_SeatsSupervisor.getInstance().getMyRow(this).getTheObject();
   }
   public Set<Reservation> getMyReservation() throws PersistenceException{
      Set<Reservation> result = new HashSet<>();
      for (IReservation i : Reservation_SeatSupervisor.getInstance().getMyReservation(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
