/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.Seat;
import generated.cinemaBookingService.CinemaRow;
import java.util.Set;
import generated.cinemaBookingService.Reservation;
public interface ISeat extends Identifiable{
   public Seat getTheObject();
   public Integer getId();
   public Set<CinemaRow> getMyRow() throws PersistenceException;
   public Set<Reservation> getMyReservation() throws PersistenceException;
}
