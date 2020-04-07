package IOEntity;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

public interface EntityOutput {
    void writePoint(Point point) throws IOException;
    void writePerson(Person person) throws IOException;
}
