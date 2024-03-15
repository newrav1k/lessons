package JavaRush.JavaCore.PersonScannerAdapter;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}