/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import observation.Observable;
import generated.cinemaBookingService.proxies.ICinemaRow;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
import db.executer.PersistenceExecuterFactory;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaBookingService.proxies.ICinemahall;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class CinemaRow extends Observable implements java.io.Serializable, ICinemaRow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer price;
   private Boolean bookedUp;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public CinemaRow(Integer id, Integer price, Boolean bookedUp, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.price = price;
      this.bookedUp = bookedUp;
      if(objectOnly) return;
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
      for (ISeat i : Row_to_SeatSupervisor.getInstance().getMySeats(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToMySeats(Seat arg) throws PersistenceException{
      Row_to_SeatSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromMySeats(Seat arg) throws PersistenceException{
      return Row_to_SeatSupervisor.getInstance().remove(this, arg);
   }
   public Integer getPrice() {
      return this.price;
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.price = newPrice;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("CinemaRow", "price", newPrice.toString(), this.getId());
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
   public Set<Cinemahall> getMyHall() throws PersistenceException{
      Set<Cinemahall> result = new HashSet<>();
      for (ICinemahall i : rowsSupervisor.getInstance().getMyHall(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
/**
 * adding a Seat to this row
 */
   public abstract void addSeat(Seat seat);
/**
 * Delete the given Seat of Row
 */
   public abstract Boolean deleteSeat(Seat seat);
//90 ===== GENERATED: End of Your Operations ======
}
