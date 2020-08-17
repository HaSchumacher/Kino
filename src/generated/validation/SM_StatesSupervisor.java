/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class SM_StatesSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static SM_StatesSupervisor theInstance = new SM_StatesSupervisor();
   private Relation<StateMachine,State> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SM_StatesSupervisor(){
      this.elements = new Relation<>();
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static SM_StatesSupervisor getInstance(){return theInstance;}
   public Set<State> getStates(StateMachine owner){
      return this.elements.getRelatedTargets(owner).stream().collect(Collectors.toSet());
   }
   public void add(StateMachine owner, State target) {
      this.elements.addElement(owner,target);
   }
   public boolean remove(StateMachine owner, State target) {
      return this.removeAll(owner, target);
   }
   private boolean removeAll(StateMachine owner, State target) {
      boolean result = this.elements.removeElementRevertible(owner,target);
      if(!result) return result;
      this.elements.removeElementCommit(owner,target);
      this.removeAll(owner, target);
      return result;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
