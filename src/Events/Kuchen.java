package Events;

import findLibrary.DESSheduler;

public class Kuchen implements Event  {

	private String name = "Kuchen";
	private long timeStamp;
	private DESSheduler mySheduler;
	
	
	public Kuchen (long timeStamp, DESSheduler sheduler) {
		this.timeStamp = timeStamp;
		this.mySheduler = sheduler;
	}
	
	public void execute() {
		this.mySheduler.Queue.remove(this);
		this.mySheduler.fertigeKuchen.add(this);
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
		return this.name +" "+ timeStamp ;
	}
	
	
	

	
}
