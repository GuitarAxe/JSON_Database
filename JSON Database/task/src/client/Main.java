package client;

import com.beust.jcommander.JCommander;
import server.Arguments;

import java.io.IOException;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) throws IOException {

        final Arguments arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        System.out.println("Client started!");
        String request = arguments.type + " " + arguments.index + " " + arguments.input;

        Client client = new Client();
        client.run(request, SERVER_ADDRESS, SERVER_PORT);

    }
}
