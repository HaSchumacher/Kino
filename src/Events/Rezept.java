package Events;


import org.apache.commons.math3.distribution.NormalDistribution;

import findLibrary.DESSheduler;

public class Rezept implements Event{
	
	private String name = "Rezept";
	private long timeStamp;
	private DESSheduler mySheduler;
	private int normalverteilung = (int)Math.round(new NormalDistribution(500, 200).sample());
	
	
	public Rezept( long timeStamp, DESSheduler sheduler) {
		this.mySheduler = sheduler;
		this.timeStamp = timeStamp;
	}
	
	
	@Override
	public void execute() {
		System.out.println("Currenttime: " + timeStamp );
		Event newEvent = new Einkauf(this.timeStamp + normalverteilung , this.mySheduler);
		mySheduler.Queue.remove(this);
		mySheduler.Queue.add(newEvent);
		System.out.println(mySheduler.Queue);
		this.mySheduler.CountEvents ++;
		mySheduler.Queue.peek().execute();
	}

	@Override
	public int compareTo(Event o) {
		if (this.timeStamp == o.getTimeStamp()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public long getTimeStamp() {
		return this.timeStamp;
	}
	public String toString() {
		return this.name + timeStamp ;
	}
	

}
