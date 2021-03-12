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
import generated.cinemaService.proxies.IMiddle;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Middle extends PriceCategory implements java.io.Serializable, IMiddle
{
   private static final long serialVersionUID = 6085707041544503621L;
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
@Override
public String toString() {
	return "Middle Kategorie mit " + getPrice() + "€ pro Sitz";
}
   
//90 ===== GENERATED: End of Your Operations ======
}
