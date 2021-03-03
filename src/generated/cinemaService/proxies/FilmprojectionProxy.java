/**--- Generated at Tue Mar 02 17:45:31 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Filmprojection;
import java.sql.ResultSet;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.relationControl.fp_CinemahallSupervisor;
import generated.cinemaService.Movie;
import generated.cinemaService.relationControl.fp_movieSupervisor;
public class FilmprojectionProxy implements IFilmprojection{
   private Integer id;
   private Optional<Filmprojection> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public FilmprojectionProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public FilmprojectionProxy(Filmprojection theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Filmprojection getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Filmprojection";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilmprojection)) return false;
      return ((IFilmprojection)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Filmprojection load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Filmprojection", this.id);
         Cinemahall myHall = fp_CinemahallSupervisor.getInstance().getMyHall(this).getTheObject();
         Movie myMovie = fp_movieSupervisor.getInstance().getMyMovie(this).getTheObject();
         return Filmprojection.createAlreadyPersistent(this, myHall, myMovie);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Cinemahall getMyHall() throws PersistenceException{
      return this.getTheObject().getMyHall();
   }
   public void setMyHall(Cinemahall newMyHall)throws PersistenceException{
      this.getTheObject().setMyHall(newMyHall);
   }
   public Movie getMyMovie() throws PersistenceException{
      return this.getTheObject().getMyMovie();
   }
   public void setMyMovie(Movie newMyMovie)throws PersistenceException{
      this.getTheObject().setMyMovie(newMyMovie);
   }
   public Integer calculateProfit() throws PersistenceException{
      return this.getTheObject().calculateProfit();
   }
}
