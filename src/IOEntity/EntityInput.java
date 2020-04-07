package IOEntity;

import java.io.Closeable;
import java.io.IOException;

public interface EntityInput {
    Person readPerson() throws IOException;
    Point readPoint() throws IOException;
}
