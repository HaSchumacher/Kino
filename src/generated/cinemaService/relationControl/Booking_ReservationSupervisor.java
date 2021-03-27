/**--- Generated at Sun Mar 14 13:22:13 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

import db.executer.PersistenceException;
import generated.cinemaService.proxies.IBooking;
import generated.cinemaService.proxies.IReservation;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;

//25 ===== GENERATED:      Header Section =========
public class Booking_ReservationSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Booking_ReservationSupervisor theInstance = new Booking_ReservationSupervisor();
   private Relation<IBooking,IReservation> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Booking_ReservationSupervisor(){
      this.elements = new Relation<>("Booking_Reservation");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Booking_ReservationSupervisor getInstance(){return theInstance;}
   public IReservation getMyReservation(IBooking owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IBooking owner, IReservation target) throws PersistenceException{
      IReservation targetOld = this.getMyReservation(owner); IReservation targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IBooking owner, IReservation target) {
      IReservation targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IBooking owner, IReservation targetOld, IReservation targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   public Set<IBooking> getMyBooking(IReservation target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
