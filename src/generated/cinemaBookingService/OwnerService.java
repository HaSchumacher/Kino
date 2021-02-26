/**--- Generated at Thu Feb 25 17:10:43 CET 2021 
 * --- Change only in Editable Sections!  
 * --- Do not touch section numbering!   
 */
package generated.cinemaBookingService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.connection.TypeKeyManager;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaBookingService.proxies.OwnerServiceProxy;
import observation.Observable;
import generated.cinemaBookingService.proxies.IOwnerService;
import generated.cinemaBookingService.relationControl.*;
import generated.cinemaBookingService.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class OwnerService extends Observable implements java.io.Serializable, IOwnerService
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private OwnerService(Integer id, Cinema cinema, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      cinemaSupervisor.getInstance().set(this, cinema);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static OwnerService createAlreadyPersistent(OwnerServiceProxy proxy, Cinema cinema)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new OwnerService(proxy.getId(), cinema, true);
   }
   public static OwnerService createFresh(Cinema cinema)throws PersistenceException{
      db.executer.DBDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("OwnerService", "id, typeKey", 
         id.toString() + ", " + TypeKeyManager.getTheInstance().getTypeKey("CinemaBookingService", "OwnerService").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      OwnerService me = new OwnerService(id, cinema, false);
      CinemaBookingService.getInstance().addOwnerServiceProxy(new OwnerServiceProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public OwnerService getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IOwnerService)) return false;
      return ((IOwnerService)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Cinema getCinema() throws PersistenceException{
      return cinemaSupervisor.getInstance().getCinema(this).getTheObject();
   }
   public void setCinema(Cinema newCinema)throws PersistenceException{
      cinemaSupervisor.getInstance().change(this, this.getCinema(), newCinema);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Calculate the Outcome of all Filmprojections
 */
   public Integer calculateFullOutcome()throws MovieNotFoundInCinema{
      // TODO: Implement Operation calculateFullOutcome
      return null;
   }
/**
 * Add Film Projection to Cinema
 */
   public String addFilmprojection(Movie movie, Cinemahall cinemahall)throws MovieAlreadyinCinemahall{
	   try {
		FilmProjection filmprojection = FilmProjection.createFresh(cinemahall, movie);
		   this.getCinema().addToFilmProjections(filmprojection);
		  
	} catch (PersistenceException e) {
		e.printStackTrace();
	}
	return "Creation done";
   }
/**
 * Build the Cinema
 */
   public void buildCinema(){
	   //2 halls 
	   //1. = 7 Reihen (2p,2m,3b), Pl�tze(6,8,4)
	   try {
		Cinema cinema = this.getCinema();
		   Cinemahall hall1 = Cinemahall.createFresh(false);
		   
		   FrontRow row1 = FrontRow.createFresh(9, false);
		   Seat s1 = Seat.createFresh(); row1.addSeat(s1);
		   Seat s2 = Seat.createFresh(); row1.addSeat(s2);
		   Seat s3 = Seat.createFresh(); row1.addSeat(s3);
		   Seat s4 = Seat.createFresh(); row1.addSeat(s4);
		   Seat s5 = Seat.createFresh(); row1.addSeat(s5);
		   Seat s6 = Seat.createFresh(); row1.addSeat(s6);	   
		   
		   FrontRow row2 = FrontRow.createFresh(9, false);
		   Seat s7 = Seat.createFresh();row2.addSeat(s7);
		   Seat s8 = Seat.createFresh();row2.addSeat(s8);
		   Seat s9 = Seat.createFresh();row2.addSeat(s9);
		   Seat s10 = Seat.createFresh();row2.addSeat(s10);
		   Seat s11 = Seat.createFresh();row2.addSeat(s11);
		   Seat s12 = Seat.createFresh();row2.addSeat(s12);
		  	   
		   MiddleRow row3 = MiddleRow.createFresh(8, false);
		   Seat s13 = Seat.createFresh();row3.addSeat(s13);
		   Seat s14 = Seat.createFresh();row3.addSeat(s14);
		   Seat s15 = Seat.createFresh();row3.addSeat(s15);
		   Seat s16 = Seat.createFresh();row3.addSeat(s16);
		   Seat s17 = Seat.createFresh();row3.addSeat(s17);
		   Seat s18 = Seat.createFresh();row3.addSeat(s18);
		   Seat s19 = Seat.createFresh();row3.addSeat(s19);
		   Seat s20 = Seat.createFresh();row3.addSeat(s20);
		   
		   MiddleRow row4 = MiddleRow.createFresh(8, false);
		   Seat s21 = Seat.createFresh();row4.addSeat(s21);
		   Seat s22 = Seat.createFresh();row4.addSeat(s22);
		   Seat s23 = Seat.createFresh();row4.addSeat(s23);
		   Seat s24 = Seat.createFresh();row4.addSeat(s24);
		   Seat s25 = Seat.createFresh();row4.addSeat(s25);
		   Seat s26 = Seat.createFresh();row4.addSeat(s26);
		   Seat s27 = Seat.createFresh();row4.addSeat(s27);
		   Seat s28 = Seat.createFresh();row4.addSeat(s28);
		   
		   BackRow row5 = BackRow.createFresh(5, false);
		   Seat s29 = Seat.createFresh();row5.addSeat(s29);
		   Seat s30 = Seat.createFresh();row5.addSeat(s30);
		   Seat s31 = Seat.createFresh();row5.addSeat(s31);
		   Seat s32 = Seat.createFresh();row5.addSeat(s32);
		   
		   BackRow row6 = BackRow.createFresh(5, false);
		   Seat s33 = Seat.createFresh();row6.addSeat(s33);
		   Seat s34 = Seat.createFresh();row6.addSeat(s34);
		   Seat s35 = Seat.createFresh();row6.addSeat(s35);
		   Seat s36 = Seat.createFresh();row6.addSeat(s36);
		   
		   BackRow row7 = BackRow.createFresh(5, false);
		   Seat s37 = Seat.createFresh();row7.addSeat(s37);
		   Seat s38 = Seat.createFresh();row7.addSeat(s38);
		   Seat s39 = Seat.createFresh();row7.addSeat(s39);
		   Seat s40 = Seat.createFresh();row7.addSeat(s40);
		   
		   hall1.addToMyrow(row1);
		   hall1.addToMyrow(row2);
		   hall1.addToMyrow(row3);
		   hall1.addToMyrow(row4);
		   hall1.addToMyrow(row5);
		   hall1.addToMyrow(row6);
		   hall1.addToMyrow(row7);
		   
		   hall1.setOpen(true);
		   
		   Cinemahall hall2 = Cinemahall.createFresh(false);
		 //2. = 5 Reihen (2p,1m,2b), Pl�tze(4,3,4)
		   FrontRow row8 = FrontRow.createFresh(9, false);
		   Seat s41 = Seat.createFresh();row8.addSeat(s41);
		   Seat s42 = Seat.createFresh();row8.addSeat(s42);
		   Seat s43 = Seat.createFresh();row8.addSeat(s43);
		   Seat s44 = Seat.createFresh();row8.addSeat(s44);
		   
		   FrontRow row9 = FrontRow.createFresh(9, false);
		   Seat s45 = Seat.createFresh();row9.addSeat(s45);
		   Seat s46 = Seat.createFresh();row9.addSeat(s46);
		   Seat s47 = Seat.createFresh();row9.addSeat(s47);
		   Seat s48 = Seat.createFresh();row9.addSeat(s48);
		   
		   MiddleRow row10 = MiddleRow.createFresh(8, false);
		   Seat s49 = Seat.createFresh();row10.addSeat(s49);
		   Seat s50 = Seat.createFresh();row10.addSeat(s50);
		   Seat s51 = Seat.createFresh();row10.addSeat(s51);
		   
		   BackRow row11 = BackRow.createFresh(5, false);
		   Seat s52 = Seat.createFresh();row11.addSeat(s52);
		   Seat s53 = Seat.createFresh();row11.addSeat(s53);
		   Seat s54 = Seat.createFresh();row11.addSeat(s54);
		   Seat s55 = Seat.createFresh();row11.addSeat(s55);
		   
		   BackRow row12 = BackRow.createFresh(5, false);
		   Seat s56 = Seat.createFresh();row12.addSeat(s56);
		   Seat s57 = Seat.createFresh();row12.addSeat(s57);
		   Seat s58 = Seat.createFresh();row12.addSeat(s58);
		   Seat s59 = Seat.createFresh();row12.addSeat(s59);
		   
		   hall2.addToMyrow(row8);
		   hall2.addToMyrow(row9);
		   hall2.addToMyrow(row10);
		   hall2.addToMyrow(row11);
		   hall2.addToMyrow(row12);
		   
		   hall2.setOpen(true);
		   
		   cinema.addToCinemahalls(hall1);
		   cinema.addToCinemahalls(hall2);
		   
	} catch (PersistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
   }
/**
 * Calculate the Outcome for one Movie
 */
   public Integer calculateOutcome(FilmProjection ofFilm)throws MovieNotFoundInCinema{
	   try {
		int indexoffilm = this.getCinema().getFilmProjections().indexOf(ofFilm);
		this.getCinema().getFilmProjections().get(indexoffilm);
	} catch (PersistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return null;
   }
/**
 * Delete Film Projection
 */
   public Boolean deleteGivenFilmFromCinemahall(Movie movie)throws MovieCouldNotBeDeleated{
      try {
    	  CinemaBookingService.getInstance().getFilmProjection(movie.getId());
		int indexoffilm = this.getCinema().getFilmProjections().indexOf(movie);
		  this.getCinema().getFilmProjections().remove(indexoffilm);
	} catch (PersistenceException e) {
		e.printStackTrace();
		return false;
	}
      return true;
   }
//90 ===== GENERATED: End of Your Operations ======
}
