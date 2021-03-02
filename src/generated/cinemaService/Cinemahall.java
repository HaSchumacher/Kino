/**--- Generated at Tue Mar 02 12:07:22 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.CinemahallProxy;
import observation.Observable;
import generated.cinemaService.proxies.ICinemahall;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
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
   private String name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Cinemahall(Integer id, Boolean open, String name, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.open = open;
      this.name = name;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Cinemahall createAlreadyPersistent(CinemahallProxy proxy, Boolean open, String name){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Cinemahall(proxy.getId(), open, name, true);
   }
   public static Cinemahall createFresh(Boolean open, String name)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Cinemahall", "id, typeKey, open, name", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Cinemahall").toString() + ", " + open.toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Cinemahall me = new Cinemahall(id, open, name, false);
      CinemaService.getInstance().addCinemahallProxy(new CinemahallProxy(me));
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
   public List<CinemaRow> getMyRows() throws PersistenceException{
      List<CinemaRow> result = new ArrayList<>();
      for (ICinemaRow i : Cinemahall_CinemaRowSupervisor.getInstance().getMyRows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMyRows(CinemaRow arg) throws PersistenceException{
      Cinemahall_CinemaRowSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMyRows(CinemaRow arg) throws PersistenceException{
      return Cinemahall_CinemaRowSupervisor.getInstance().remove(this, arg);
   }
   public Boolean getOpen() {
      return this.open;
   }
   public void setOpen(Boolean newOpen) throws PersistenceException{
      this.open = newOpen;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Cinemahall", "open", newOpen.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Cinemahall", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
