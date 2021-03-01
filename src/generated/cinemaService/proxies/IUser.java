/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.User;
import generated.cinemaService.Role;
import java.util.Set;
public interface IUser extends Identifiable{
   public User getTheObject();
   public Integer getId();
   public Set<Role> getMyRoles() throws PersistenceException;
   public void addToMyRoles(Role arg) throws PersistenceException;
   public boolean removeFromMyRoles(Role arg) throws PersistenceException;
}
