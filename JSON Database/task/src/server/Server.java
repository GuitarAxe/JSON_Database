package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    Map<String, String> database = new HashMap<>();
    Menu menu = new Menu();

    public Server() {
        System.out.println("Server started!");
    }

    public void run(int PORT) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            String response = "";
            while (!response.equalsIgnoreCase("exit")) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String received = input.readUTF();

                    response = menu.startMenu(received, database);
                    output.writeUTF(response);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }



}
