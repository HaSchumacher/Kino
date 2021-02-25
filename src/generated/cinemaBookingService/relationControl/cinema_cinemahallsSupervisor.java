/**--- Generated at Thu Feb 25 17:02:38 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaBookingService.proxies.*;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class cinema_cinemahallsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static cinema_cinemahallsSupervisor theInstance = new cinema_cinemahallsSupervisor();
   private Relation<ICinema,ICinemahall> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private cinema_cinemahallsSupervisor(){
      this.elements = new Relation<>("cinema_cinemahalls");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static cinema_cinemahallsSupervisor getInstance(){return theInstance;}
   public List<ICinemahall> getCinemahalls(ICinema owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ICinema owner, ICinemahall target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(ICinema owner, ICinemahall target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinema owner, ICinemahall target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
