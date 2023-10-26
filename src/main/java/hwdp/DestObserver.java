package hwdp;

public class DestObserver implements Observer {

	private String name;
	
	public DestObserver(String n) {
		this.name = n;
	}

	@Override
	public void update(Subject o) {
		
		var log = LibraryLogger.getInstance();
		log.writeLine(name + " OBSERVED " + o + " REACHING STATE: " + o.getStateName());
	}

	@Override
	public String toString() {
		return name;
	}
}
