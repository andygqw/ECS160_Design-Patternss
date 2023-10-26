package hwdp;

public class Borrowed implements LBState{

    private static Borrowed instance;

    private Borrowed() {}

    public static Borrowed getInstance() {

        if (instance == null) {
            instance = new Borrowed();
        }

        return instance;
    }

    @Override
    public void shelf(LibraryBook book) throws BadOperationException{

        throw new BadOperationException("Can't use shelf in Borrowed state");
    }

    @Override
    public void issue(LibraryBook book) throws BadOperationException{

        throw new BadOperationException("Can't use issue in Borrowed state");        
    }

    @Override
    public void extend(LibraryBook book){

        book.setState(Borrowed.getInstance());
        LibraryLogger log = LibraryLogger.getInstance();
        log.writeLine("Leaving State Borrowed for State Borrowed");
    }

    @Override
    public void returnIt(LibraryBook book) {

        book.setState(GotBack.getInstance());
        LibraryLogger log = LibraryLogger.getInstance();
        log.writeLine("Leaving State Borrowed for State GotBack");
    }

    @Override
    public String toString() {

        return "Borrowed";
    }
}