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
public class filmprojection_moveSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static filmprojection_moveSupervisor theInstance = new filmprojection_moveSupervisor();
   private Relation<IFilmProjection,IMovie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private filmprojection_moveSupervisor(){
      this.elements = new Relation<>("filmprojection_move");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static filmprojection_moveSupervisor getInstance(){return theInstance;}
   public IMovie getMyMovie(IFilmProjection owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IFilmProjection owner, IMovie target) throws PersistenceException{
      IMovie targetOld = this.getMyMovie(owner); IMovie targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IFilmProjection owner, IMovie target) {
      IMovie targetOld = null; IMovie targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IFilmProjection owner, IMovie targetOld, IMovie targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
