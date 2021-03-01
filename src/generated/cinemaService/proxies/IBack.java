/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Back;
import java.util.Optional;
public interface IBack extends IPriceCategory{
   public Back getTheObject();
   public Integer getId();
   public Optional<Integer> getBackprice() ;
   public void setBackprice(Integer newBackprice) throws PersistenceException;
}
