package HTTP.ImproveSockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServerWithThreadPool {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = new ThreadPoolExecutor(4, 64,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(256));
        ServerSocket serverSocket = new ServerSocket(80);

        while (true){
            Socket socket = serverSocket.accept();
            threadPool.submit(new HttpHandler(socket));
        }
    }
}
