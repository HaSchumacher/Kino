/**--- Generated at Thu Feb 25 15:23:55 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.Cinema;
import generated.cinemaBookingService.Cinemahall;
import java.util.List;
import generated.cinemaBookingService.FilmProjection;
public interface ICinema extends Identifiable{
   public Cinema getTheObject();
   public Integer getId();
   public List<Cinemahall> getCinemahalls() throws PersistenceException;
   public void addToCinemahalls(Cinemahall arg) throws PersistenceException;
   public boolean removeFromCinemahalls(Cinemahall arg) throws PersistenceException;
   public List<FilmProjection> getFilmProjections() throws PersistenceException;
   public void addToFilmProjections(FilmProjection arg) throws PersistenceException;
   public boolean removeFromFilmProjections(FilmProjection arg) throws PersistenceException;
}
