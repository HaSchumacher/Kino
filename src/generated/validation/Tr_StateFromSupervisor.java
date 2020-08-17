/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Tr_StateFromSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Tr_StateFromSupervisor theInstance = new Tr_StateFromSupervisor();
   private Relation<Transition,State> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Tr_StateFromSupervisor(){
      this.elements = new Relation<>();
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Tr_StateFromSupervisor getInstance(){return theInstance;}
   public State getFrom(Transition owner){
      return this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(Transition owner, State target){
      State targetOld = null; State targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void change(Transition owner, State targetOld, State targetNew) {
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
