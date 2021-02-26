/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import java.util.Optional;
import java.sql.ResultSet;
import db.executer.DBExecuterFactory;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaBookingService.proxies.ICinema;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import java.util.List;
import java.util.ArrayList;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Cinema extends Observable implements java.io.Serializable, ICinema
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Cinema> theInstance = Optional.empty();
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Cinema(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   private static Cinema createAlreadyPersistent(Integer id){
      return new Cinema(id, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Cinema getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Cinema load() throws PersistenceException {
      try{
         Integer typeKey = TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "Cinema");
         ResultSet rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Cinema", typeKey);
         rs.next();
         return Cinema.createAlreadyPersistent(rs.getInt("id"));
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Cinema getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinema)) return false;
      return ((ICinema)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Cinemahall> getCinemahalls() throws PersistenceException{
      List<Cinemahall> result = new ArrayList<>();
      for (ICinemahall i : cinema_cinemahallsSupervisor.getInstance().getCinemahalls(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToCinemahalls(Cinemahall arg) throws PersistenceException{
      cinema_cinemahallsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromCinemahalls(Cinemahall arg) throws PersistenceException{
      return cinema_cinemahallsSupervisor.getInstance().remove(this, arg);
   }
   public List<FilmProjection> getFilmProjections() throws PersistenceException{
      List<FilmProjection> result = new ArrayList<>();
      for (IFilmProjection i : allFilmProjectionsSupervisor.getInstance().getFilmProjections(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToFilmProjections(FilmProjection arg) throws PersistenceException{
      allFilmProjectionsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromFilmProjections(FilmProjection arg) throws PersistenceException{
      return allFilmProjectionsSupervisor.getInstance().remove(this, arg);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
