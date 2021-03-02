/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import java.util.Optional;
import java.sql.ResultSet;
import db.executer.DBExecuterFactory;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IBack;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Back extends PriceCategory implements java.io.Serializable, IBack
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Back> theInstance = Optional.empty();
   private Optional<Integer> backprice;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Back(Integer id, Optional<Integer> backprice, boolean objectOnly)
   {
      super(id, objectOnly);
      this.backprice = backprice;
      if(objectOnly) return;
   }
   private static Back createAlreadyPersistent(Integer id, Optional<Integer> backprice){
      return new Back(id, backprice, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Back getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Back load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Back");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("PriceCategory", typeKey);
         rs.next();
         Optional<Integer> backprice = (rs.getObject("backprice") == null ? Optional.empty() : Optional.of(rs.getInt("backprice")));
         return Back.createAlreadyPersistent(rs.getInt("id"), backprice);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Back getTheObject(){
      return this;
   }
   public Optional<Integer> getBackprice() {
      return this.backprice;
   }
   public void setBackprice(Integer newBackprice) throws PersistenceException{
      this.backprice = Optional.of(newBackprice);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("PriceCategory", "backprice", newBackprice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
