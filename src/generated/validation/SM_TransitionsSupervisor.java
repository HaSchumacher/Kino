/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class SM_TransitionsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static SM_TransitionsSupervisor theInstance = new SM_TransitionsSupervisor();
   private Relation<StateMachine,Transition> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SM_TransitionsSupervisor(){
      this.elements = new Relation<>();
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static SM_TransitionsSupervisor getInstance(){return theInstance;}
   public List<Transition> getTransitions(StateMachine owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(StateMachine owner, Transition target) {
      this.elements.addElement(owner,target);
   }
   public boolean remove(StateMachine owner, Transition target) {
      boolean result = this.elements.removeElementRevertible(owner,target);
      if(!result) return result;
      this.elements.removeElementCommit(owner,target);
      return result;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
