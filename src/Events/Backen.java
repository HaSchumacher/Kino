package Events;

import shedulerAndMainClass.DESSheduler;

public class Backen implements Event {
	private String name = "Backen";
	private long timeStamp;
	private DESSheduler mySheduler;
	private int verteilung = 1000;
	
	public Backen (long timeStamp, DESSheduler sheduler) {
		this.timeStamp = timeStamp;
		this.mySheduler = sheduler;
	}
	
	public void execute() {
		System.out.println("Currenttime: " + timeStamp );
		Event newEvent = new Kuchen(this.timeStamp + verteilung , this.mySheduler);
		mySheduler.Queue.remove(this);
		mySheduler.Queue.add(newEvent);
		System.out.println(mySheduler.Queue);
		this.mySheduler.CountEvents ++;
		mySheduler.Queue.peek().execute();
		
	}

	public String getName() {return this.name;}
	
	public long getTimeStamp() {return timeStamp;}

	@Override
	public int compareTo(Event o) {
		if (this.timeStamp == o.getTimeStamp()) {
			return 1;}
		return 0;}

	@Override
	public String toString() {return this.name + timeStamp ;}
}
