/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservation_SeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Reservation_SeatSupervisor theInstance = new Reservation_SeatSupervisor();
   private Relation<IReservation,ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation_SeatSupervisor(){
      this.elements = new Relation<>("Reservation_Seat");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Reservation_SeatSupervisor getInstance(){return theInstance;}
   public ISeat getMySeat(IReservation owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservation owner, ISeat target) throws PersistenceException{
      ISeat targetOld = this.getMySeat(owner); ISeat targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IReservation owner, ISeat target) {
      ISeat targetOld = null; ISeat targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservation owner, ISeat targetOld, ISeat targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<IReservation> getMyReservation(ISeat target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
