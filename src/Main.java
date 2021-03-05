
public class Main {

	public static void main(String[] args) {
		Pipe p = new Pipe(10);
		
		Executer e = new Executer(p, "Executer");
		e.start();
		
		Client client1 = new Client(p, "Client1");
		client1.start();
	}

}
