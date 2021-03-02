/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Seat;
import generated.cinemaService.CinemaRow;
import generated.cinemaService.Reservation;
import java.util.Set;
public interface ISeat extends Identifiable{
   public Seat getTheObject();
   public Integer getId();
   public Integer getNumber() ;
   public void setNumber(Integer newNumber) throws PersistenceException;
   public CinemaRow getMyRow() throws PersistenceException;
   public Set<Reservation> getMyReservation() throws PersistenceException;
}
