package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.cinemaService.Admin;
import generated.cinemaService.Back;
import generated.cinemaService.Booking;
import generated.cinemaService.BookingError;
import generated.cinemaService.CinemaHallCreation;
import generated.cinemaService.CinemaRow;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Cinemahall;
import generated.cinemaService.DeleteError;
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
	private static String id;
	private static Filmprojection fp1;
	private static Filmprojection fp2;
	private static Movie movie1;
	private static Movie movie2;
	private static User u1;
	private static User u2;

	@BeforeAll
	static void setUp() throws Exception {
		id = UUID.randomUUID().toString();
		service = CinemaService.getInstance();
		u1 = service.register("CinemaServiceTestUser1", "test@mail.de", "CinemaServiceTestUser1" + id, "password");
		u2 = service.register("CinemaServiceTestUser2", "test@mail.de", "CinemaServiceTestUser2" + id, "password");
		movie1 = service.addMovie("CalculateProfitTestMovie1" + id);
		movie2 = service.addMovie("CalculateProfitTestMovie2" + id);
		fp1 = service.addFilmprojection(service.addCinemahall("CinemaServiceTestHall1" + id, 9, 6), movie1);
		fp2 = service.addFilmprojection(service.addCinemahall("CinemaServiceTestHall2" + id, 9, 6), movie2);
	}

	@Test
	public void testChangePriceCategory() throws PersistenceException {
		Integer front = 3;
		Integer middle = 6;
		Integer back = 9;

		service.changePriceCategory(Front.getInstance(), 3);
		service.changePriceCategory(Middle.getInstance(), 6);
		service.changePriceCategory(Back.getInstance(), 9);
		Integer fr = Front.getInstance().getPrice().get();
		Integer md = Middle.getInstance().getPrice().get();
		Integer bb = Back.getInstance().getPrice().get();

		assertEquals(front, fr);
		assertEquals(middle, md);
		assertEquals(back, bb);
	}

	@Test
	void testReserve1() throws PersistenceException, ReservationError {
		Assertions.assertThrows(ReservationError.class, () -> {
			service.reserve(null, fp1, Front.getInstance());
		});
	}

	@Test
	void testReserve2() throws PersistenceException, ReservationError {
		final PriceCategory priceCategory = fp1.getMyHall().getMyRows().get(fp1.getMyHall().getMyRows().size() - 1)
				.getPriceCategory();
		int priceCategoryRows = fp1.getMyHall().getMyRows().size() - 1 / 3;
		for (int i = 1; i < priceCategoryRows; i++) {
			CinemaRow currRow = fp1.getMyHall().getMyRows().get(fp1.getMyHall().getMyRows().size() - i);
			currRow.setBookedUp(true);
		}
		Assertions.assertThrows(ReservationError.class, () -> {
			service.reserve(u1, fp1, priceCategory);
		});
	}

	@Test
	void testReserve3() throws PersistenceException, ReservationError {
		Reservation reserve = service.reserve(u2, fp2, Back.getInstance());
		assertEquals(Back.getInstance(), reserve.getMySeat().getMyRow().getPriceCategory());
	}

	@Test
	void testBook1() throws ReservationError, PersistenceException, BookingError {
		Reservation res = service.reserve(u1, fp1, Middle.getInstance());
		Booking expected = service.book(res);
		assertEquals(expected, res.getMyBooking().iterator().next());
		assertTrue(res.getBooked());
	}

	@Test
	void testBook2() throws ReservationError, PersistenceException, BookingError {
		Reservation res = service.reserve(u1, fp1, Front.getInstance());
		assertTrue(res.getMyBooking().isEmpty());
		assertFalse(res.getBooked());
	}

	@Test
	void testBook3() throws ReservationError, PersistenceException, BookingError {
		Reservation res = service.reserve(u1, fp2, Back.getInstance());
		service.book(res);
		Assertions.assertThrows(BookingError.class, () -> {
			service.book(res);
		});
	}

	@Test
	void testAddRoleToUser() throws PersistenceException {
		service.addRoleToUser(u1, Admin.getInstance());
		assertTrue(u1.getMyRoles().contains(Admin.getInstance()));
	}

	@Test
	void testCancelReservation() throws PersistenceException, ReservationError, DeleteError {
		Reservation res = service.reserve(u1, fp2, Back.getInstance());
		assertFalse(res.getDeleted());
		service.cancelReservation(res);
		assertTrue(res.getDeleted());
	}

	@Test
	void testAddCinemahall1()
			throws PersistenceException, ReservationError, DeleteError, CinemaHallCreation, ConstraintViolation {
		Assertions.assertThrows(CinemaHallCreation.class, () -> {
			service.addCinemahall("Test", 4, 2);
		});
		Assertions.assertThrows(CinemaHallCreation.class, () -> {
			service.addCinemahall("Test", -6, 2);
		});
	}

	@Test
	void testAddCinemahall2()
			throws PersistenceException, ReservationError, DeleteError, CinemaHallCreation, ConstraintViolation {
		Cinemahall hall = service.addCinemahall("Test", 6, 4);
		List<CinemaRow> rows = hall.getMyRows();
		assertEquals(6, rows.size());
		assertTrue(hall.getOpen());
		for (int i = 0; i < rows.size(); i++) {
			assertFalse(rows.get(i).getBookedUp());
			assertEquals(4, rows.get(i).getMySeats().size());
			if (i < 2) {
				assertEquals(Front.getInstance(), rows.get(i).getPriceCategory());
			}
			if (1 < i && i < 4) {
				assertEquals(Middle.getInstance(), rows.get(i).getPriceCategory());
			}
			if (i > 3) {
				assertEquals(Back.getInstance(), rows.get(i).getPriceCategory());
			}
		}
	}

}
