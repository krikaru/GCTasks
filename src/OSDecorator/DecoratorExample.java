package OSDecorator;

import java.io.*;

public class DecoratorExample {
    public static void main(String[] args) {
        OutputStream out = new LogOS(new BufferedOutputStream(new LogOS(new ByteArrayOutputStream(), "AFTER"), 2), "BEFORE");

        try {
            out.write(1);
            out.write(2);
            out.write(10);
            out.write(15);
            out.write(18);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
