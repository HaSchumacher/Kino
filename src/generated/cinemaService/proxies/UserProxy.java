/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.User;
import java.sql.ResultSet;
import generated.cinemaService.Role;
import java.util.Set;
public class UserProxy implements IUser{
   private Integer id;
   private Optional<User> theObject;
   public UserProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public UserProxy(User theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public User getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "User";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IUser)) return false;
      return ((IUser)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private User load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("User", this.id);
         String name = rs.getString("name");
         String email = rs.getString("email");
         String username = rs.getString("username");
         String password = rs.getString("password");
         return User.createAlreadyPersistent(this, name, email, username, password);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<Role> getMyRoles() throws PersistenceException{
      return this.getTheObject().getMyRoles();
   }
   public void addToMyRoles(Role arg) throws PersistenceException{
      this.getTheObject().addToMyRoles(arg);
   }
   public boolean removeFromMyRoles(Role arg) throws PersistenceException{
      return this.getTheObject().removeFromMyRoles(arg);
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public String getEmail() {
      return this.getTheObject().getEmail();
   }
   public void setEmail(String newEmail) throws PersistenceException{
      this.getTheObject().setEmail(newEmail);
   }
   public String getUsername() {
      return this.getTheObject().getUsername();
   }
   public void setUsername(String newUsername) throws PersistenceException{
      this.getTheObject().setUsername(newUsername);
   }
   public String getPassword() {
      return this.getTheObject().getPassword();
   }
   public void setPassword(String newPassword) throws PersistenceException{
      this.getTheObject().setPassword(newPassword);
   }
}
