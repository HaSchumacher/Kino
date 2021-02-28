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
public class fp_CinemahallSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static fp_CinemahallSupervisor theInstance = new fp_CinemahallSupervisor();
   private Relation<IFilmprojection,ICinemahall> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private fp_CinemahallSupervisor(){
      this.elements = new Relation<>("fp_Cinemahall");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static fp_CinemahallSupervisor getInstance(){return theInstance;}
   public ICinemahall getMyHall(IFilmprojection owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IFilmprojection owner, ICinemahall target) throws PersistenceException{
      ICinemahall targetOld = this.getMyHall(owner); ICinemahall targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IFilmprojection owner, ICinemahall target) {
      ICinemahall targetOld = null; ICinemahall targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IFilmprojection owner, ICinemahall targetOld, ICinemahall targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
