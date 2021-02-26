/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.Reservation;
import generated.cinemaBookingService.Seat;
import generated.cinemaBookingService.FilmProjection;
import generated.cinemaBookingService.Booking;
import java.util.Set;
public interface IReservation extends Identifiable{
   public Reservation getTheObject();
   public Integer getId();
   public Seat getMySeat() throws PersistenceException;
   public void setMySeat(Seat newMySeat)throws PersistenceException;
   public FilmProjection getMyfilmprojection() throws PersistenceException;
   public void setMyfilmprojection(FilmProjection newMyfilmprojection)throws PersistenceException;
   public Set<Booking> getMyBooking() throws PersistenceException;
}
