/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaBookingService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Row_to_SeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Row_to_SeatSupervisor theInstance = new Row_to_SeatSupervisor();
   private Relation<ICinemaRow,ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Row_to_SeatSupervisor(){
      this.elements = new Relation<>("Row_to_Seat");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Row_to_SeatSupervisor getInstance(){return theInstance;}
   public List<ISeat> getMySeats(ICinemaRow owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ICinemaRow owner, ISeat target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(ICinemaRow owner, ISeat target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinemaRow owner, ISeat target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   public Set<ICinemaRow> getMyRow(ISeat target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
