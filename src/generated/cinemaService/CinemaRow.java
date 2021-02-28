/**--- Generated at Sun Feb 28 15:38:46 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.CinemaRowProxy;
import observation.Observable;
import generated.cinemaService.proxies.ICinemaRow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class CinemaRow extends Observable implements java.io.Serializable, ICinemaRow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer number;
   private Boolean bookedUp;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private CinemaRow(Integer id, PriceCategory priceCategory, Integer number, Boolean bookedUp, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      CinemaRow_PriceCategorySupervisor.getInstance().set(this, priceCategory);
      this.number = number;
      this.bookedUp = bookedUp;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static CinemaRow createAlreadyPersistent(CinemaRowProxy proxy, PriceCategory priceCategory, Integer number, Boolean bookedUp)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new CinemaRow(proxy.getId(), priceCategory, number, bookedUp, true);
   }
   public static CinemaRow createFresh(PriceCategory priceCategory, Integer number, Boolean bookedUp)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("CinemaRow", "id, typeKey, number, bookedUp", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "CinemaRow").toString() + ", " + number.toString() + ", " + bookedUp.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      CinemaRow me = new CinemaRow(id, priceCategory, number, bookedUp, false);
      CinemaService.getInstance().addCinemaRowProxy(new CinemaRowProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public CinemaRow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICinemaRow)) return false;
      return ((ICinemaRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Seat> getMySeats() throws PersistenceException{
      List<Seat> result = new ArrayList<>();
      for (ISeat i : CinemaRow_SeatsSupervisor.getInstance().getMySeats(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMySeats(Seat arg) throws ConstraintViolation, PersistenceException{
      CinemaRow_SeatsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMySeats(Seat arg) throws ConstraintViolation, PersistenceException{
      return CinemaRow_SeatsSupervisor.getInstance().remove(this, arg);
   }
   public PriceCategory getPriceCategory() throws PersistenceException{
      return CinemaRow_PriceCategorySupervisor.getInstance().getPriceCategory(this).getTheObject();
   }
   public void setPriceCategory(PriceCategory newPriceCategory)throws PersistenceException{
      CinemaRow_PriceCategorySupervisor.getInstance().change(this, this.getPriceCategory(), newPriceCategory);
   }
   public Integer getNumber() {
      return this.number;
   }
   public void setNumber(Integer newNumber) throws PersistenceException{
      this.number = newNumber;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("CinemaRow", "number", newNumber.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getBookedUp() {
      return this.bookedUp;
   }
   public void setBookedUp(Boolean newBookedUp) throws PersistenceException{
      this.bookedUp = newBookedUp;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("CinemaRow", "bookedUp", newBookedUp.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
