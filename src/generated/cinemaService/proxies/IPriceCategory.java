/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.PriceCategory;
import java.util.Optional;
public interface IPriceCategory extends Identifiable{
   public PriceCategory getTheObject();
   public Optional<Integer> getPrice() ;
   public void setPrice(Integer newPrice) throws PersistenceException;
}
