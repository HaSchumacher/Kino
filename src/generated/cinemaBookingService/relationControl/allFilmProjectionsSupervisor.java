/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
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
public class allFilmProjectionsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static allFilmProjectionsSupervisor theInstance = new allFilmProjectionsSupervisor();
   private Relation<ICinema,IFilmProjection> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private allFilmProjectionsSupervisor(){
      this.elements = new Relation<>("allFilmProjections");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static allFilmProjectionsSupervisor getInstance(){return theInstance;}
   public List<IFilmProjection> getFilmProjections(ICinema owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ICinema owner, IFilmProjection target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(ICinema owner, IFilmProjection target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICinema owner, IFilmProjection target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
