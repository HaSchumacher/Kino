/**--- Generated at Thu Feb 25 17:02:38 CET 2021 
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
public class reservation_filmprojectionSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static reservation_filmprojectionSupervisor theInstance = new reservation_filmprojectionSupervisor();
   private Relation<IReservation,IFilmProjection> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private reservation_filmprojectionSupervisor(){
      this.elements = new Relation<>("reservation_filmprojection");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static reservation_filmprojectionSupervisor getInstance(){return theInstance;}
   public IFilmProjection getMyfilmprojection(IReservation owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IReservation owner, IFilmProjection target) throws PersistenceException{
      IFilmProjection targetOld = this.getMyfilmprojection(owner); IFilmProjection targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IReservation owner, IFilmProjection target) {
      IFilmProjection targetOld = null; IFilmProjection targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservation owner, IFilmProjection targetOld, IFilmProjection targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
