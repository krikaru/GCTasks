package HTTP.Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class HttpUtils {

    public static byte[] readRequest(InputStream in) throws IOException {
        byte[] buff = new byte[8*1024];
        int currentLength = 0;
        while (true){
            int count = in.read(buff, currentLength, buff.length - currentLength);

            if (count < 0){
                throw new RuntimeException("Connection closed");
            }else {
                currentLength += count;
                if (isRequestEnd(buff, currentLength)){
                    return Arrays.copyOfRange(buff, 0, currentLength);
                }
                if (currentLength == buff.length){
                    throw new RuntimeException("Too big header");
                }
            }

        }
    }

    public static void writeResponse(OutputStream out, String msg) throws IOException {
        out.write(msg.getBytes());
    }

    private static boolean isRequestEnd(byte[] buff, int currentLength){
        if (currentLength < 4 ){
            return false;
        }
        return buff[currentLength - 4] == '\r' &&
                buff[currentLength - 3] == '\n' &&
                buff[currentLength - 2] == '\r' &&
                buff[currentLength - 1] == '\n';
    }
}
