/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
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
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public String getEmail() ;
   public void setEmail(String newEmail) throws PersistenceException;
   public String getUsername() ;
   public void setUsername(String newUsername) throws PersistenceException;
   public String getPassword() ;
   public void setPassword(String newPassword) throws PersistenceException;
}
