/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.PriceCategory;
public abstract class PriceCategoryProxy implements IPriceCategory{
   public abstract PriceCategory getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof IPriceCategory)) return false;
      return ((IPriceCategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
}
