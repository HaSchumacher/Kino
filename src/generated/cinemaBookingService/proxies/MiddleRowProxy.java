/**--- Generated at Thu Feb 25 15:23:55 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.MiddleRow;
import java.sql.ResultSet;
public class MiddleRowProxy extends CinemaRowProxy implements IMiddleRow{
   private Integer id;
   private Optional<MiddleRow> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public MiddleRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public MiddleRowProxy(MiddleRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public MiddleRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "MiddleRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMiddleRow)) return false;
      return ((IMiddleRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private MiddleRow load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("CinemaRow", this.id);
         Integer price = rs.getInt("price");
         Boolean bookedUp = rs.getBoolean("bookedUp");
         return MiddleRow.createAlreadyPersistent(this, price, bookedUp);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}
