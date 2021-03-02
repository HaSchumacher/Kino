/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.UserProxy;
import observation.Observable;
import generated.cinemaService.proxies.IUser;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class User extends Observable implements java.io.Serializable, IUser
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   private String email;
   private String username;
   private String password;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User(Integer id, String name, String email, String username, String password, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      this.email = email;
      this.username = username;
      this.password = password;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static User createAlreadyPersistent(UserProxy proxy, String name, String email, String username, String password){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new User(proxy.getId(), name, email, username, password, true);
   }
   public static User createFresh(String name, String email, String username, String password)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("User", "id, typeKey, name, email, username, password", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "User").toString() + ", " + "'" + name + "'" + ", " + "'" + email + "'" + ", " + "'" + username + "'" + ", " + "'" + password + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      User me = new User(id, name, email, username, password, false);
      CinemaService.getInstance().addUserProxy(new UserProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public User getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IUser)) return false;
      return ((IUser)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Role> getMyRoles() throws PersistenceException{
      Set<Role> result = new HashSet<>();
      for (IRole i : User_RoleSupervisor.getInstance().getMyRoles(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMyRoles(Role arg) throws PersistenceException{
      User_RoleSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMyRoles(Role arg) throws PersistenceException{
      return User_RoleSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getEmail() {
      return this.email;
   }
   public void setEmail(String newEmail) throws PersistenceException{
      this.email = newEmail;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "email", "'" + newEmail + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getUsername() {
      return this.username;
   }
   public void setUsername(String newUsername) throws PersistenceException{
      this.username = newUsername;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "username", "'" + newUsername + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getPassword() {
      return this.password;
   }
   public void setPassword(String newPassword) throws PersistenceException{
      this.password = newPassword;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "password", "'" + newPassword + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
