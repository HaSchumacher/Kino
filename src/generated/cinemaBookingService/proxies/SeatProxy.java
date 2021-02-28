/**--- Generated at Sun Feb 28 15:53:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.Seat;
import java.sql.ResultSet;
import generated.cinemaBookingService.CinemaRow;
import java.util.Set;
import generated.cinemaBookingService.Reservation;
public class SeatProxy implements ISeat{
   private Integer id;
   private Optional<Seat> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public SeatProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public SeatProxy(Seat theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Seat getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Seat";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Seat load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Seat", this.id);
         return Seat.createAlreadyPersistent(this);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<CinemaRow> getMyRow() throws PersistenceException{
      return this.getTheObject().getMyRow();
   }
   public Set<Reservation> getMyReservation() throws PersistenceException{
      return this.getTheObject().getMyReservation();
   }
   public Integer getPrice(){
      return this.getTheObject().getPrice();
   }
}
