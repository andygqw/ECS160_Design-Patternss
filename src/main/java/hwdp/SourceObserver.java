package hwdp;
import java.util.HashMap;


public class SourceObserver implements Observer {

	private String name;
	private HashMap<Subject, String> subjectToPastStateName;
	
	public SourceObserver(String n) {
		subjectToPastStateName = new HashMap<>();
		this.name = n;
	}

	@Override
	public void update(Subject o) {
		
		String prevState = subjectToPastStateName.getOrDefault(o, "UNOBSERVED");
		var log = LibraryLogger.getInstance();
		log.writeLine(name + " OBSERVED " + o + " LEAVING STATE: " + prevState);
        subjectToPastStateName.put(o, o.getStateName());
	}

	@Override
	public String toString() {
		return name;
	}
}
