/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import exceptions.ConstraintViolation;
import java.util.List;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class SM_EventsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static SM_EventsSupervisor theInstance = new SM_EventsSupervisor();
   private Relation<StateMachine,Event> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SM_EventsSupervisor(){
      this.elements = new Relation<>();
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static SM_EventsSupervisor getInstance(){return theInstance;}
   public List<Event> getEvents(StateMachine owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(StateMachine owner, Event target) throws ConstraintViolation{
      this.elements.addElement(owner,target);
      if(!this.elements.isInjectiveAt(target)){
         this.elements.removeElement(owner,target);
         throw new ConstraintViolation(target + baseTypes.Texts.injectivityConstraintViolated);
      }
   }
   public boolean remove(StateMachine owner, Event target) throws ConstraintViolation{
      boolean result = this.elements.removeElementRevertible(owner,target);
      if(!result) return result;
      if(!this.elements.isInjectiveAt(target)){
         this.elements.removeElementRollback(owner,target);
         throw new ConstraintViolation(target + baseTypes.Texts.injectivityConstraintViolated);
      }
      this.elements.removeElementCommit(owner,target);
      return result;
   }
   public Optional<StateMachine> getMyStateMachine(Event target){
      if(this.elements.getRelatedSources(target).size()==0) return Optional.empty(); return Optional.of(this.elements.getRelatedSources(target).get(0));
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
