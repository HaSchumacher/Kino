package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mysql.cj.exceptions.AssertionFailedException;

import db.executer.PersistenceException;
import generated.cinemaService.Back;
import generated.cinemaService.BookingError;
import generated.cinemaService.CinemaRow;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.Front;
import generated.cinemaService.Middle;
import generated.cinemaService.Movie;
import generated.cinemaService.PriceCategory;
import generated.cinemaService.Reservation;
import generated.cinemaService.ReservationError;
import generated.cinemaService.User;

class CinemaServiceTest {

	
	private static CinemaService service;
	private static User TestUser2;
	private static User TestUser4;
	private static String uniqueID;
	private static Filmprojection fp;
	private static Filmprojection fp2;
	private static Movie movie;
	private static Movie movie2;
	private static User TestUser1;
	private static User TestUser3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		uniqueID = UUID.randomUUID().toString();
		service = CinemaService.getInstance();
		TestUser1 = service.register("TestUser1", "test@testing.de", "Test1", "12345");
		TestUser2 = service.register("TestUser2", "test@testing.de", "Test2", "12345");
		TestUser3 = service.register("TestUser3", "test@testing.de", "Test3", "12345");
		TestUser4 = service.register("TestUser4", "test@testing.de", "Test4", "12345");
		movie = service.addMovie("ILoveIT");
		movie2 = service.addMovie("Inception");
		fp = service.addFilmprojection(service.addCinemahall("CalculateTotalProfitTestHall" + uniqueID, 9, 6), movie);
		fp2 = service.addFilmprojection(service.addCinemahall("CalculateTotalProfitTestHall" + uniqueID, 9, 6), movie2);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}
	@Test
	public void testChangePriceCategory() throws PersistenceException {
		Integer front = 3;
		Integer middle = 6;
		Integer back = 9;
		//"'''''''''''''''''''''''''''''''''''''''''''''''''''''''"
		service.changePriceCategory(Front.getInstance(), 3);
		service.changePriceCategory(Middle.getInstance(), 6);
		service.changePriceCategory(Back.getInstance(), 9);
		Integer fr = Front.getInstance().getPrice().get();
		Integer md = Middle.getInstance().getPrice().get();
		Integer bb = Back.getInstance().getPrice().get();
		//"'''''''''''''''''''''''''''''''''''''''''''''''''''''''"
		assertEquals(front, fr);
		assertEquals(middle, md);
		assertEquals(back, bb);
	}

	@Test
	void testReserve1() throws PersistenceException, ReservationError {
		Assertions.assertThrows(ReservationError.class, () -> {
			service.reserve(null, fp, Front.getInstance());
		});		
	}
	
	@Test
	void testReserve2() throws PersistenceException, ReservationError {
		final PriceCategory priceCategory = fp.getMyHall().getMyRows().get(fp.getMyHall().getMyRows().size()-1).getPriceCategory();
		int priceCategoryRows = fp.getMyHall().getMyRows().size()-1/3;
		for (int i = 1; i < priceCategoryRows; i++) {
			 CinemaRow currRow = fp.getMyHall().getMyRows().get(fp.getMyHall().getMyRows().size() - i);
			 currRow.setBookedUp(true);
		}
		 Assertions.assertThrows(ReservationError.class, () -> {
				service.reserve(TestUser1, fp, priceCategory);
			});
		
		
	}

	@Test
	void testBook() {
		fail("Not yet implemented");
	}

	@Test
	void testCalculateTotalProfit() throws PersistenceException, ReservationError, BookingError {
		Integer result = 27;
		service.changePriceCategory(Front.getInstance(), 3);
		service.changePriceCategory(Middle.getInstance(), 6);
		service.changePriceCategory(Back.getInstance(), 9);

		// Do Some
		// reservations"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
		Reservation t1book = service.reserve(TestUser1, fp, Front.getInstance());// 3*6
		service.reserve(TestUser2, fp, Front.getInstance());
		Reservation t3book1 = service.reserve(TestUser3, fp, Front.getInstance());
		service.reserve(TestUser4, fp, Front.getInstance());
		Reservation t1book2 = service.reserve(TestUser1, fp, Front.getInstance());
		service.reserve(TestUser2, fp, Front.getInstance());
		service.reserve(TestUser4, fp, Middle.getInstance());// 2*6
		Reservation t1book3 = service.reserve(TestUser1, fp2, Back.getInstance());// 2*9
		service.reserve(TestUser2, fp2, Middle.getInstance());
		Reservation t3book2 = service.reserve(TestUser3, fp2, Back.getInstance());// =48 no bookings
		// Do some
		// Bookings""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
		service.book(t1book);// 2*3
		service.book(t1book2);
		service.book(t1book3);// 9
		service.book(t3book1);// 3
		service.book(t3book2);// 9
		assertEquals(result, service.calculateTotalProfit());// 27
		// TODO TRUNCATE USED Items from DATABASE
	}

	@Test
	void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	void testRegister() {
		fail("Not yet implemented");
	}


	@Test
	void testGeneratePublicKey() {
		fail("Not yet implemented");
	}

}
