package Events;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;

import shedulerAndMainClass.DESSheduler;

public class Abwiegen implements Event{

	private String name;
	private long timeStamp;
	private DESSheduler mySheduler;
	private int verteilung = new UniformIntegerDistribution(100, 200).sample();

	public Abwiegen(long l, DESSheduler mySheduler) {
		this.mySheduler = mySheduler;
		this.timeStamp = l;
		
		
	}

	@Override
	public void execute() {
		System.out.println("Currenttime: " + timeStamp );
		Event newEvent = new Rühren(this.timeStamp + verteilung , this.mySheduler);
		
		mySheduler.Queue.remove(this);
		mySheduler.Queue.add(newEvent);
		System.out.println(mySheduler.Queue);
		this.mySheduler.CountEvents ++;
		mySheduler.Queue.peek().execute();
		
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
