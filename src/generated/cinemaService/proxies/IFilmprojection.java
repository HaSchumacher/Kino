/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.Movie;
public interface IFilmprojection extends Identifiable{
   public Filmprojection getTheObject();
   public Integer getId();
   public Cinemahall getMyHall() throws PersistenceException;
   public void setMyHall(Cinemahall newMyHall)throws PersistenceException;
   public Movie getMyMovie() throws PersistenceException;
   public void setMyMovie(Movie newMyMovie)throws PersistenceException;
   public Integer calculateProfit() throws PersistenceException;
}
