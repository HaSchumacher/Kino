/**--- Generated at Tue Mar 02 12:07:23 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.MovieProxy;
import observation.Observable;
import generated.cinemaService.proxies.IMovie;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Movie extends Observable implements java.io.Serializable, IMovie
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String title;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Movie(Integer id, String title, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.title = title;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Movie createAlreadyPersistent(MovieProxy proxy, String title){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Movie(proxy.getId(), title, true);
   }
   public static Movie createFresh(String title)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Movie", "id, typeKey, title", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Movie").toString() + ", " + "'" + title + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Movie me = new Movie(id, title, false);
      CinemaService.getInstance().addMovieProxy(new MovieProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Movie getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMovie)) return false;
      return ((IMovie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getTitle() {
      return this.title;
   }
   public void setTitle(String newTitle) throws PersistenceException{
      this.title = newTitle;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Movie", "title", "'" + newTitle + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
