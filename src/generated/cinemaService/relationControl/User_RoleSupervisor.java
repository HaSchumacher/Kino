/**--- Generated at Fri Mar 05 17:39:17 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class User_RoleSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static User_RoleSupervisor theInstance = new User_RoleSupervisor();
   private Relation<IUser,IRole> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User_RoleSupervisor(){
      this.elements = new Relation<>("User_Role");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static User_RoleSupervisor getInstance(){return theInstance;}
   public Set<IRole> getMyRoles(IUser owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(IUser owner, IRole target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(IUser owner, IRole target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IUser owner, IRole target) throws PersistenceException{
      boolean loop = this.removeOnce(owner, target);
      boolean result = loop;
      while(loop) loop = this.removeOnce(owner, target);
      return result;
   }
   private boolean removeOnce(IUser owner, IRole target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
