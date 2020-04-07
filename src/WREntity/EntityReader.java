package WREntity;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface EntityReader extends Closeable{
    Person readPerson() throws IOException;
    Point readPoint() throws IOException;
}
