/**--- Generated at Thu Feb 25 15:23:56 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaBookingService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class rowsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static rowsSupervisor theInstance = new rowsSupervisor();
   private Relation<ICinemahall,ICinemaRow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private rowsSupervisor(){
      this.elements = new Relation<>("rows");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static rowsSupervisor getInstance(){return theInstance;}
   public List<ICinemaRow> getMyrow(ICinemahall owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ICinemahall owner, ICinemaRow target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(ICinemahall owner, ICinemaRow target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinemahall owner, ICinemaRow target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   public Set<ICinemahall> getMyHall(ICinemaRow target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
