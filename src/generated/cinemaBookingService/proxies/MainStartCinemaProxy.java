/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.MainStartCinema;
import java.sql.ResultSet;
public class MainStartCinemaProxy implements IMainStartCinema{
   private Integer id;
   private Optional<MainStartCinema> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public MainStartCinemaProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public MainStartCinemaProxy(MainStartCinema theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public MainStartCinema getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "MainStartCinema";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMainStartCinema)) return false;
      return ((IMainStartCinema)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private MainStartCinema load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("MainStartCinema", this.id);
         return MainStartCinema.createAlreadyPersistent(this);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}
