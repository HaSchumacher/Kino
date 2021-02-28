/**--- Generated at Sun Feb 28 15:53:02 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.OwnerServiceProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.IOwnerService;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class OwnerService extends Observable implements java.io.Serializable, IOwnerService
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private OwnerService(Integer id, Cinema cinema, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      cinemaSupervisor.getInstance().set(this, cinema);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static OwnerService createAlreadyPersistent(OwnerServiceProxy proxy, Cinema cinema)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new OwnerService(proxy.getId(), cinema, true);
   }
   public static OwnerService createFresh(Cinema cinema)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("OwnerService", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "OwnerService").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      OwnerService me = new OwnerService(id, cinema, false);
      CinemaBookingService.getInstance().addOwnerServiceProxy(new OwnerServiceProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public OwnerService getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IOwnerService)) return false;
      return ((IOwnerService)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Cinema getCinema() throws PersistenceException{
      return cinemaSupervisor.getInstance().getCinema(this).getTheObject();
   }
   public void setCinema(Cinema newCinema)throws PersistenceException{
      cinemaSupervisor.getInstance().change(this, this.getCinema(), newCinema);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Build the Cinema
 */
   public void buildCinema(){
      // TODO: Implement Operation buildCinema
      return;
   }
/**
 * Calculate the Outcome for one Movie
 */
   public Integer calculateOutcome(FilmProjection ofFilm)throws MovieNotFoundInCinema{
      // TODO: Implement Operation calculateOutcome
      return null;
   }
/**
 * Calculate the Outcome of all Filmprojections
 */
   public Integer calculateFullOutcome()throws MovieNotFoundInCinema{
      // TODO: Implement Operation calculateFullOutcome
      return null;
   }
/**
 * Add Film Projection to Cinema
 */
   public String addFilmprojection(Movie movie, Cinemahall cinemahall)throws MovieAlreadyinCinemahall{
      // TODO: Implement Operation addFilmprojection
      return null;
   }
/**
 * Delete Film Projection
 */
   public Boolean deleteGivenFilmFromCinemahall(Movie movie)throws MovieCouldNotBeDeleated{
      // TODO: Implement Operation deleteGivenFilmFromCinemahall
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
