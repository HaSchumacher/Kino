/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
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
   private Optional<Integer> middleprice;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Middle(Integer id, Optional<Integer> middleprice, boolean objectOnly)
   {
      super(id, objectOnly);
      this.middleprice = middleprice;
      if(objectOnly) return;
   }
   private static Middle createAlreadyPersistent(Integer id, Optional<Integer> middleprice){
      return new Middle(id, middleprice, true);
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
         Optional<Integer> middleprice = (rs.getObject("middleprice") == null ? Optional.empty() : Optional.of(rs.getInt("middleprice")));
         return Middle.createAlreadyPersistent(rs.getInt("id"), middleprice);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Middle getTheObject(){
      return this;
   }
   public Optional<Integer> getMiddleprice() {
      return this.middleprice;
   }
   public void setMiddleprice(Integer newMiddleprice) throws PersistenceException{
      this.middleprice = Optional.of(newMiddleprice);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("PriceCategory", "middleprice", newMiddleprice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
