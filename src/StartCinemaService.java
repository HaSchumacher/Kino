import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.cinemaService.CinemaHallCreation;
import generated.cinemaService.CinemaService;

public class StartCinemaService {

	public static void main(String[] args) throws CinemaHallCreation, PersistenceException, ConstraintViolation {
		CinemaService service = CinemaService.getInstance();
		service.addCinemahall("hunululu", 6, 2);
	}

}
