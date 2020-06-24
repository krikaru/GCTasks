package HTTP.InfoServer;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try(Socket clientSocket = new Socket("127.0.0.1", 80);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            out.write("Weather\n");
//            out.write("Time\n");
//            out.write("sgsrgrg");
            out.flush();

            System.out.println("Answer: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
