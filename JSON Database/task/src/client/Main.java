package client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;
import server.Arguments;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;
    private static Arguments arguments = new Arguments();

    public static void main(String[] args) throws IOException {

        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        System.out.println("Client started!");
        String request = jsonConverter();

        Client client = new Client();
        client.run(request, SERVER_ADDRESS, SERVER_PORT);
    }

    private static String jsonConverter() {
        Map<String, String> map = new HashMap<>();
        map = requestMap(map);

        Gson gson = new Gson();
        String json = gson.toJson(map);

        return json;
    }

    private static Map<String, String> requestMap(Map<String, String> map) {
        String type = arguments.type;
        if (type.equalsIgnoreCase("set")) {
            map.put("type", arguments.type);
            map.put("key", arguments.key);
            map.put("value", arguments.input);
        }else {
            map.put("type", arguments.type);
            map.put("key", arguments.key);
        }
        return map;
    }
}
