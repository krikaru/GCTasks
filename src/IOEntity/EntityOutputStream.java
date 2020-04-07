package IOEntity;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EntityOutputStream implements EntityOutput {

    private DataOutput out;

    public EntityOutputStream(OutputStream out) {
        this.out = new DataOutputStream(out);
    }

    @Override
    public void writePoint(Point point) throws IOException {
        out.writeInt(point.getX());
        out.writeInt(point.getY());
    }

    @Override
    public void writePerson(Person person) throws IOException {

        if (person.getName() == null){
            out.writeBoolean(false);
        }else {
            out.writeBoolean(true);
            out.writeUTF(person.getName());
        }
        out.writeInt(person.getAge());
    }
}
