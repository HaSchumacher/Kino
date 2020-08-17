/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Tr_EventSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Tr_EventSupervisor theInstance = new Tr_EventSupervisor();
   private Relation<Transition,Event> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Tr_EventSupervisor(){
      this.elements = new Relation<>();
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Tr_EventSupervisor getInstance(){return theInstance;}
   public Event getEvent(Transition owner){
      return this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(Transition owner, Event target){
      Event targetOld = null; Event targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void change(Transition owner, Event targetOld, Event targetNew) {
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
