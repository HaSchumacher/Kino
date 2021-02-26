/**--- Generated at Thu Feb 25 17:10:42 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.cinemaBookingService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.cinemaBookingService.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.DBDMLExecuter;
import db.connection.TypeKeyManager;
import db.connection.DBConnectionManager;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class CinemaBookingService extends Observable{
   DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,CinemahallProxy> cinemahallCache;
   private Map<Integer,SeatProxy> seatCache;
   private Map<Integer,FrontRowProxy> frontRowCache;
   private Map<Integer,MiddleRowProxy> middleRowCache;
   private Map<Integer,BackRowProxy> backRowCache;
   private Map<Integer,MovieProxy> movieCache;
   private Map<Integer,FilmProjectionProxy> filmProjectionCache;
   private Map<Integer,ReservationProxy> reservationCache;
   private Map<Integer,VisitorProxy> visitorCache;
   private Map<Integer,BookingProxy> bookingCache;
   private Map<Integer,OwnerServiceProxy> ownerServiceCache;
   private Map<Integer,MainStartCinemaProxy> mainStartCinemaCache;
   private static CinemaBookingService theInstance = new CinemaBookingService();
   private CinemaBookingService(){
      try{DBConnectionManager.getTheInstance().openDBConnection(new DBConnectionData("jdbc:mysql://localhost:3306", "CinemaBookingService", "root" , ""));
         TypeKeyManager.getTheInstance().initializeFor("CinemaBookingService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static CinemaBookingService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.cinemahallCache = new InitialProxyLoader<CinemahallProxy>("generated", "CinemaBookingService", "cinemaBookingService", "Cinemahall", "Cinemahall").perform();
      this.seatCache = new InitialProxyLoader<SeatProxy>("generated", "CinemaBookingService", "cinemaBookingService", "Seat", "Seat").perform();
      this.frontRowCache = new InitialProxyLoader<FrontRowProxy>("generated", "CinemaBookingService", "cinemaBookingService", "FrontRow", "CinemaRow").perform();
      this.middleRowCache = new InitialProxyLoader<MiddleRowProxy>("generated", "CinemaBookingService", "cinemaBookingService", "MiddleRow", "CinemaRow").perform();
      this.backRowCache = new InitialProxyLoader<BackRowProxy>("generated", "CinemaBookingService", "cinemaBookingService", "BackRow", "CinemaRow").perform();
      this.movieCache = new InitialProxyLoader<MovieProxy>("generated", "CinemaBookingService", "cinemaBookingService", "Movie", "Movie").perform();
      this.filmProjectionCache = new InitialProxyLoader<FilmProjectionProxy>("generated", "CinemaBookingService", "cinemaBookingService", "FilmProjection", "FilmProjection").perform();
      this.reservationCache = new InitialProxyLoader<ReservationProxy>("generated", "CinemaBookingService", "cinemaBookingService", "Reservation", "Reservation").perform();
      this.visitorCache = new InitialProxyLoader<VisitorProxy>("generated", "CinemaBookingService", "cinemaBookingService", "Visitor", "Visitor").perform();
      this.bookingCache = new InitialProxyLoader<BookingProxy>("generated", "CinemaBookingService", "cinemaBookingService", "Booking", "Booking").perform();
      this.ownerServiceCache = new InitialProxyLoader<OwnerServiceProxy>("generated", "CinemaBookingService", "cinemaBookingService", "OwnerService", "OwnerService").perform();
      this.mainStartCinemaCache = new InitialProxyLoader<MainStartCinemaProxy>("generated", "CinemaBookingService", "cinemaBookingService", "MainStartCinema", "MainStartCinema").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("cinema_cinemahalls").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Cinema", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Cinemahall", "CinemaBookingService");
         try{this.addcinema_cinemahallsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("allFilmProjections").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Cinema", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "FilmProjection", "CinemaBookingService");
         try{this.addallFilmProjectionsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("rows").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Cinemahall", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "CinemaRow", "CinemaBookingService");
         try{this.addrowsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Row_to_Seat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "CinemaRow", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaBookingService");
         try{this.addRow_to_SeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("filmprojection_Cinemahall").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "FilmProjection", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Cinemahall", "CinemaBookingService");
         try{this.addfilmprojection_CinemahallElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("filmprojection_move").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "FilmProjection", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Movie", "CinemaBookingService");
         try{this.addfilmprojection_moveElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("reservation_booking").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Booking", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reservation", "CinemaBookingService");
         try{this.addreservation_bookingElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("reservation_seat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaBookingService");
         try{this.addreservation_seatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("reservation_filmprojection").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "FilmProjection", "CinemaBookingService");
         try{this.addreservation_filmprojectionElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("cinema").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "OwnerService", "CinemaBookingService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Cinema", "CinemaBookingService");
         try{this.addcinemaElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addcinema_cinemahallsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinema proxy1 = null; ICinemahall proxy2 = null; 
      if(className1.equals("Cinema"))  proxy1 = Cinema.getInstance();
      if(className2.equals("Cinemahall"))  proxy2 = this.cinemahallCache.get(id2);
      cinema_cinemahallsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addallFilmProjectionsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinema proxy1 = null; IFilmProjection proxy2 = null; 
      if(className1.equals("Cinema"))  proxy1 = Cinema.getInstance();
      if(className2.equals("FilmProjection"))  proxy2 = this.filmProjectionCache.get(id2);
      allFilmProjectionsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addrowsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinemahall proxy1 = null; ICinemaRow proxy2 = null; 
      if(className1.equals("Cinemahall"))  proxy1 = this.cinemahallCache.get(id1);
      if(className2.equals("FrontRow"))  proxy2 = this.frontRowCache.get(id2);
      if(className2.equals("MiddleRow"))  proxy2 = this.middleRowCache.get(id2);
      if(className2.equals("BackRow"))  proxy2 = this.backRowCache.get(id2);
      rowsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addRow_to_SeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinemaRow proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("FrontRow"))  proxy1 = this.frontRowCache.get(id1);
      if(className1.equals("MiddleRow"))  proxy1 = this.middleRowCache.get(id1);
      if(className1.equals("BackRow"))  proxy1 = this.backRowCache.get(id1);
      Row_to_SeatSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addfilmprojection_CinemahallElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IFilmProjection proxy1 = null; ICinemahall proxy2 = null; 
      if(className2.equals("Cinemahall"))  proxy2 = this.cinemahallCache.get(id2);
      if(className1.equals("FilmProjection"))  proxy1 = this.filmProjectionCache.get(id1);
      filmprojection_CinemahallSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addfilmprojection_moveElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IFilmProjection proxy1 = null; IMovie proxy2 = null; 
      if(className2.equals("Movie"))  proxy2 = this.movieCache.get(id2);
      if(className1.equals("FilmProjection"))  proxy1 = this.filmProjectionCache.get(id1);
      filmprojection_moveSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addreservation_bookingElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBooking proxy1 = null; IReservation proxy2 = null; 
      if(className2.equals("Reservation"))  proxy2 = this.reservationCache.get(id2);
      if(className1.equals("Booking"))  proxy1 = this.bookingCache.get(id1);
      reservation_bookingSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addreservation_seatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      reservation_seatSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addreservation_filmprojectionElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; IFilmProjection proxy2 = null; 
      if(className2.equals("FilmProjection"))  proxy2 = this.filmProjectionCache.get(id2);
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      reservation_filmprojectionSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addcinemaElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IOwnerService proxy1 = null; ICinema proxy2 = null; 
      if(className2.equals("Cinema"))  proxy2 = Cinema.getInstance();
      if(className1.equals("OwnerService"))  proxy1 = this.ownerServiceCache.get(id1);
      cinemaSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
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
   public Seat getSeat(Integer id){
      return this.seatCache.get(id).getTheObject();
   }
   public void addSeatProxy(SeatProxy p) throws PersistenceException{
      this.seatCache.put(p.getId(), p);
   }
   public Map<Integer,SeatProxy> getSeatCache(){
      return this.seatCache;
   }
   public FrontRow getFrontRow(Integer id){
      return this.frontRowCache.get(id).getTheObject();
   }
   public void addFrontRowProxy(FrontRowProxy p) throws PersistenceException{
      this.frontRowCache.put(p.getId(), p);
   }
   public Map<Integer,FrontRowProxy> getFrontRowCache(){
      return this.frontRowCache;
   }
   public MiddleRow getMiddleRow(Integer id){
      return this.middleRowCache.get(id).getTheObject();
   }
   public void addMiddleRowProxy(MiddleRowProxy p) throws PersistenceException{
      this.middleRowCache.put(p.getId(), p);
   }
   public Map<Integer,MiddleRowProxy> getMiddleRowCache(){
      return this.middleRowCache;
   }
   public BackRow getBackRow(Integer id){
      return this.backRowCache.get(id).getTheObject();
   }
   public void addBackRowProxy(BackRowProxy p) throws PersistenceException{
      this.backRowCache.put(p.getId(), p);
   }
   public Map<Integer,BackRowProxy> getBackRowCache(){
      return this.backRowCache;
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
   public FilmProjection getFilmProjection(Integer id){
      return this.filmProjectionCache.get(id).getTheObject();
   }
   public void addFilmProjectionProxy(FilmProjectionProxy p) throws PersistenceException{
      this.filmProjectionCache.put(p.getId(), p);
   }
   public Map<Integer,FilmProjectionProxy> getFilmProjectionCache(){
      return this.filmProjectionCache;
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
   public Visitor getVisitor(Integer id){
      return this.visitorCache.get(id).getTheObject();
   }
   public void addVisitorProxy(VisitorProxy p) throws PersistenceException{
      this.visitorCache.put(p.getId(), p);
   }
   public Map<Integer,VisitorProxy> getVisitorCache(){
      return this.visitorCache;
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
   public OwnerService getOwnerService(Integer id){
      return this.ownerServiceCache.get(id).getTheObject();
   }
   public void addOwnerServiceProxy(OwnerServiceProxy p) throws PersistenceException{
      this.ownerServiceCache.put(p.getId(), p);
   }
   public Map<Integer,OwnerServiceProxy> getOwnerServiceCache(){
      return this.ownerServiceCache;
   }
   public MainStartCinema getMainStartCinema(Integer id){
      return this.mainStartCinemaCache.get(id).getTheObject();
   }
   public void addMainStartCinemaProxy(MainStartCinemaProxy p) throws PersistenceException{
      this.mainStartCinemaCache.put(p.getId(), p);
   }
   public Map<Integer,MainStartCinemaProxy> getMainStartCinemaCache(){
      return this.mainStartCinemaCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      db.connection.DBConnectionManager.getTheInstance().close();
   }
   //80 ===== Editable : Your Operations =============
/**
 * logout the given user.
 */
   public Boolean logout(String username){
      // TODO: Implement Operation logout
      return null;
   }
/**
 * Reservation for a Seat in a given Movie.
 */
   public Reservation reserve(String name, Movie movie, Integer seats, String categorie)throws CinemarowIsFull{
      // TODO: Implement Operation reserve
      return null;
   }
/**
 * Book the Reservation from the current User
 */
   public Booking book(Integer reservation_id){
      // TODO: Implement Operation book
      return null;
   }
/**
 * the User can Login in the Cinema Boocking Server
 */
   public Boolean login(String username, String password)throws wrongCredentials{
      // TODO: Implement Operation login
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
