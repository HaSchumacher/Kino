/**--- Generated at Thu Feb 25 15:23:55 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.FilmProjection;
import generated.cinemaBookingService.Cinemahall;
import generated.cinemaBookingService.Movie;
public interface IFilmProjection extends Identifiable{
   public FilmProjection getTheObject();
   public Integer getId();
   public Cinemahall getMyCinemahall() throws PersistenceException;
   public void setMyCinemahall(Cinemahall newMyCinemahall)throws PersistenceException;
   public Movie getMyMovie() throws PersistenceException;
   public void setMyMovie(Movie newMyMovie)throws PersistenceException;
}
