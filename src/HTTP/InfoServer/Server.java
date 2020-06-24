package HTTP.InfoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Get connection");

            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                String request = in.readLine();
                System.out.println("Request: " + request);

                String response;
                switch (request){
                    case "Time"  :
                        response = ServiceHandle.getTime();
                        break;
                    case "Weather":
                        response = ServiceHandle.getWeather();
                        break;
                    default:
                        response = "Unknown command";
                }

                out.write(response + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                serverSocket.close();
            }
        }
    }
}
