/**--- Generated at Thu Feb 25 17:02:37 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.CinemahallProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.ICinemahall;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Cinemahall extends Observable implements java.io.Serializable, ICinemahall
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Boolean open;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Cinemahall(Integer id, Boolean open, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.open = open;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Cinemahall createAlreadyPersistent(CinemahallProxy proxy, Boolean open){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Cinemahall(proxy.getId(), open, true);
   }
   public static Cinemahall createFresh(Boolean open)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Cinemahall", "id, typeKey, open", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "Cinemahall").toString() + ", " + open.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Cinemahall me = new Cinemahall(id, open, false);
      CinemaBookingService.getInstance().addCinemahallProxy(new CinemahallProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Cinemahall getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinemahall)) return false;
      return ((ICinemahall)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<CinemaRow> getMyrow() throws PersistenceException{
      List<CinemaRow> result = new ArrayList<>();
      for (ICinemaRow i : rowsSupervisor.getInstance().getMyrow(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMyrow(CinemaRow arg) throws PersistenceException{
      rowsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMyrow(CinemaRow arg) throws PersistenceException{
      return rowsSupervisor.getInstance().remove(this, arg);
   }
   public Boolean getOpen() {
      return this.open;
   }
   public void setOpen(Boolean newOpen) throws PersistenceException{
      this.open = newOpen;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Cinemahall", "open", newOpen.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
