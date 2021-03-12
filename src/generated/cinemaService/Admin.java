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
import generated.cinemaService.proxies.IAdmin;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Admin extends Role implements java.io.Serializable, IAdmin
{
  private static final long serialVersionUID = -4654218735654558009L;
//30 ===== GENERATED:      Attribute Section ======
   private static Optional<Admin> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Admin(Integer id, boolean objectOnly)
   {
      super(id, objectOnly);
      if(objectOnly) return;
   }
   private static Admin createAlreadyPersistent(Integer id){
      return new Admin(id, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Admin getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Admin load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Admin");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Role", typeKey);
         rs.next();
         return Admin.createAlreadyPersistent(rs.getInt("id"));
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Admin getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
   @Override
   public String toString() {
   	return "Admin";
   }
//90 ===== GENERATED: End of Your Operations ======
}
