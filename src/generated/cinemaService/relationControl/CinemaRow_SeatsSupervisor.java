/**--- Generated at Mon Mar 01 12:40:22 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class CinemaRow_SeatsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static CinemaRow_SeatsSupervisor theInstance = new CinemaRow_SeatsSupervisor();
   private Relation<ICinemaRow,ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private CinemaRow_SeatsSupervisor(){
      this.elements = new Relation<>("CinemaRow_Seats");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static CinemaRow_SeatsSupervisor getInstance(){return theInstance;}
   public List<ISeat> getMySeats(ICinemaRow owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ICinemaRow owner, ISeat target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(ICinemaRow owner, ISeat target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinemaRow owner, ISeat target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public ICinemaRow getMyRow(ISeat target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
