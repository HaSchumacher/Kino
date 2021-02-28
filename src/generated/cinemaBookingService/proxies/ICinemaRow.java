/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.CinemaRow;
import generated.cinemaBookingService.Seat;
import java.util.List;
import generated.cinemaBookingService.Cinemahall;
import java.util.Set;
public interface ICinemaRow extends Identifiable{
   public CinemaRow getTheObject();
   public List<Seat> getMySeats() throws PersistenceException;
   public void addToMySeats(Seat arg) throws PersistenceException;
   public boolean removeFromMySeats(Seat arg) throws PersistenceException;
   public Integer getPrice() ;
   public void setPrice(Integer newPrice) throws PersistenceException;
   public Boolean getBookedUp() ;
   public void setBookedUp(Boolean newBookedUp) throws PersistenceException;
   public Set<Cinemahall> getMyHall() throws PersistenceException;
   public abstract void addSeat(Seat seat);
   public abstract Boolean deleteSeat(Seat seat);
}
