package IOEntity;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EntityInputStream implements EntityInput {
    private DataInput in;

    public EntityInputStream(InputStream in) {
        this.in = new DataInputStream(in);
    }

    @Override
    public Person readPerson() throws IOException {
        if (in.readBoolean()){
            return new Person(in.readUTF(), in.readInt());
        }else {
            return new Person("NoName", in.readInt());
        }

    }

    @Override
    public Point readPoint() throws IOException {
        return new Point(in.readInt(), in.readInt());
    }
}
