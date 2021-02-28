/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.OwnerService;
import java.sql.ResultSet;
import generated.cinemaBookingService.Cinema;
import generated.cinemaBookingService.relationControl.cinemaSupervisor;
import generated.cinemaBookingService.FilmProjection;
import generated.cinemaBookingService.MovieNotFoundInCinema;
import generated.cinemaBookingService.Movie;
import generated.cinemaBookingService.Cinemahall;
import generated.cinemaBookingService.MovieAlreadyinCinemahall;
import generated.cinemaBookingService.MovieCouldNotBeDeleated;
public class OwnerServiceProxy implements IOwnerService{
   private Integer id;
   private Optional<OwnerService> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public OwnerServiceProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public OwnerServiceProxy(OwnerService theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public OwnerService getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "OwnerService";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IOwnerService)) return false;
      return ((IOwnerService)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private OwnerService load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("OwnerService", this.id);
         Cinema cinema = cinemaSupervisor.getInstance().getCinema(this).getTheObject();
         return OwnerService.createAlreadyPersistent(this, cinema);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Cinema getCinema() throws PersistenceException{
      return this.getTheObject().getCinema();
   }
   public void setCinema(Cinema newCinema)throws PersistenceException{
      this.getTheObject().setCinema(newCinema);
   }
   public void buildCinema(){
      this.getTheObject().buildCinema();
   }
   public Integer calculateOutcome(FilmProjection ofFilm)throws MovieNotFoundInCinema{
      return this.getTheObject().calculateOutcome(ofFilm);
   }
   public Integer calculateFullOutcome()throws MovieNotFoundInCinema{
      return this.getTheObject().calculateFullOutcome();
   }
   public String addFilmprojection(Movie movie, Cinemahall cinemahall)throws MovieAlreadyinCinemahall{
      return this.getTheObject().addFilmprojection(movie, cinemahall);
   }
   public Boolean deleteGivenFilmFromCinemahall(Movie movie)throws MovieCouldNotBeDeleated{
      return this.getTheObject().deleteGivenFilmFromCinemahall(movie);
   }
}
