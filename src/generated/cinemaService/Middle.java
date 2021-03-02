/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
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
import generated.cinemaService.proxies.IMiddle;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Middle extends PriceCategory implements java.io.Serializable, IMiddle
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Middle> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Middle(Integer id, Optional<Integer> price, boolean objectOnly)
   {
      super(id, price, objectOnly);
      if(objectOnly) return;
   }
   private static Middle createAlreadyPersistent(Integer id, Optional<Integer> price){
      return new Middle(id, price, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Middle getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Middle load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Middle");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("PriceCategory", typeKey);
         rs.next();
         Optional<Integer> price = (rs.getObject("price") == null ? Optional.empty() : Optional.of(rs.getInt("price")));
         return Middle.createAlreadyPersistent(rs.getInt("id"), price);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Middle getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
