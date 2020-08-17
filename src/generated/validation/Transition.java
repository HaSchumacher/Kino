/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import observation.Observable;
import idManagement.IDManager;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Transition extends Observable implements java.io.Serializable
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Transition(State from, State to, Event event)
   
   {
      super();
      Tr_StateFromSupervisor.getInstance().set(this, from);
      Tr_StateToSupervisor.getInstance().set(this, to);
      Tr_EventSupervisor.getInstance().set(this, event);
      this.id = IDManager.getTheInstance().getNextId();
      Validation.getInstance().getTheTransitions().add(this);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public State getFrom(){
      return Tr_StateFromSupervisor.getInstance().getFrom(this);
   }
   private void setFrom(State newFrom){
      Tr_StateFromSupervisor.getInstance().change(this, this.getFrom(), newFrom);
   }
   public State getTo(){
      return Tr_StateToSupervisor.getInstance().getTo(this);
   }
   private void setTo(State newTo){
      Tr_StateToSupervisor.getInstance().change(this, this.getTo(), newTo);
   }
   public Event getEvent(){
      return Tr_EventSupervisor.getInstance().getEvent(this);
   }
   private void setEvent(Event newEvent){
      Tr_EventSupervisor.getInstance().change(this, this.getEvent(), newEvent);
   }
   public Integer getId(){
      return this.id;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
