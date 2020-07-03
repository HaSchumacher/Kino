package Events;

public interface Event extends Comparable<Event> {
	public void execute();
	
	public int compareTo(Event o);
	public String toString();
	public String getName();
	public long getTimeStamp();
		
}
