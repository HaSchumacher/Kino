package findLibrary;
import java.util.ArrayList;
import Events.Event;
import Events.Kuchen;
import Events.Rezept;


public class Libraryone {

	public static void main(String[] args) {
		
		
		DESSheduler sheduler = new DESSheduler();
		
		for ( int i = 1; i < 1001; i++) {
			Event rezept = new Rezept(i, sheduler);
			sheduler.Queue.add(rezept);
		}
		while(!sheduler.Queue.isEmpty()) {
			sheduler.Queue.peek().execute();
		}
		ArrayList<Kuchen> fertigeKuchen = sheduler.fertigeKuchen;
		int times = 0;
		int wvKuchen = fertigeKuchen.size();
		for (Kuchen cake : fertigeKuchen) {
			System.out.println(cake.toString());
			times = (int) (times + cake.getTimeStamp());
		}
		System.out.println(wvKuchen);
		System.out.println("komplette Zeit = " + times);
		double mean = times/wvKuchen;
		System.out.println(" Durchscnittliche Zeit = " + mean);
			System.out.println(" Standardabweichung = " + getVariance(mean, fertigeKuchen));
					
		
			}
	static double getVariance(double mean, ArrayList<Kuchen> fertigeKuchen) {
        double temp = 0;
        for(Kuchen a :fertigeKuchen)
            temp += (a.getTimeStamp()-mean)*(a.getTimeStamp()-mean);
        return temp/(fertigeKuchen.size()-1);
  }
}
