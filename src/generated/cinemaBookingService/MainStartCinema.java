/**--- Generated at Thu Feb 25 17:02:38 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.MainStartCinemaProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.IMainStartCinema;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class MainStartCinema extends Observable implements java.io.Serializable, IMainStartCinema
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private MainStartCinema(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static MainStartCinema createAlreadyPersistent(MainStartCinemaProxy proxy){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new MainStartCinema(proxy.getId(), true);
   }
   public static MainStartCinema createFresh()throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("MainStartCinema", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "MainStartCinema").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      MainStartCinema me = new MainStartCinema(id, false);
      CinemaBookingService.getInstance().addMainStartCinemaProxy(new MainStartCinemaProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public MainStartCinema getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMainStartCinema)) return false;
      return ((IMainStartCinema)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   //80 ===== Editable : Your Operations =============
   public static void main(String[] args) {
		try {
			CinemaBookingService cinemaService = new CinemaBookingService();
			Cinema cinema = Cinema.getInstance();
			OwnerService ownerService = OwnerService.createFresh(cinema);
			
			System.out.println(cinema.getFilmProjections().toString());
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//90 ===== GENERATED: End of Your Operations ======
}
