package Events;

import findLibrary.DESSheduler;

public class Abbruch implements Event{
	private int istimestampfull = 0;
	DESSheduler mysheduler;
	private String name = "Abbruch";
	
	public Abbruch(long timeStamp, DESSheduler sheduler) {
		this.istimestampfull = (int)Math.round(timeStamp);
		this.mysheduler = sheduler;
	}
	
	@Override
	public void execute() {
		if(!(this.istimestampfull < 1000000)) {
			this.mysheduler.Queue.clear();
		}
		System.out.println("Das Programm wurde bei " + istimestampfull + " beendet" );
	}

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTimeStamp() {
		return this.istimestampfull;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
