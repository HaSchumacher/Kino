/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
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
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
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
         return User.createAlreadyPersistent(this);
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
}
