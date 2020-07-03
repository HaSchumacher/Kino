package findLibrary;

import java.util.ArrayList;
import java.util.PriorityQueue;
import Events.Event;
import Events.Kuchen;

public class DESSheduler {
	public int CountEvents = 0;
	public PriorityQueue<Event> Queue;
	public ArrayList<Kuchen> fertigeKuchen = new ArrayList<Kuchen>();
	
	public DESSheduler() {
		this.Queue = new PriorityQueue<Event>();
	}
	public void getFinished() {
		if(!this.Queue.isEmpty()) {
				this.Queue.poll();
				getFinished();
			}
		else {}
		}
	
}
