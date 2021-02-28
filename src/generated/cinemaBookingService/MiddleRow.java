/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.MiddleRowProxy;
import generated.cinemaBookingService.proxies.IMiddleRow;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class MiddleRow extends CinemaRow implements java.io.Serializable, IMiddleRow
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private MiddleRow(Integer id, Integer price, Boolean bookedUp, boolean objectOnly)
   throws PersistenceException{
      super(id, price, bookedUp, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static MiddleRow createAlreadyPersistent(MiddleRowProxy proxy, Integer price, Boolean bookedUp)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new MiddleRow(proxy.getId(), price, bookedUp, true);
   }
   public static MiddleRow createFresh(Integer price, Boolean bookedUp)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("CinemaRow", "id, typeKey, price, bookedUp", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "MiddleRow").toString() + ", " + price.toString() + ", " + bookedUp.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MiddleRow me = new MiddleRow(id, price, bookedUp, false);
      CinemaBookingService.getInstance().addMiddleRowProxy(new MiddleRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public MiddleRow getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
/**
 * adding a Seat to this row
 */
   public void addSeat(Seat seat){
      // TODO: Implement Operation addSeat
      return;
   }
/**
 * Delete the given Seat of Row
 */
   public Boolean deleteSeat(Seat seat){
      // TODO: Implement Operation deleteSeat
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
