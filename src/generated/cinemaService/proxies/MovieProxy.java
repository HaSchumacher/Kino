/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Movie;
import java.sql.ResultSet;
public class MovieProxy implements IMovie{
   private Integer id;
   private Optional<Movie> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public MovieProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public MovieProxy(Movie theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Movie getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Movie";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMovie)) return false;
      return ((IMovie)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Movie load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Movie", this.id);
         String title = rs.getString("title");
         return Movie.createAlreadyPersistent(this, title);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getTitle() {
      return this.getTheObject().getTitle();
   }
   public void setTitle(String newTitle) throws PersistenceException{
      this.getTheObject().setTitle(newTitle);
   }
}
