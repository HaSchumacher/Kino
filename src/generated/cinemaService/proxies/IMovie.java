/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Movie;
public interface IMovie extends Identifiable{
   public Movie getTheObject();
   public Integer getId();
   public String getTitle() ;
   public void setTitle(String newTitle) throws PersistenceException;
}
