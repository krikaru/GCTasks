package WREntity;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface EntityWriter extends Closeable, Flushable {
    void writePoint(Point point) throws IOException;
    void writePerson(Person person) throws IOException;
}
