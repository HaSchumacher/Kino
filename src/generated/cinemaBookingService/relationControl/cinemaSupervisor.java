/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaBookingService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class cinemaSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static cinemaSupervisor theInstance = new cinemaSupervisor();
   private Relation<IOwnerService,ICinema> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private cinemaSupervisor(){
      this.elements = new Relation<>("cinema");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static cinemaSupervisor getInstance(){return theInstance;}
   public ICinema getCinema(IOwnerService owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IOwnerService owner, ICinema target) throws PersistenceException{
      ICinema targetOld = this.getCinema(owner); ICinema targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IOwnerService owner, ICinema target) {
      ICinema targetOld = null; ICinema targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IOwnerService owner, ICinema targetOld, ICinema targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
