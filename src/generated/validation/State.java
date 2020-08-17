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
public class State extends Observable implements java.io.Serializable
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   private Boolean isFinal;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public State(String name, Boolean isFinal)
   {
      super();
      this.id = IDManager.getTheInstance().getNextId();
      this.name = name;
      this.isFinal = isFinal;
      Validation.getInstance().getTheStates().add(this);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Integer getId(){
      return this.id;
   }
   public String getName(){
      return this.name;
   }
   public Boolean getIsFinal(){
      return this.isFinal;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
