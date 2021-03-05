/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
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
import generated.cinemaService.proxies.IUnknown;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Unknown extends Role implements java.io.Serializable, IUnknown
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Unknown> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Unknown(Integer id, boolean objectOnly)
   {
      super(id, objectOnly);
      if(objectOnly) return;
   }
   private static Unknown createAlreadyPersistent(Integer id){
      return new Unknown(id, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Unknown getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Unknown load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Unknown");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Role", typeKey);
         rs.next();
         return Unknown.createAlreadyPersistent(rs.getInt("id"));
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Unknown getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
