/**--- Generated at Thu Feb 25 13:16:50 CET 2021 
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
public class frontRow_to_SeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static frontRow_to_SeatSupervisor theInstance = new frontRow_to_SeatSupervisor();
   private Relation<IFrontRow,ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private frontRow_to_SeatSupervisor(){
      this.elements = new Relation<>("frontRow_to_Seat");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static frontRow_to_SeatSupervisor getInstance(){return theInstance;}
   public List<ISeat> getMySeats(IFrontRow owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IFrontRow owner, ISeat target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(IFrontRow owner, ISeat target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IFrontRow owner, ISeat target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   public Set<IFrontRow> getMyRow(ISeat target){
      return this.elements.getRelatedSources(target).stream().collect(Collectors.toSet());
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
