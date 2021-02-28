/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.Cinemahall;
import generated.cinemaBookingService.CinemaRow;
import java.util.List;
public interface ICinemahall extends Identifiable{
   public Cinemahall getTheObject();
   public Integer getId();
   public List<CinemaRow> getMyrow() throws PersistenceException;
   public void addToMyrow(CinemaRow arg) throws PersistenceException;
   public boolean removeFromMyrow(CinemaRow arg) throws PersistenceException;
   public Boolean getOpen() ;
   public void setOpen(Boolean newOpen) throws PersistenceException;
}
