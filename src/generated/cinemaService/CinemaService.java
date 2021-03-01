/**--- Generated at Mon Mar 01 12:40:20 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.cinemaService.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.DBDMLExecuter;
import db.connection.TypeKeyManager;
import db.connection.DBConnectionManager;
import db.connection.DBConnectionData;
import java.util.Map;
import java.util.Collection;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class CinemaService extends Observable{
   DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,CinemahallProxy> cinemahallCache;
   private Map<Integer,CinemaRowProxy> cinemaRowCache;
   private Map<Integer,SeatProxy> seatCache;
   private Map<Integer,FilmprojectionProxy> filmprojectionCache;
   private Map<Integer,MovieProxy> movieCache;
   private Map<Integer,ReservationProxy> reservationCache;
   private Map<Integer,BookingProxy> bookingCache;
   private Map<Integer,UserProxy> userCache;
   private static CinemaService theInstance = new CinemaService();
   private CinemaService(){
      try{DBConnectionManager.getTheInstance().openDBConnection(new DBConnectionData("jdbc:mysql://localhost:3306", "CinemaService", "root" , ""));
         TypeKeyManager.getTheInstance().initializeFor("CinemaService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static CinemaService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.cinemahallCache = new InitialProxyLoader<CinemahallProxy>("generated", "CinemaService", "cinemaService", "Cinemahall", "Cinemahall").perform();
      this.cinemaRowCache = new InitialProxyLoader<CinemaRowProxy>("generated", "CinemaService", "cinemaService", "CinemaRow", "CinemaRow").perform();
      this.seatCache = new InitialProxyLoader<SeatProxy>("generated", "CinemaService", "cinemaService", "Seat", "Seat").perform();
      this.filmprojectionCache = new InitialProxyLoader<FilmprojectionProxy>("generated", "CinemaService", "cinemaService", "Filmprojection", "Filmprojection").perform();
      this.movieCache = new InitialProxyLoader<MovieProxy>("generated", "CinemaService", "cinemaService", "Movie", "Movie").perform();
      this.reservationCache = new InitialProxyLoader<ReservationProxy>("generated", "CinemaService", "cinemaService", "Reservation", "Reservation").perform();
      this.bookingCache = new InitialProxyLoader<BookingProxy>("generated", "CinemaService", "cinemaService", "Booking", "Booking").perform();
      this.userCache = new InitialProxyLoader<UserProxy>("generated", "CinemaService", "cinemaService", "User", "User").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("Cinemahall_CinemaRow").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Cinemahall", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "CinemaRow", "CinemaService");
         try{this.addCinemahall_CinemaRowElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("CinemaRow_Seats").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "CinemaRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addCinemaRow_SeatsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("CinemaRow_PriceCategory").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "CinemaRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "PriceCategory", "CinemaService");
         try{this.addCinemaRow_PriceCategoryElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Reservation_Seat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addReservation_SeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("fp_Cinemahall").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Filmprojection", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Cinemahall", "CinemaService");
         try{this.addfp_CinemahallElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("fp_movie").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Filmprojection", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Movie", "CinemaService");
         try{this.addfp_movieElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Reservation_Fp").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Filmprojection", "CinemaService");
         try{this.addReservation_FpElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Reservation_User").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "User", "CinemaService");
         try{this.addReservation_UserElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Booking_Reservation").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Booking", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reservation", "CinemaService");
         try{this.addBooking_ReservationElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("User_Role").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "User", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Role", "CinemaService");
         try{this.addUser_RoleElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addCinemahall_CinemaRowElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinemahall proxy1 = null; ICinemaRow proxy2 = null; 
      if(className1.equals("Cinemahall"))  proxy1 = this.cinemahallCache.get(id1);
      if(className2.equals("CinemaRow"))  proxy2 = this.cinemaRowCache.get(id2);
      Cinemahall_CinemaRowSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addCinemaRow_SeatsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinemaRow proxy1 = null; ISeat proxy2 = null; 
      if(className1.equals("CinemaRow"))  proxy1 = this.cinemaRowCache.get(id1);
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      CinemaRow_SeatsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addCinemaRow_PriceCategoryElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinemaRow proxy1 = null; IPriceCategory proxy2 = null; 
      if(className1.equals("CinemaRow"))  proxy1 = this.cinemaRowCache.get(id1);
      if(className2.equals("Front"))  proxy2 = Front.getInstance();
      if(className2.equals("Middle"))  proxy2 = Middle.getInstance();
      if(className2.equals("Back"))  proxy2 = Back.getInstance();
      CinemaRow_PriceCategorySupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addReservation_SeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      Reservation_SeatSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addfp_CinemahallElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IFilmprojection proxy1 = null; ICinemahall proxy2 = null; 
      if(className2.equals("Cinemahall"))  proxy2 = this.cinemahallCache.get(id2);
      if(className1.equals("Filmprojection"))  proxy1 = this.filmprojectionCache.get(id1);
      fp_CinemahallSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addfp_movieElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IFilmprojection proxy1 = null; IMovie proxy2 = null; 
      if(className1.equals("Filmprojection"))  proxy1 = this.filmprojectionCache.get(id1);
      if(className2.equals("Movie"))  proxy2 = this.movieCache.get(id2);
      fp_movieSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addReservation_FpElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; IFilmprojection proxy2 = null; 
      if(className2.equals("Filmprojection"))  proxy2 = this.filmprojectionCache.get(id2);
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      Reservation_FpSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addReservation_UserElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; IUser proxy2 = null; 
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      if(className2.equals("User"))  proxy2 = this.userCache.get(id2);
      Reservation_UserSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addBooking_ReservationElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBooking proxy1 = null; IReservation proxy2 = null; 
      if(className2.equals("Reservation"))  proxy2 = this.reservationCache.get(id2);
      if(className1.equals("Booking"))  proxy1 = this.bookingCache.get(id1);
      Booking_ReservationSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addUser_RoleElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IUser proxy1 = null; IRole proxy2 = null; 
      if(className1.equals("User"))  proxy1 = this.userCache.get(id1);
      if(className2.equals("Customer"))  proxy2 = Customer.getInstance();
      if(className2.equals("Admin"))  proxy2 = Admin.getInstance();
      User_RoleSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   public Cinemahall getCinemahall(Integer id){
      return this.cinemahallCache.get(id).getTheObject();
   }
   public void addCinemahallProxy(CinemahallProxy p) throws PersistenceException{
      this.cinemahallCache.put(p.getId(), p);
   }
   public Map<Integer,CinemahallProxy> getCinemahallCache(){
      return this.cinemahallCache;
   }
   public CinemaRow getCinemaRow(Integer id){
      return this.cinemaRowCache.get(id).getTheObject();
   }
   public void addCinemaRowProxy(CinemaRowProxy p) throws PersistenceException{
      this.cinemaRowCache.put(p.getId(), p);
   }
   public Map<Integer,CinemaRowProxy> getCinemaRowCache(){
      return this.cinemaRowCache;
   }
   public Seat getSeat(Integer id){
      return this.seatCache.get(id).getTheObject();
   }
   public void addSeatProxy(SeatProxy p) throws PersistenceException{
      this.seatCache.put(p.getId(), p);
   }
   public Map<Integer,SeatProxy> getSeatCache(){
      return this.seatCache;
   }
   public Filmprojection getFilmprojection(Integer id){
      return this.filmprojectionCache.get(id).getTheObject();
   }
   public void addFilmprojectionProxy(FilmprojectionProxy p) throws PersistenceException{
      this.filmprojectionCache.put(p.getId(), p);
   }
   public Map<Integer,FilmprojectionProxy> getFilmprojectionCache(){
      return this.filmprojectionCache;
   }
   public Movie getMovie(Integer id){
      return this.movieCache.get(id).getTheObject();
   }
   public void addMovieProxy(MovieProxy p) throws PersistenceException{
      this.movieCache.put(p.getId(), p);
   }
   public Map<Integer,MovieProxy> getMovieCache(){
      return this.movieCache;
   }
   public Reservation getReservation(Integer id){
      return this.reservationCache.get(id).getTheObject();
   }
   public void addReservationProxy(ReservationProxy p) throws PersistenceException{
      this.reservationCache.put(p.getId(), p);
   }
   public Map<Integer,ReservationProxy> getReservationCache(){
      return this.reservationCache;
   }
   public Booking getBooking(Integer id){
      return this.bookingCache.get(id).getTheObject();
   }
   public void addBookingProxy(BookingProxy p) throws PersistenceException{
      this.bookingCache.put(p.getId(), p);
   }
   public Map<Integer,BookingProxy> getBookingCache(){
      return this.bookingCache;
   }
   public User getUser(Integer id){
      return this.userCache.get(id).getTheObject();
   }
   public void addUserProxy(UserProxy p) throws PersistenceException{
      this.userCache.put(p.getId(), p);
   }
   public Map<Integer,UserProxy> getUserCache(){
      return this.userCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      db.connection.DBConnectionManager.getTheInstance().close();
   }
   /**
	 * --- Generated at Sun Feb 28 14:35:57 CET 2021 //80 ===== Editable : Your
	 * Operations ============= /** Change Price on Pricecategory.
	 */
	public void changePriceCategory(PriceCategory c, Integer price) {
		// TODO: Implement Operation changePriceCategory
		return;
	}

	/**
	 * Login a User in CinemaService.
	 */
	public void login(String username, String password) throws LoginError {
		// TODO: Implement Operation login
		return;
	}

	/**
	 * Add a Cinemahall to the CinemaService.
	 * 
	 * @throws PersistenceException
	 * @throws ConstraintViolation
	 */
	public void addCinemahall(String name, Integer rows, Integer Seats)
			throws CinemaHallCreation, PersistenceException, ConstraintViolation {
		Cinemahall hall = Cinemahall.createFresh(false, name);
		Integer getEqualRows = rows / 3;
		if (getEqualRows * 3 == rows) {

			for (int i = 1; i <= getEqualRows; i++) {
				CinemaRow currentRow = CinemaRow.createFresh(Front.getInstance(), i, false);
				for (int j = 1; j <= Seats; j++) {
					currentRow.addToMySeats(Seat.createFresh(j, currentRow));
				}
				hall.addToMyRows(currentRow);
			}
			for (int i = 1; i <= getEqualRows; i++) {
				CinemaRow currentRow = CinemaRow.createFresh(Middle.getInstance(), getEqualRows + i, false);
				for (int j = 1; j <= Seats; j++) {
					currentRow.addToMySeats(Seat.createFresh(j, currentRow));
				}
				hall.addToMyRows(currentRow);
			}
			for (int i = 1; i <= getEqualRows; i++) {
				CinemaRow currentRow = CinemaRow.createFresh(Back.getInstance(), getEqualRows * 2 + i, false);
				for (int j = 1; j <= Seats; j++) {
					currentRow.addToMySeats(Seat.createFresh(j, currentRow));
				}
				hall.addToMyRows(currentRow);
			}

		} else {
			throw new CinemaHallCreation();
		}
	}

	/**
	 * Delete the given Cinemahall from CinemaService.
	 */
	public Boolean deleteCinemahall(Cinemahall c) throws DeleteError {
		if (this.cinemahallCache.containsKey(c.getId())) {
			this.cinemahallCache.remove(c.getId());
			return true;
		}
		return false;
	}

	/**
	 * add role to User.
	 */
	public Boolean addRoleToUser(User u, Role r) {
		// TODO: Implement Operation addRoleToUser
		return null;
	}

	/**
	 * registerAUserInSystem
	 */
	public void register(String name, String mail, String username, String passwort) throws RegisterError {
		// TODO: Implement Operation register
		return;
	}

	/**
	 * book a given reservation
	 */
	public void book(Reservation r) throws BookingError {
		// TODO: Implement Operation book
		return;
	}

	/**
	 * Calculate the Total Profit of the Cinema.
	 */
	public Integer calculateTotalProfit() {
		// TODO: Implement Operation calculateTotalProfit
		return null;
	}

	/**
	 * Adding a Filmprojection to the CinemaService.
	 */
	public void addFilmprojection(Cinemahall c, Movie m) throws PersistenceException {
		Filmprojection.createFresh(c, m);
	}

	/**
	 * Delete the Movie form the Cinema.
	 */
	public Boolean deleteMovie(Movie m) throws DeleteError {
		// TODO: Implement Operation deleteMovie
		return null;
	}

	/**
	 * Add a Movie to the Cinema.
	 * 
	 * @throws PersistenceException
	 */
	public void addMovie(String title) throws PersistenceException {
		Movie m = Movie.createFresh(title);
	}

	/**
	 * Logout the given User from Cinema Service.
	 */
	public Boolean logout(User user) {
		// TODO: Implement Operation logout
		return null;
	}

	/**
	 * Delete the given Filmprojection from CinemaService.
	 */
	public Boolean deleteFilmprojection(Filmprojection fp) throws DeleteError {
		// TODO: Implement Operation deleteFilmprojection
		return null;
	}

	/**
	 * delete Role from User.
	 */
	public Boolean deleteRoleFromUser(User u, Role r) throws DeleteError {
		// TODO: Implement Operation deleteRoleFromUser
		return null;
	}

	/**
	 * Cancel the given Reservation.
	 */
	public Boolean cancelReservation(Reservation r) throws DeleteError {
		// TODO: Implement Operation cancelReservation
		return null;
	}

	/**
	 * Calculate the Profit from one Filmprojection or more or all.
	 */
	public Integer calulateProfit(Collection<Filmprojection> fp) {
		// TODO: Implement Operation calulateProfit
		return null;
	}

	/**
	 * reservate a Seat in given Fp for user.
	 */
	public void reserve(User u, Filmprojection fp, PriceCategory c) throws ReservationError {
		// TODO: Implement Operation reserve
		return;
	}

	/**
	 * get the options for a user. what can i do in the cinemaservice.
	 * 
	 * @throws PersistenceException
	 */
	public String getOptions(User u) throws PersistenceException {
		String result = "";
		if (u.getMyRoles().contains(Admin.getInstance())) {
			result = result + 
					"As Admin you can do:"+
					"\n1: Cinema options." +
					"\n2: Filmprojection and Movie options."+
					"\n3: Profit options"+
					"\n4: User Management"+
					"\n************************* ";
			
		} else if (u.getMyRoles().contains(Customer.getInstance())) {
			result = result +
			"As Customer you can do:"+
			"\n1: Reservation"+
			"\n2: Book your Reservation"+
			"\n3: Get your Reservation"+
			"\n4: Get your Booking"+
			"\n************************* "+
			"\n0:Logout";
		}
			return result;
	}
//90 ===== GENERATED: End of Your Operations ======
}
