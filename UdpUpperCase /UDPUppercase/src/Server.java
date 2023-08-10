import java.io.IOException;
import java.net.*;

public class Server {

    //Define host and port for communication
    String hostName = "192.168.2.33";
    int portNumber = Integer.parseInt("9000");

    //Create a DatagramSocket for receiving and sending datagrams
    DatagramSocket socket = new DatagramSocket(8000);

    //Create a buffer for received data
    byte[] recvBuffer = new byte[1024];

    //Create a DatagramPacket for receiving data
    //RECEIVE, method to receive data using DatagramSocket
    DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

    public Server() throws IOException {
    }

    public String serverReceive() throws IOException {
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(),0, receivePacket.getLength());
            System.out.println(receivedMessage.toUpperCase());
            return receivedMessage.toUpperCase();
    }



    //SEND, method to send data using DatagramSocket
    public void serverSend() throws IOException {
        byte[] sendBuffer = serverReceive().getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);
        socket.send(sendPacket);
        closeSocket();
    }

    //Close the DatagramSocket
    public void closeSocket() {
        // Close the socket
        socket.close();
    }
}
