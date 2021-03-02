/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Cinemahall_CinemaRowSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Cinemahall_CinemaRowSupervisor theInstance = new Cinemahall_CinemaRowSupervisor();
   private Relation<ICinemahall,ICinemaRow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Cinemahall_CinemaRowSupervisor(){
      this.elements = new Relation<>("Cinemahall_CinemaRow");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Cinemahall_CinemaRowSupervisor getInstance(){return theInstance;}
   public List<ICinemaRow> getMyRows(ICinemahall owner){
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
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
