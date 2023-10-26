package hwdp;

public class BadOperationException extends Exception {
    
    public BadOperationException(String message) {
        super(message);
    } 
    
    public BadOperationException() {
        super();
    } 
}
