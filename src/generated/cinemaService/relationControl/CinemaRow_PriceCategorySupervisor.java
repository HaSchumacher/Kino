/**--- Generated at Mon Mar 01 12:40:22 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class CinemaRow_PriceCategorySupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static CinemaRow_PriceCategorySupervisor theInstance = new CinemaRow_PriceCategorySupervisor();
   private Relation<ICinemaRow,IPriceCategory> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private CinemaRow_PriceCategorySupervisor(){
      this.elements = new Relation<>("CinemaRow_PriceCategory");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static CinemaRow_PriceCategorySupervisor getInstance(){return theInstance;}
   public IPriceCategory getPriceCategory(ICinemaRow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ICinemaRow owner, IPriceCategory target) throws PersistenceException{
      IPriceCategory targetOld = this.getPriceCategory(owner); IPriceCategory targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ICinemaRow owner, IPriceCategory target) {
      IPriceCategory targetOld = null; IPriceCategory targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ICinemaRow owner, IPriceCategory targetOld, IPriceCategory targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
