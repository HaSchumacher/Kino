/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.FilmprojectionProxy;
import observation.Observable;
import generated.cinemaService.proxies.IFilmprojection;
import generated.cinemaService.relationControl.*;
import db.executer.PersistenceException;

//25 ===== GENERATED:      Header Section =========
public class Filmprojection extends Observable implements java.io.Serializable, IFilmprojection
{
	private static final long serialVersionUID = -7497683603820005761L;
//30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Filmprojection(Integer id, Cinemahall myHall, Movie myMovie, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      fp_CinemahallSupervisor.getInstance().set(this, myHall);
      fp_movieSupervisor.getInstance().set(this, myMovie);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Filmprojection createAlreadyPersistent(FilmprojectionProxy proxy, Cinemahall myHall, Movie myMovie)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Filmprojection(proxy.getId(), myHall, myMovie, true);
   }
   public static Filmprojection createFresh(Cinemahall myHall, Movie myMovie)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Filmprojection", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaService", "Filmprojection").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Filmprojection me = new Filmprojection(id, myHall, myMovie, false);
      CinemaService.getInstance().addFilmprojectionProxy(new FilmprojectionProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Filmprojection getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilmprojection)) return false;
      return ((IFilmprojection)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Cinemahall getMyHall() throws PersistenceException{
      return fp_CinemahallSupervisor.getInstance().getMyHall(this).getTheObject();
   }
   public void setMyHall(Cinemahall newMyHall)throws PersistenceException{
      fp_CinemahallSupervisor.getInstance().change(this, this.getMyHall(), newMyHall);
   }
   public Movie getMyMovie() throws PersistenceException{
      return fp_movieSupervisor.getInstance().getMyMovie(this).getTheObject();
   }
   public void setMyMovie(Movie newMyMovie)throws PersistenceException{
      fp_movieSupervisor.getInstance().change(this, this.getMyMovie(), newMyMovie);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Calculate the Profit on this Filmprojection
 * @throws PersistenceException 
 */
public Integer calculateProfit() throws PersistenceException {
	Integer sum = 0;
	for (CinemaRow row : this.getMyHall().getMyRows()) {
		for (Seat seat : row.getMySeats()) {
			if (!seat.getMyReservation().isEmpty()) {
				Set<Reservation> reservations = seat.getMyReservation();
				for (Reservation currentRes : reservations) {
					if (currentRes.getMyFilmprojection().equals(this)) {
						if (!currentRes.getMyBooking().isEmpty()) {
							Optional<Integer> opPrice = seat.getMyRow().getPriceCategory().getPrice();
							if (opPrice.isPresent()) {
								sum += opPrice.get();
							}
						}
					}
				}
			}
		}
	}
	// TODO workaround with /2 because for each loop is processed twice for each element...
	return sum/2;
}
//90 ===== GENERATED: End of Your Operations ======
	@Override
	public String toString() {
		try {
			return "Saal: " + this.getMyHall().getName() + " Film: " + this.getMyMovie().getTitle();
		} catch (PersistenceException e) {
			System.out.println(e);
		}
		return this.toString();
	}
}
