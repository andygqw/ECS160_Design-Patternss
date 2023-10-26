package hwdp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Student_andygqw_Test {

    @Test
    void myStudentTest(){

        LibraryBook book = new LibraryBook("A Random book");
        LibraryBook book2 = new LibraryBook("B Random book");
        LibraryBook book3 = new LibraryBook("C Random book");

        SourceObserver src = new SourceObserver("Src listener");
        DestObserver dest = new DestObserver("Dest Listener");

        LibraryLogger.getInstance().clearWriteLog();;

        book.attach(dest);
        book.attach(src);
        
        book.issue();
        book.shelf();
        book.returnIt();
        book.detach(dest);
        book.detach(dest);
        book.attach(dest);

        book2.attach(src);
        book2.attach(dest);
        book2.issue();
        book.shelf();

        book3.attach(src);
        book3.attach(dest);
        book.issue();
        book2.extend();
        book3.issue();

        book.detach(src);
        book.detach(dest);
        book2.detach(dest);
        book2.detach(src);
        book3.detach(src);  
        book3.detach(dest);
        
        assertArrayEquals(new String[]{"Dest Listener is now watching A Random book",
        "Src listener is now watching A Random book",
        "Leaving State OnShelf for State Borrowed",
        "Dest Listener OBSERVED A Random book REACHING STATE: Borrowed",
        "Src listener OBSERVED A Random book LEAVING STATE: UNOBSERVED",
        "BadOperationException - Can't use shelf in Borrowed state",
        "Leaving State Borrowed for State GotBack",
        "Dest Listener OBSERVED A Random book REACHING STATE: GotBack",
        "Src listener OBSERVED A Random book LEAVING STATE: Borrowed",
        "Dest Listener is no longer watching A Random book",
        "Dest Listener is now watching A Random book",
        "Src listener is now watching B Random book",
        "Dest Listener is now watching B Random book",
        "Leaving State OnShelf for State Borrowed",
        "Src listener OBSERVED B Random book LEAVING STATE: UNOBSERVED",
        "Dest Listener OBSERVED B Random book REACHING STATE: Borrowed",
        "Leaving State GotBack for State OnShelf",
        "Src listener OBSERVED A Random book LEAVING STATE: GotBack",
        "Dest Listener OBSERVED A Random book REACHING STATE: OnShelf",
        "Src listener is now watching C Random book",
        "Dest Listener is now watching C Random book",
        "Leaving State OnShelf for State Borrowed",
        "Src listener OBSERVED A Random book LEAVING STATE: OnShelf",
        "Dest Listener OBSERVED A Random book REACHING STATE: Borrowed",
        "Leaving State Borrowed for State Borrowed",
        "Src listener OBSERVED B Random book LEAVING STATE: Borrowed",
        "Dest Listener OBSERVED B Random book REACHING STATE: Borrowed",
        "Leaving State OnShelf for State Borrowed",
        "Src listener OBSERVED C Random book LEAVING STATE: UNOBSERVED",
        "Dest Listener OBSERVED C Random book REACHING STATE: Borrowed",
        "Src listener is no longer watching A Random book",
        "Dest Listener is no longer watching A Random book",
        "Dest Listener is no longer watching B Random book",
        "Src listener is no longer watching B Random book",
        "Src listener is no longer watching C Random book",
        "Dest Listener is no longer watching C Random book"
        }, LibraryLogger.getInstance().getWrittenLines());
    }  
}
