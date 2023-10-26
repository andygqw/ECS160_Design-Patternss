package hwdp;

public class GotBack implements LBState{

    private static GotBack instance;

    private GotBack() {}

    public static GotBack getInstance() {

        if (instance == null) {
            instance = new GotBack();
        }

        return instance;
    }

    @Override
    public void shelf(LibraryBook book) {

        book.setState(OnShelf.getInstance());
        LibraryLogger log = LibraryLogger.getInstance();
        log.writeLine("Leaving State GotBack for State OnShelf");
    }

    @Override
    public void issue(LibraryBook book) throws BadOperationException{

        throw new BadOperationException("Can't use issue in GotBack state");        
    }

    @Override
    public void extend(LibraryBook book) throws BadOperationException{

       throw new BadOperationException("Can't use extend in GotBack state");        
    }

    @Override
    public void returnIt(LibraryBook book) throws BadOperationException{

        throw new BadOperationException("Can't use returnIt in GotBack state");        
    }

    @Override
    public String toString() {

        return "GotBack";
    }
}