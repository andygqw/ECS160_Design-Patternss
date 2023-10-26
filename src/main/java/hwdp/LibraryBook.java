package hwdp;

import java.util.ArrayList;
import java.util.List;
public class LibraryBook implements Subject {

    List<Observer> observers = new ArrayList<>();

    private String name;
    private LBState state;
    
    public LibraryBook(String name) {
        
        observers = new ArrayList<>();
        this.name = name;
        this.state = OnShelf.getInstance();
    }
    
    public LBState getState() {
        
        return state;
    }

    // Switch context here
    protected void setState(LBState state) {

        this.state = state;
    }

    // Log the BadOperationException Error Message
    private void BadOpExLogHelper(String errorMsg){

        LibraryLogger log = LibraryLogger.getInstance();
        log.writeLine("BadOperationException - " + errorMsg);
    }
    
    public void returnIt() {
        try{

            state.returnIt(this);
            notifyObservers();

        }catch(BadOperationException e){

            BadOpExLogHelper(e.getMessage());
        }
    }
    
    public void shelf() {
        try{

            state.shelf(this);
            notifyObservers();

        }catch(BadOperationException e){

            BadOpExLogHelper(e.getMessage());
        }
    }
    
    public void extend() {
        try{

            state.extend(this);
            notifyObservers();

        }catch(BadOperationException e){
            
            BadOpExLogHelper(e.getMessage());
        }
    }
    
    public void issue() {
        try{

            state.issue(this);
            notifyObservers();

        }catch(BadOperationException e){
            
            BadOpExLogHelper(e.getMessage());
        }
    }

    @Override
    public void attach(Observer observer) {

        if (!observers.contains(observer)) {
            observers.add(observer);
			var log = LibraryLogger.getInstance();
			log.writeLine(observer + " is now watching " + this);
        } else {
			var log = LibraryLogger.getInstance();
			log.writeLine(observer + " is already attached to " + this);
        }
    }

    @Override
    public void detach(Observer observer) {

        if (observers.remove(observer)) {
			var log = LibraryLogger.getInstance();
			log.writeLine(observer + " is no longer watching " + this);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String getStateName() {
        return state.toString();
    }
    
    public String toString() {
        
        return name;
    }
}