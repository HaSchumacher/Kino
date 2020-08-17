package idManagement;

public class IDManager {
	private Integer counter;
	private static IDManager theInstance = new IDManager();
	private IDManager() {this.counter = 0;}
	public static IDManager getTheInstance() {return theInstance;}
	
	public Integer getNextId() {
		return ++this.counter;
	}
	
	public void setId(Integer counter) {
		this.counter = counter;
	}
}
