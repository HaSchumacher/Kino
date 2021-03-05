import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import commands.Command;

public class Pipe {
	private List<Command<?>> data;
	private Semaphore usedSpace;
	private Semaphore freeSpace;
	private Semaphore mutex;
	
	Pipe(Integer capacity) {
		this.data = new ArrayList<Command<?>>();
		this.usedSpace = new Semaphore(0);
		this.freeSpace = new Semaphore(capacity);
		this.mutex = new Semaphore(1);
	}
	
	public void put(Command<?> c) throws InterruptedException {
		this.freeSpace.acquire();
		try {
			this.mutex.acquire();
			this.data.add(c);
			this.mutex.release();
			this.usedSpace.release();
		} catch (InterruptedException ie) {
			this.freeSpace.release();
			throw ie;
		}
	}
	
	public Command<?> get() throws InterruptedException {
		Command<?> c = null;
		this.usedSpace.acquire();
		try {
			this.mutex.acquire();
			c = this.data.remove(0);
			this.mutex.release();
			this.freeSpace.release();
		} catch (InterruptedException ie) {
			this.usedSpace.release();
			throw ie;
		}
		return c;
	}
	
}
