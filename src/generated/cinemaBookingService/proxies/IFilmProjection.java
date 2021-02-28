/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
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
   public Integer calculateOutcome();
}
