/**--- Generated at Mon Aug 17 20:02:50 CEST 2020 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.validation;
//10 ===== GENERATED:      Import Section =========
import observation.Observable;
import idManagement.IDManager;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Event extends Observable implements java.io.Serializable
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String label;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Event(String label)
   {
      super();
      this.id = IDManager.getTheInstance().getNextId();
      this.label = label;
      Validation.getInstance().getTheEvents().add(this);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Integer getId(){
      return this.id;
   }
   public String getLabel(){
      return this.label;
   }
   public Optional<StateMachine> getMyStateMachine(){
      return SM_EventsSupervisor.getInstance().getMyStateMachine(this);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
