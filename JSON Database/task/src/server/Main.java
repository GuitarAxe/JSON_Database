package server;

import com.beust.jcommander.JCommander;

public class Main {

    private static final int PORT = 34522;

    public static void main(String[] args) {

        final Arguments arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        String request = arguments.type + " " + arguments.index + " " + arguments.input;

        Server server = new Server();
        server.run(PORT, request);

    }


}

