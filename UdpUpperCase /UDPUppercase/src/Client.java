import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    //Define host and port for the server
    String hostName = "192.168.2.33";
    int portNumber = Integer.parseInt("8000");

    //Create a DatagramSocket for sending and receiving datagrams
    DatagramSocket socket = new DatagramSocket(9000);

    //Set up user input and message buffers
    Scanner scanner = new Scanner(System.in);
    private String message = scanner.nextLine();
    byte[] sendBuffer = message.getBytes();
    byte[] recvBuffer = new byte[1024];



    //Create a DatagramPacket for sending data

    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);

    //SEND, method to send data using DatagramSocket
    public void clientSend() throws IOException {
        socket.send(sendPacket);
    }



    //RECEIVE, method to receive data using DatagramSocket
    DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
    public Client() throws SocketException, UnknownHostException {
    }
    public void clientReceive() throws IOException {
            //Receive data and print the received message
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message: " + receivedMessage);
            closeSocket();
    }


    //Close the DatagramSocket
    public void closeSocket() {
        // Close the socket
        socket.close();
    }
}
