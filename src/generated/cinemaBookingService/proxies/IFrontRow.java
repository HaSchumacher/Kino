/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.FrontRow;
import generated.cinemaBookingService.Seat;
public interface IFrontRow extends ICinemaRow{
   public FrontRow getTheObject();
   public Integer getId();
   public void addSeat(Seat seat);
   public Boolean deleteSeat(Seat seat);
}
