package hwdp;

public interface Subject {

	
	public void attach(Observer observer);
    public void detach(Observer observer);

	void notifyObservers();
	String getStateName();
}
