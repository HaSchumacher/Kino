package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.cinemaService.Back;
import generated.cinemaService.BookingError;
import generated.cinemaService.CinemaHallCreationError;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Filmprojection;
import generated.cinemaService.Front;
import generated.cinemaService.Middle;
import generated.cinemaService.RegisterError;
import generated.cinemaService.Reservation;
import generated.cinemaService.ReservationError;
import generated.cinemaService.User;

@TestInstance(Lifecycle.PER_CLASS)
public class FilmprojectionTest {
	private CinemaService service;
	private String id;
	private User u1;
	private User u2;
	private User u3;
	private Filmprojection fp;
	

    @BeforeAll
    public void setUp() throws PersistenceException, CinemaHallCreationError, ConstraintViolation, RegisterError {
    	this.service = CinemaService.getInstance();
    }
	
    @BeforeEach 
    public void init() throws PersistenceException, CinemaHallCreationError, ConstraintViolation, RegisterError {
		this.id = UUID.randomUUID().toString();
		this.fp = service.addFilmprojection(service.addCinemahall("CalculateProfitTestHall" + this.id, 9, 6),
				service.addMovie("CalculateProfitTestMovie" + this.id));
		this.u1 = service.register("CalculateProfitTestUser", "test@mail.de", "CalculateProfitTestUser" + this.id + "1",
				"password");
		this.u2 = service.register("CalculateProfitTestUser", "test@mail.de", "CalculateProfitTestUser" + this.id + "2",
				"password");
		this.u3 = service.register("CalculateProfitTestUser", "test@mail.de", "CalculateProfitTestUser" + this.id + "3",
				"password");
    }
    
	@Test
	public void calculateProfitTest1() throws PersistenceException, ReservationError, BookingError {
		service.changePriceCategory(Front.getInstance(), 3);
		service.changePriceCategory(Middle.getInstance(), 6);
		service.changePriceCategory(Back.getInstance(), 9);
		
		Integer expected = 0;
		
		assertEquals(expected, this.fp.calculateProfit());
	}

	@Test
	public void calculateProfitTest2() throws PersistenceException, ReservationError, BookingError {
		service.changePriceCategory(Front.getInstance(), 3);
		service.changePriceCategory(Middle.getInstance(), 6);
		service.changePriceCategory(Back.getInstance(), 9);
		
		Reservation res1 = service.reserve(this.u1, this.fp, Front.getInstance());
		Reservation res2 = service.reserve(this.u1, this.fp, Middle.getInstance());
		Reservation res3 = service.reserve(this.u1, this.fp, Back.getInstance());
		service.reserve(this.u2, this.fp, Front.getInstance());
		Reservation res5 = service.reserve(this.u2, this.fp, Middle.getInstance());
		Reservation res6 = service.reserve(this.u2, this.fp, Back.getInstance());
		Reservation res7 = service.reserve(this.u3, this.fp, Front.getInstance());
		Reservation res8 = service.reserve(this.u3, this.fp, Middle.getInstance());
		service.reserve(this.u3, this.fp, Back.getInstance());
		
		service.book(res1);
		service.book(res2);
		service.book(res3);
		service.book(res5);
		service.book(res6);
		service.book(res7);
		service.book(res8);
		
		Integer expected = 42;
		
		assertEquals(expected, this.fp.calculateProfit());
	}
	
	@Test
	public void calculateProfitTest3() throws PersistenceException, ReservationError, BookingError {
		service.changePriceCategory(Front.getInstance(), 2);
		service.changePriceCategory(Middle.getInstance(), 4);
		service.changePriceCategory(Back.getInstance(), 6);
		
		service.reserve(this.u1, this.fp, Front.getInstance());
		Reservation res2 = service.reserve(this.u1, this.fp, Middle.getInstance());
		service.reserve(this.u1, this.fp, Back.getInstance());
		service.reserve(this.u2, this.fp, Front.getInstance());
		Reservation res5 = service.reserve(this.u2, this.fp, Middle.getInstance());
		service.reserve(this.u2, this.fp, Back.getInstance());
		service.reserve(this.u3, this.fp, Front.getInstance());
		Reservation res8 = service.reserve(this.u3, this.fp, Middle.getInstance());
		service.reserve(this.u3, this.fp, Back.getInstance());
		
		service.book(res2);
		service.book(res5);
		service.book(res8);
		
		Integer expected = 12;
		
		assertEquals(expected, this.fp.calculateProfit());
	}
}

