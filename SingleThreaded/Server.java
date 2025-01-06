import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class Server{
    public static void main(String[] args){
        public void run(){
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}