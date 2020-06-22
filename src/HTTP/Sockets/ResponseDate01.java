package HTTP.Sockets;

import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ResponseDate01 {

    private static final Charset US_ASCII = new US_ASCII();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
                while (true){
                    Socket socket = serverSocket.accept();
                    System.out.println("get one!");
                    try(InputStream in = socket.getInputStream();
                        OutputStream out = socket.getOutputStream()) {
                        byte[] request = HttpUtils.readRequest(in);
                        System.out.println("---------------------------");
                        System.out.print(new String(request, StandardCharsets.US_ASCII));
                        System.out.println("---------------------------");


                        byte[] response = new Date().toString().getBytes(StandardCharsets.US_ASCII);
                        out.write(response);
                    } finally {
                        socket.close();
                    }
                }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
