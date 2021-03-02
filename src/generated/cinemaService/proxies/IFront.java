/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Front;
import java.util.Optional;
public interface IFront extends IPriceCategory{
   public Front getTheObject();
   public Integer getId();
   public Optional<Integer> getFrontprice() ;
   public void setFrontprice(Integer newFrontprice) throws PersistenceException;
}
