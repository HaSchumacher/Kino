package client;
import generated.cinemaService.CinemaService;

public class Client implements Runnable {
	private Pipe myPipe;
	private Thread t;
	private String threadName;
	
	Client(Pipe p, String name) {
		this.myPipe = p;
		this.threadName = name;
		System.out.println("Creating " + this.threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + this.threadName);
		try {
			View frame = new View();
			frame.setVisible(true);
			Controller c = new Controller(CinemaService.getInstance(), frame, this.myPipe);
			c.registerForEvents();
			CinemaService.getInstance().addObserver(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		System.out.println("Starting " + this.threadName);
		if(this.t == null) {
			this.t = new Thread(this, this.threadName);
			t.start();
		}
	}

}
