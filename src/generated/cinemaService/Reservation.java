/**--- Generated at Sun Mar 14 13:22:12 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IBooking;
import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.proxies.ReservationProxy;
import generated.cinemaService.relationControl.Booking_ReservationSupervisor;
import generated.cinemaService.relationControl.Reservation_FpSupervisor;
import generated.cinemaService.relationControl.Reservation_SeatSupervisor;
import generated.cinemaService.relationControl.Reservation_UserSupervisor;
import observation.Observable;

//25 ===== GENERATED:      Header Section =========
public class Reservation extends Observable implements java.io.Serializable, IReservation
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 3046322515974490371L;
//30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Boolean deleted;
   private Boolean booked;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation(Integer id, Seat mySeat, Filmprojection myFilmprojection, User myCustomer, Boolean deleted, Boolean booked, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      Reservation_SeatSupervisor.getInstance().set(this, mySeat);
      Reservation_FpSupervisor.getInstance().set(this, myFilmprojection);
      Reservation_UserSupervisor.getInstance().set(this, myCustomer);
      this.deleted = deleted;
      this.booked = booked;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reservation createAlreadyPersistent(ReservationProxy proxy, Seat mySeat, Filmprojection myFilmprojection, User myCustomer, Boolean deleted, Boolean booked)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reservation(proxy.getId(), mySeat, myFilmprojection, myCustomer, deleted, booked, true);
   }
   public static Reservation createFresh(Seat mySeat, Filmprojection myFilmprojection, User myCustomer, Boolean deleted, Boolean booked)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reservation", "id, typeKey, deleted, booked", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Reservation").toString() + ", " + deleted.toString() + ", " + booked.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reservation me = new Reservation(id, mySeat, myFilmprojection, myCustomer, deleted, booked, false);
      CinemaService.getInstance().addReservationProxy(new ReservationProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Reservation getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Seat getMySeat() throws PersistenceException{
      return Reservation_SeatSupervisor.getInstance().getMySeat(this).getTheObject();
   }
   public void setMySeat(Seat newMySeat)throws PersistenceException{
      Reservation_SeatSupervisor.getInstance().change(this, this.getMySeat(), newMySeat);
   }
   public Filmprojection getMyFilmprojection() throws PersistenceException{
      return Reservation_FpSupervisor.getInstance().getMyFilmprojection(this).getTheObject();
   }
   public void setMyFilmprojection(Filmprojection newMyFilmprojection)throws PersistenceException{
      Reservation_FpSupervisor.getInstance().change(this, this.getMyFilmprojection(), newMyFilmprojection);
   }
   public User getMyCustomer() throws PersistenceException{
      return Reservation_UserSupervisor.getInstance().getMyCustomer(this).getTheObject();
   }
   public void setMyCustomer(User newMyCustomer)throws PersistenceException{
      Reservation_UserSupervisor.getInstance().change(this, this.getMyCustomer(), newMyCustomer);
   }
   public Boolean getDeleted() {
      return this.deleted;
   }
   public void setDeleted(Boolean newDeleted) throws PersistenceException{
      this.deleted = newDeleted;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Reservation", "deleted", newDeleted.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getBooked() {
      return this.booked;
   }
   public void setBooked(Boolean newBooked) throws PersistenceException{
      this.booked = newBooked;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Reservation", "booked", newBooked.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Set<Booking> getMyBooking() throws PersistenceException{
      Set<Booking> result = new HashSet<>();
      for (IBooking i : Booking_ReservationSupervisor.getInstance().getMyBooking(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
   @Override
	public String toString() {
		try {
			return this.getMyFilmprojection().toString() + " -> " + "(" + this.getMySeat().getMyRow().toString() + ", "
					+ this.getMySeat().toString() + ")";
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return this.id.toString();
	}
//90 ===== GENERATED: End of Your Operations ======
}
