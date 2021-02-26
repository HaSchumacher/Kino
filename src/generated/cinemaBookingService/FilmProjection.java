/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.FilmProjectionProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.IFilmProjection;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class FilmProjection extends Observable implements java.io.Serializable, IFilmProjection
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private FilmProjection(Integer id, Cinemahall myCinemahall, Movie myMovie, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      filmprojection_CinemahallSupervisor.getInstance().set(this, myCinemahall);
      filmprojection_moveSupervisor.getInstance().set(this, myMovie);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static FilmProjection createAlreadyPersistent(FilmProjectionProxy proxy, Cinemahall myCinemahall, Movie myMovie)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new FilmProjection(proxy.getId(), myCinemahall, myMovie, true);
   }
   public static FilmProjection createFresh(Cinemahall myCinemahall, Movie myMovie)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("FilmProjection", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "FilmProjection").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      FilmProjection me = new FilmProjection(id, myCinemahall, myMovie, false);
      CinemaBookingService.getInstance().addFilmProjectionProxy(new FilmProjectionProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public FilmProjection getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilmProjection)) return false;
      return ((IFilmProjection)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Cinemahall getMyCinemahall() throws PersistenceException{
      return filmprojection_CinemahallSupervisor.getInstance().getMyCinemahall(this).getTheObject();
   }
   public void setMyCinemahall(Cinemahall newMyCinemahall)throws PersistenceException{
      filmprojection_CinemahallSupervisor.getInstance().change(this, this.getMyCinemahall(), newMyCinemahall);
   }
   public Movie getMyMovie() throws PersistenceException{
      return filmprojection_moveSupervisor.getInstance().getMyMovie(this).getTheObject();
   }
   public void setMyMovie(Movie newMyMovie)throws PersistenceException{
      filmprojection_moveSupervisor.getInstance().change(this, this.getMyMovie(), newMyMovie);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Calculate the current Outcome
 */
   public Integer calculateOutcome(){
      // TODO: Implement Operation calculateOutcome
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
