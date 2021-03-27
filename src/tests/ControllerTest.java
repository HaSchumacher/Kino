package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import client.Pipe;
import client.View;
import db.executer.PersistenceException;
import generated.cinemaService.CinemaService;
import generated.cinemaService.LoginError;
import generated.cinemaService.RegisterError;
import generated.cinemaService.User;

class ControllerTest {
	private static CinemaService service;
	private static ControllerTestPublics controller;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service = CinemaService.getInstance();
		controller = new ControllerTestPublics(service, new View(), new Pipe(10));
	}


	@Test
	void testLogin() throws PersistenceException, RegisterError, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, UnsupportedEncodingException, LoginError, InterruptedException {
		User TestUser1 = service.register("TestUser1", "test@testing.de", "Test1", "12345");
		controller.view.getTextField_loginUsername().setText("Test1");
		controller.view.getTextField_loginPassword().setText("12345");
		controller.login();
		if(controller.getLoggedUser() != null) {
			assertEquals(TestUser1, controller.getLoggedUser());
		}
		
		
	}
	

}
