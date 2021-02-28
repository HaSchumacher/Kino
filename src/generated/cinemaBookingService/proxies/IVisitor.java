/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.Visitor;
public interface IVisitor extends Identifiable{
   public Visitor getTheObject();
   public Integer getId();
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
}
