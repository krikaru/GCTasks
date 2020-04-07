package WREntity;

import java.io.*;

public class EntityOutputWriter implements EntityWriter {

    private Writer out;

    public EntityOutputWriter(Writer out) {
        this.out = out;
    }

    @Override
    public void writePoint(Point point) throws IOException {
        out.write("<point x='" + point.getX() + "' y='" + point.getY() + "'/>");
        out.flush();
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.write("<person>\n");
        out.write("   <name>" + person.getName() + "</name>\n");
        out.write("   <age>" + person.getAge() + "</age>\n");
        out.write("</person>\n");
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }
}
