package HTTP.ImproveSockets;

import HTTP.Sockets.HttpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class HttpHandler implements Runnable {
    private Socket socket;
    public HttpHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()) {
            byte[] request = HttpUtils.readRequest(in);
            System.out.println("---------------------");
            System.out.print(new String(request));
            System.out.println("---------------------");
            HttpUtils.writeResponse(out, new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
