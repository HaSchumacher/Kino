/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.FilmProjection;
import java.sql.ResultSet;
import generated.cinemaBookingService.Cinemahall;
import generated.cinemaBookingService.relationControl.filmprojection_CinemahallSupervisor;
import generated.cinemaBookingService.Movie;
import generated.cinemaBookingService.relationControl.filmprojection_moveSupervisor;
public class FilmProjectionProxy implements IFilmProjection{
   private Integer id;
   private Optional<FilmProjection> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public FilmProjectionProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public FilmProjectionProxy(FilmProjection theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public FilmProjection getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "FilmProjection";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilmProjection)) return false;
      return ((IFilmProjection)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private FilmProjection load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("FilmProjection", this.id);
         Cinemahall myCinemahall = filmprojection_CinemahallSupervisor.getInstance().getMyCinemahall(this).getTheObject();
         Movie myMovie = filmprojection_moveSupervisor.getInstance().getMyMovie(this).getTheObject();
         return FilmProjection.createAlreadyPersistent(this, myCinemahall, myMovie);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Cinemahall getMyCinemahall() throws PersistenceException{
      return this.getTheObject().getMyCinemahall();
   }
   public void setMyCinemahall(Cinemahall newMyCinemahall)throws PersistenceException{
      this.getTheObject().setMyCinemahall(newMyCinemahall);
   }
   public Movie getMyMovie() throws PersistenceException{
      return this.getTheObject().getMyMovie();
   }
   public void setMyMovie(Movie newMyMovie)throws PersistenceException{
      this.getTheObject().setMyMovie(newMyMovie);
   }
   public Integer calculateOutcome(){
      return this.getTheObject().calculateOutcome();
   }
}
