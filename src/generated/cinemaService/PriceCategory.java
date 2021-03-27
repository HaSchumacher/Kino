/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.util.Optional;

import db.connection.NoConnectionException;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IPriceCategory;
import observation.Observable;

//25 ===== GENERATED:      Header Section =========
public abstract class PriceCategory extends Observable implements java.io.Serializable, IPriceCategory
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 4448385052810040738L;
//30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Optional<Integer> price;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public PriceCategory(Integer id, Optional<Integer> price, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.price = price;
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public PriceCategory getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IPriceCategory)) return false;
      return ((IPriceCategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<Integer> getPrice() {
      return this.price;
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.price = Optional.of(newPrice);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("PriceCategory", "price", newPrice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
