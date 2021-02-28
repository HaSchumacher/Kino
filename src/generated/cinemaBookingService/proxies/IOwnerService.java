/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaBookingService.OwnerService;
import generated.cinemaBookingService.Cinema;
import generated.cinemaBookingService.FilmProjection;
import generated.cinemaBookingService.MovieNotFoundInCinema;
import generated.cinemaBookingService.Movie;
import generated.cinemaBookingService.Cinemahall;
import generated.cinemaBookingService.MovieAlreadyinCinemahall;
import generated.cinemaBookingService.MovieCouldNotBeDeleated;
public interface IOwnerService extends Identifiable{
   public OwnerService getTheObject();
   public Integer getId();
   public Cinema getCinema() throws PersistenceException;
   public void setCinema(Cinema newCinema)throws PersistenceException;
   public void buildCinema();
   public Integer calculateOutcome(FilmProjection ofFilm)throws MovieNotFoundInCinema;
   public Integer calculateFullOutcome()throws MovieNotFoundInCinema;
   public String addFilmprojection(Movie movie, Cinemahall cinemahall)throws MovieAlreadyinCinemahall;
   public Boolean deleteGivenFilmFromCinemahall(Movie movie)throws MovieCouldNotBeDeleated;
}
