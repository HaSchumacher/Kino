/**--- Generated at Fri Mar 05 17:39:16 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaService;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import db.connection.DBConnectionData;
import db.connection.DBConnectionManager;
import db.connection.TypeKeyManager;
import db.executer.DBDMLExecuter;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import generated.cinemaService.proxies.BookingProxy;
import generated.cinemaService.proxies.CinemaRowProxy;
import generated.cinemaService.proxies.CinemahallProxy;
import generated.cinemaService.proxies.FilmprojectionProxy;
import generated.cinemaService.proxies.IBooking;
import generated.cinemaService.proxies.ICinemaRow;
import generated.cinemaService.proxies.ICinemahall;
import generated.cinemaService.proxies.IFilmprojection;
import generated.cinemaService.proxies.IMovie;
import generated.cinemaService.proxies.IPriceCategory;
import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.proxies.IRole;
import generated.cinemaService.proxies.ISeat;
import generated.cinemaService.proxies.IUser;
import generated.cinemaService.proxies.KeyPairProxy;
import generated.cinemaService.proxies.MovieProxy;
import generated.cinemaService.proxies.ReservationProxy;
import generated.cinemaService.proxies.SeatProxy;
import generated.cinemaService.proxies.UserProxy;
import generated.cinemaService.relationControl.Booking_ReservationSupervisor;
import generated.cinemaService.relationControl.CinemaRow_PriceCategorySupervisor;
import generated.cinemaService.relationControl.CinemaRow_SeatsSupervisor;
import generated.cinemaService.relationControl.Cinemahall_CinemaRowSupervisor;
import generated.cinemaService.relationControl.Reservation_FpSupervisor;
import generated.cinemaService.relationControl.Reservation_SeatSupervisor;
import generated.cinemaService.relationControl.Reservation_UserSupervisor;
import generated.cinemaService.relationControl.User_RoleSupervisor;
import generated.cinemaService.relationControl.fp_CinemahallSupervisor;
import generated.cinemaService.relationControl.fp_movieSupervisor;
import observation.Observable;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
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
   private Map<Integer,KeyPairProxy> keyPairCache;
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
      this.keyPairCache = new InitialProxyLoader<KeyPairProxy>("generated", "CinemaService", "cinemaService", "KeyPair", "KeyPair").perform();
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
      if(className2.equals("Unknown"))  proxy2 = Unknown.getInstance();
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
   public KeyPair getKeyPair(Integer id){
      return this.keyPairCache.get(id).getTheObject();
   }
   public void addKeyPairProxy(KeyPairProxy p) throws PersistenceException{
      this.keyPairCache.put(p.getId(), p);
   }
   public Map<Integer,KeyPairProxy> getKeyPairCache(){
      return this.keyPairCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      db.connection.DBConnectionManager.getTheInstance().close();
   }
// 80 ===== Editable : Your Operations =============
	/**
	 * Change Price on Pricecategory.
	 * 
	 * @throws PersistenceException
	 */
	public Boolean changePriceCategory(PriceCategory c, Integer price) throws PersistenceException {
		c.setPrice(price);
		return true;
	}

	/**
	 * Delete the Movie form the Cinema.
	 */
	public Boolean deleteMovie(Movie m) throws DeleteError {
		Integer mid = m.getId();
		if (this.movieCache.containsKey(mid)) {
			this.movieCache.remove(mid);
			return true;
		} else {
			throw new DeleteError();
		}
	}

	/**
	 * Login a User in CinemaService.
	 * 
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 */
	public User login(String usercrypt, String pwcrypt, Integer id) throws LoginError, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		KeyPairProxy keyPair = this.keyPairCache.get(id);
		String pkey = keyPair.getPrivateKey();
		UserProxy loginuser = null;
		String username = Security.decrypt(usercrypt, pkey);
		String password = Security.decrypt(pwcrypt, pkey);
		for (Entry<Integer, UserProxy> user : this.userCache.entrySet()) {
			UserProxy userEntry = user.getValue();
			if (userEntry.getUsername() == username && userEntry.getPassword() == password) {
				loginuser = (UserProxy) user;
				return loginuser.getTheObject();
			}
		}
		throw new LoginError();
	}

	/**
	 * reservate a Seat in given Fp for user.
	 * 
	 * @throws PersistenceException
	 */
	public Reservation reserve(User u, Filmprojection fp, PriceCategory c)
			throws ReservationError, PersistenceException {
		List<CinemaRow> currRowlist = fp.getMyHall().getMyRows();
		for (int i = 0; i < currRowlist.size(); i++) {
			CinemaRow currRow = currRowlist.get(i);
			if (currRow.getPriceCategory().getId() == c.getId()) {
				if (!currRow.getBookedUp()) {
					List<Seat> currSeatList = currRow.getMySeats();
					for (int j = 0; j < currSeatList.size(); j++) {
						Seat currSeat = currSeatList.get(j);
						if (currSeat.getMyReservation().isEmpty()) {
							return Reservation.createFresh(currSeat, fp, u);
						}
					}
				}
			}
		}
		throw new ReservationError();
	}

	/**
	 * add role to User.
	 * 
	 * @throws PersistenceException
	 */
	public Boolean addRoleToUser(User u, Role r) throws PersistenceException {
		u.addToMyRoles(r);
		return true;
	}

	/**
	 * book a given reservation
	 * 
	 * @throws PersistenceException
	 */
	public Booking book(Reservation r) throws BookingError, PersistenceException {
		if (r.getMyBooking().isEmpty()) {
			return Booking.createFresh(r);
		}
		return null;
	}

	/**
	 * Get the Options for a User.
	 */
	public Collection<String> getOptions(Role r) {
		List<String> result = new ArrayList<String>();
		return result;
	}

	/**
	 * Check if the User has the role to use the Command.
	 */
	public Boolean checkPriviliges(User u) {
		// TODO: Implement Operation checkPriviliges
		return null;
	}

	/**
	 * Adding a Filmprojection to the CinemaService.
	 * 
	 * @throws PersistenceException
	 */
	public Filmprojection addFilmprojection(Cinemahall c, Movie m) throws PersistenceException {
		return Filmprojection.createFresh(c, m);
	}

	/**
	 * Calculate the Total Profit of the Cinema.
	 */
	public Integer calculateTotalProfit() {
		Integer sum = 0;
		for (Iterator<FilmprojectionProxy> iterator = this.filmprojectionCache.values().iterator(); iterator
				.hasNext();) {
			Filmprojection currentFP = iterator.next().getTheObject();
			sum = +currentFP.calculateProfit();
		}
		return sum;
	}

	/**
	 * Calculate the Profit from one Filmprojection or more or all.
	 */
	public Integer calulateProfit(Collection<Filmprojection> fp) {
		Integer sum = 0;
		for (Iterator<Filmprojection> iterator = fp.iterator(); iterator.hasNext();) {
			sum += iterator.next().calculateProfit();
		}
		return sum;
	}

	/**
	 * Cancel the given Reservation.
	 */
	public Boolean cancelReservation(Reservation r) throws DeleteError {
		if (this.getReservationCache().containsKey(r.getId())) {
			this.getReservationCache().remove(r.getId());
			return true;
		} else {
			throw new DeleteError();
		}
	}

	/**
	 * Delete the given Filmprojection from CinemaService.
	 */
	public Boolean deleteFilmprojection(Filmprojection fp) throws DeleteError {
		if (this.filmprojectionCache.containsKey(fp.getId())) {
			this.filmprojectionCache.remove(fp.getId());
			return true;
		} else
			throw new DeleteError();
	}

	/**
	 * Logout the given User from Cinema Service.
	 */
	public Boolean logout(User user) {
		// TODO: Logout - REferenz Keypair...
		return null;
	}

	/**
	 * Add a Cinemahall to the CinemaService.
	 * 
	 * @throws PersistenceException
	 * @throws ConstraintViolation
	 */
	public Cinemahall addCinemahall(String name, Integer rows, Integer Seats)
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
			return hall;
		} else {
			throw new CinemaHallCreation();
		}

	}

	/**
	 * registerAUserInSystem
	 * 
	 * @throws PersistenceException
	 */
	public User register(String name, String email, String username, String passwort)
			throws RegisterError, PersistenceException {
		return User.createFresh(name, email, username, passwort);
	}

	/**
	 * Delete the given Cinemahall from CinemaService.
	 */
	public Boolean deleteCinemahall(Cinemahall c) throws DeleteError {
		if (this.cinemahallCache.containsKey(c.getId())) {
			this.cinemahallCache.remove(c.getId());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add a Movie to the Cinema.
	 * 
	 * @throws PersistenceException
	 */
	public Movie addMovie(String title) throws PersistenceException {
		return Movie.createFresh(title);
	}

	/**
	 * delete Role from User.
	 * 
	 * @throws PersistenceException
	 */
	public Boolean deleteRoleFromUser(User u, Role r) throws DeleteError, PersistenceException {
		if (u.getMyRoles().contains(r)) {
			u.getMyRoles().remove(r);
			return true;
		} else {
			throw new DeleteError();
		}
	}

	/**
	 * get for login or register a public key.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws PersistenceException
	 */
	public ArrayList<String> generatePublicKey() throws NoSuchAlgorithmException, PersistenceException {
		//KeyPair keyPair = new KeyPair();
		KeyPair keyPair = KeyPair.createFresh("hello", "hello");
		//this.addKeyPairProxy(new KeyPairProxy(keyPair));
		ArrayList<String> result = new ArrayList<String>();
		result.add(keyPair.getId().toString());
		result.add(keyPair.getPublicKey());
		return result;
	}
//90 ===== GENERATED: End of Your Operations ======
}
