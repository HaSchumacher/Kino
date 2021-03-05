/**--- Generated at Fri Mar 05 15:44:03 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Security;
import java.util.Optional;
public interface ISecurity extends Identifiable{
   public Security getTheObject();
   public Integer getId();
   public Optional<String> getSecurityMap() ;
   public void setSecurityMap(String newSecurityMap) throws PersistenceException;
}
