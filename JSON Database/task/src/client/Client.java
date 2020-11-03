package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {


    public Client() {
    }

    public void run(String request, String address, int port) {
        try (Socket socket = new Socket(InetAddress.getByName(address), port);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        ) {
            output.writeUTF(request);
            System.out.println("Sent: " + request);

            String received = input.readUTF();
            System.out.println("Received: " + received);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
