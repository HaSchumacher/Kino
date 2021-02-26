/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
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
public class filmprojection_CinemahallSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static filmprojection_CinemahallSupervisor theInstance = new filmprojection_CinemahallSupervisor();
   private Relation<IFilmProjection,ICinemahall> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private filmprojection_CinemahallSupervisor(){
      this.elements = new Relation<>("filmprojection_Cinemahall");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static filmprojection_CinemahallSupervisor getInstance(){return theInstance;}
   public ICinemahall getMyCinemahall(IFilmProjection owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IFilmProjection owner, ICinemahall target) throws PersistenceException{
      ICinemahall targetOld = this.getMyCinemahall(owner); ICinemahall targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IFilmProjection owner, ICinemahall target) {
      ICinemahall targetOld = null; ICinemahall targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IFilmProjection owner, ICinemahall targetOld, ICinemahall targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
