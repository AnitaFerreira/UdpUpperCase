import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Create instances of Client and Server
        Client client = new Client();
        Server server = new Server();

        //Send data from client to server
        client.clientSend();
        //Process and send data from server to client
        server.serverSend();
        //Receive and display data by the client
        client.clientReceive();

    }
}
