/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Booking;
import generated.cinemaService.Reservation;
public interface IBooking extends Identifiable{
   public Booking getTheObject();
   public Integer getId();
   public Reservation getMyReservation() throws PersistenceException;
   public void setMyReservation(Reservation newMyReservation)throws PersistenceException;
}
