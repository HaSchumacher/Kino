/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
import java.sql.ResultSet;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.util.Optional;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.DBExecuterFactory;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.IUnknown;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Unknown extends Role implements java.io.Serializable, IUnknown
{
	private static final long serialVersionUID = -1313633160889667531L;
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
   @Override
   public String toString() {
   	return "Unknown";
   }
//90 ===== GENERATED: End of Your Operations ======
}
