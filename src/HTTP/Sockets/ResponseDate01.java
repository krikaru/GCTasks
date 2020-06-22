package HTTP.Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ResponseDate01 {

    public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(80);
                while (true){
                    Socket socket = serverSocket.accept();
                    System.out.println("get one!");
                    try(InputStream in = socket.getInputStream();
                        OutputStream out = socket.getOutputStream()) {
                        byte[] request = HttpUtils.readRequest(in);
                        System.out.println("---------------------------");
                        System.out.print(new String(request));
                        System.out.println("---------------------------");

                        byte[] response = new Date().toString().getBytes();
                        out.write(response);
                    } finally {
                        socket.close();
                    }
                }




    }
}
