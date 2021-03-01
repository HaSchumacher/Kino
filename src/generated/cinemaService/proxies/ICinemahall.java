/**--- Generated at Mon Mar 01 12:40:21 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.CinemaRow;
import java.util.List;
public interface ICinemahall extends Identifiable{
   public Cinemahall getTheObject();
   public Integer getId();
   public List<CinemaRow> getMyRows() throws PersistenceException;
   public void addToMyRows(CinemaRow arg) throws PersistenceException;
   public boolean removeFromMyRows(CinemaRow arg) throws PersistenceException;
   public Boolean getOpen() ;
   public void setOpen(Boolean newOpen) throws PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
}
