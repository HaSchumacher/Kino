/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class SM_StartStateSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static SM_StartStateSupervisor theInstance = new SM_StartStateSupervisor();
   private Relation<StateMachine,State> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SM_StartStateSupervisor(){
      this.elements = new Relation<>();
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static SM_StartStateSupervisor getInstance(){return theInstance;}
   public State getStartState(StateMachine owner){
      return this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(StateMachine owner, State target){
      State targetOld = null; State targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void change(StateMachine owner, State targetOld, State targetNew) {
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
