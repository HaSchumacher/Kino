/**--- Generated at Sun Feb 28 16:02:01 CET 2021 
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
public class fp_movieSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static fp_movieSupervisor theInstance = new fp_movieSupervisor();
   private Relation<IFilmprojection,IMovie> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private fp_movieSupervisor(){
      this.elements = new Relation<>("fp_movie");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static fp_movieSupervisor getInstance(){return theInstance;}
   public IMovie getMyMovie(IFilmprojection owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IFilmprojection owner, IMovie target) throws PersistenceException{
      IMovie targetOld = this.getMyMovie(owner); IMovie targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IFilmprojection owner, IMovie target) {
      IMovie targetOld = null; IMovie targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IFilmprojection owner, IMovie targetOld, IMovie targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
