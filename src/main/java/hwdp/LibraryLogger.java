package hwdp;
import java.util.ArrayList;

public class LibraryLogger {
    
    // Uninitialized instance
    private static LibraryLogger instance;

    private ArrayList<String> writtenLines;

    // Private constructor for singleton
    private LibraryLogger() {}

    public void writeLine(String line) {
        
        if (writtenLines == null)
        {
            writtenLines = new ArrayList<String>();
        }
        // Add to list
        writtenLines.add(line);
    
        System.out.println("LibraryLogger: " + line);
    }

    public String[] getWrittenLines() {
        
        if (writtenLines != null) {
            return writtenLines.toArray(new String[writtenLines.size()]);
        } 

        writtenLines = new ArrayList<String>();

        return writtenLines.toArray(new String[writtenLines.size()]);
    }

    public void clearWriteLog() {
        
        writtenLines = new ArrayList<String>();
    }
    
    public static LibraryLogger getInstance() {
        
        if (instance == null) {
            instance = new LibraryLogger();

            // Call ExpensiveComputeToy
            ExpensiveComputeToy.performExpensiveLogSetup();
        }

        return instance;
    }
}
