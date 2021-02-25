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
import generated.cinemaBookingService.proxies.FrontRowProxy;
import generated.cinemaBookingService.proxies.IFrontRow;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class FrontRow extends CinemaRow implements java.io.Serializable, IFrontRow
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private FrontRow(Integer id, Integer price, Boolean bookedUp, boolean objectOnly)
   throws PersistenceException{
      super(id, price, bookedUp, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static FrontRow createAlreadyPersistent(FrontRowProxy proxy, Integer price, Boolean bookedUp)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new FrontRow(proxy.getId(), price, bookedUp, true);
   }
   public static FrontRow createFresh(Integer price, Boolean bookedUp)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("CinemaRow", "id, typeKey, price, bookedUp", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "FrontRow").toString() + ", " + price.toString() + ", " + bookedUp.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      FrontRow me = new FrontRow(id, price, bookedUp, false);
      CinemaBookingService.getInstance().addFrontRowProxy(new FrontRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public FrontRow getTheObject(){
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
