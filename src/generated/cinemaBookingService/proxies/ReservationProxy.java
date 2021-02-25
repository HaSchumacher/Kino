/**--- Generated at Thu Feb 25 15:23:56 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaBookingService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaBookingService.Reservation;
import java.sql.ResultSet;
import generated.cinemaBookingService.Seat;
import generated.cinemaBookingService.relationControl.reservation_seatSupervisor;
import generated.cinemaBookingService.FilmProjection;
import generated.cinemaBookingService.relationControl.reservation_filmprojectionSupervisor;
import generated.cinemaBookingService.Booking;
import java.util.Set;
public class ReservationProxy implements IReservation{
   private Integer id;
   private Optional<Reservation> theObject;
   private DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReservationProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservationProxy(Reservation theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reservation getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reservation";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reservation load() throws PersistenceException {
      ResultSet rs = null;
      try {
         rs = DBExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reservation", this.id);
         Seat mySeat = reservation_seatSupervisor.getInstance().getMySeat(this).getTheObject();
         FilmProjection myfilmprojection = reservation_filmprojectionSupervisor.getInstance().getMyfilmprojection(this).getTheObject();
         return Reservation.createAlreadyPersistent(this, mySeat, myfilmprojection);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Seat getMySeat() throws PersistenceException{
      return this.getTheObject().getMySeat();
   }
   public void setMySeat(Seat newMySeat)throws PersistenceException{
      this.getTheObject().setMySeat(newMySeat);
   }
   public FilmProjection getMyfilmprojection() throws PersistenceException{
      return this.getTheObject().getMyfilmprojection();
   }
   public void setMyfilmprojection(FilmProjection newMyfilmprojection)throws PersistenceException{
      this.getTheObject().setMyfilmprojection(newMyfilmprojection);
   }
   public Set<Booking> getMyBooking() throws PersistenceException{
      return this.getTheObject().getMyBooking();
   }
}
