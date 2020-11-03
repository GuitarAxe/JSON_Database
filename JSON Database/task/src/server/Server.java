package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    Menu menu = new Menu();
    String[] list = new String[1000];

    public Server() {
        System.out.println("Server started!");
    }

    public void run(int PORT, String request) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            String response = "";
            while (!response.equalsIgnoreCase("exit")) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String received = input.readUTF();
                    Scanner scanner = new Scanner(received);

                    response = menu.startMenu(scanner, list);
                    output.writeUTF(response);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }



}
