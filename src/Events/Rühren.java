package Events;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

import findLibrary.DESSheduler;

public class Rühren implements Event{
	private String name = "Rühren";
	private long timeStamp;
	private DESSheduler mySheduler;
	private int verteilung = (int)Math.round(new NormalDistribution(100,5).sample());

	public Rühren(long l, DESSheduler mySheduler) {
		this.mySheduler = mySheduler;
		this.timeStamp = l;
		
	}

	@Override
	public void execute() {
		System.out.println("Currenttime: " + timeStamp );
		Event newEvent = new Backen(this.timeStamp + verteilung , this.mySheduler);
		
		mySheduler.Queue.remove(this);
		mySheduler.Queue.add(newEvent);
		System.out.println(mySheduler.Queue);
		this.mySheduler.CountEvents ++;
		mySheduler.Queue.peek().execute();
		
	}

	public String getName() {
		return this.name;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}

	@Override
	public int compareTo(Event o) {
		if (this.timeStamp == o.getTimeStamp()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.name + timeStamp ;
	}
	
}
