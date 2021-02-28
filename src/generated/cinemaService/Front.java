/**--- Generated at Sun Feb 28 15:38:46 CET 2021 
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
import generated.cinemaService.proxies.IFront;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Front extends PriceCategory implements java.io.Serializable, IFront
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Front> theInstance = Optional.empty();
   private Optional<Integer> frontprice;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Front(Integer id, Optional<Integer> frontprice, boolean objectOnly)
   {
      super(id, objectOnly);
      this.frontprice = frontprice;
      if(objectOnly) return;
   }
   private static Front createAlreadyPersistent(Integer id, Optional<Integer> frontprice){
      return new Front(id, frontprice, true);
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
         Optional<Integer> frontprice = (rs.getObject("frontprice") == null ? Optional.empty() : Optional.of(rs.getInt("frontprice")));
         return Front.createAlreadyPersistent(rs.getInt("id"), frontprice);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Front getTheObject(){
      return this;
   }
   public Optional<Integer> getFrontprice() {
      return this.frontprice;
   }
   public void setFrontprice(Integer newFrontprice) throws PersistenceException{
      this.frontprice = Optional.of(newFrontprice);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("PriceCategory", "frontprice", newFrontprice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
