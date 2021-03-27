/**--- Generated at Sun Mar 14 13:22:13 CET 2021 
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
public class Reservation_FpSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Reservation_FpSupervisor theInstance = new Reservation_FpSupervisor();
   private Relation<IReservation,IFilmprojection> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation_FpSupervisor(){
      this.elements = new Relation<>("Reservation_Fp");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Reservation_FpSupervisor getInstance(){return theInstance;}
   public IFilmprojection getMyFilmprojection(IReservation owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservation owner, IFilmprojection target) throws PersistenceException{
      IFilmprojection targetOld = this.getMyFilmprojection(owner); IFilmprojection targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IReservation owner, IFilmprojection target) {
      IFilmprojection targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservation owner, IFilmprojection targetOld, IFilmprojection targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
