package hwdp;

public interface LBState{

    public void issue(LibraryBook book)throws BadOperationException;
    public void extend(LibraryBook book) throws BadOperationException;
    public void returnIt(LibraryBook book) throws BadOperationException;
    public void shelf(LibraryBook book) throws BadOperationException;
}