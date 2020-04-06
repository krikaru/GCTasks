package IO.OSDecorator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class LogOS extends OutputStream {
    private final OutputStream out;
    private final  String moment;

    public LogOS(OutputStream out, String moment) {
        this.out = out;
        this.moment = moment;
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println(moment + " .Write:" + b);
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println(moment + " .Write: " + Arrays.toString(b));
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println(moment + " .Write: " + Arrays.toString(b) + " off = " + off + " len = " + len);
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        System.out.println(moment + " .Flush");
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
