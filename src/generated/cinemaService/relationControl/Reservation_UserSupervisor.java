/**--- Generated at Sun Feb 28 15:38:46 CET 2021 
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
public class Reservation_UserSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Reservation_UserSupervisor theInstance = new Reservation_UserSupervisor();
   private Relation<IReservation,IUser> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation_UserSupervisor(){
      this.elements = new Relation<>("Reservation_User");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Reservation_UserSupervisor getInstance(){return theInstance;}
   public IUser getMyCustomer(IReservation owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservation owner, IUser target) throws PersistenceException{
      IUser targetOld = this.getMyCustomer(owner); IUser targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IReservation owner, IUser target) {
      IUser targetOld = null; IUser targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservation owner, IUser targetOld, IUser targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
