import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public void run() throws UnknownHostException, IOException{
        int port = 8080;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address,port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
        System.out.println("Hellot from Client");
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = fromSocket.readLine();
        System.out.println("Response from the socket :" + line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main(String[] args) {
       try {
            Client client = new Client();
            client.run();
        } catch (Exception e) {
           e.printStackTrace();
       }
    }
}