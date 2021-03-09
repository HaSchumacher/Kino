package client;

public class Executer implements Runnable {
	private Thread t;
	private String threadName;
	private Pipe myPipe;
	
	public Executer(Pipe p, String name) {
		this.myPipe = p;
		this.threadName = name;
		System.out.println("Creating " + this.threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + this.threadName);
		while(!t.isInterrupted()) {
			try {
				this.myPipe.get().execute();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
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
