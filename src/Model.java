import generated.cinemaService.CinemaService;

public class Model {

 public Model() {}
 
 public CinemaService getService() {
	 return CinemaService.getInstance();
 }
}
