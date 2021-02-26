/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.OwnerService;
import generated.cinemaBookingService.Cinema;
public interface IOwnerService extends Identifiable{
   public OwnerService getTheObject();
   public Integer getId();
   public Cinema getCinema() throws PersistenceException;
   public void setCinema(Cinema newCinema)throws PersistenceException;
}
