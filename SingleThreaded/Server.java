import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server{
        public void run() throws IOException{
            int port = 8080;
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            while(true){
                try{
                    System.out.println("Server is listening on port " + port);
                    Socket acceptedConnection = serverSocket.accept();
                    System.out.println("Client connected" + acceptedConnection.getRemoteSocketAddress());
                    PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
                    BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                    System.out.println("Hello from the server");
                    toClient.close();
                    fromClient.close();
                    acceptedConnection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}