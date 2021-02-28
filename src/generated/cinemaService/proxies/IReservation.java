/**--- Generated at Sun Feb 28 15:38:46 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Reservation;
import generated.cinemaService.Seat;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.User;
import generated.cinemaService.Booking;
import java.util.Set;
public interface IReservation extends Identifiable{
   public Reservation getTheObject();
   public Integer getId();
   public Seat getMySeat() throws PersistenceException;
   public void setMySeat(Seat newMySeat)throws PersistenceException;
   public Filmprojection getMyFilmprojection() throws PersistenceException;
   public void setMyFilmprojection(Filmprojection newMyFilmprojection)throws PersistenceException;
   public User getMyCustomer() throws PersistenceException;
   public void setMyCustomer(User newMyCustomer)throws PersistenceException;
   public Set<Booking> getMyBooking() throws PersistenceException;
}
