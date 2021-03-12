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
import generated.cinemaService.proxies.IFront;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Front extends PriceCategory implements java.io.Serializable, IFront
{
  private static final long serialVersionUID = 1179487352596471766L;
//30 ===== GENERATED:      Attribute Section ======
   private static Optional<Front> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Front(Integer id, Optional<Integer> price, boolean objectOnly)
   {
      super(id, price, objectOnly);
      if(objectOnly) return;
   }
   private static Front createAlreadyPersistent(Integer id, Optional<Integer> price){
      return new Front(id, price, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Front getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Front load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Front");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("PriceCategory", typeKey);
         rs.next();
         Optional<Integer> price = (rs.getObject("price") == null ? Optional.empty() : Optional.of(rs.getInt("price")));
         return Front.createAlreadyPersistent(rs.getInt("id"), price);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Front getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
   @Override
   public String toString() {
   	return "Front Kategorie mit " + getPrice() + "€ pro Sitz";
   }
//90 ===== GENERATED: End of Your Operations ======
}
