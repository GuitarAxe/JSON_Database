package server;

import com.google.gson.Gson;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {

    Map<String, String> responseMap;
    Map<String, String> requestMap;
    Gson gson = new Gson();
    String type;
    String key;
    String value;
    String responseJson;

    String OK = "OK";
    String ERROR = "ERROR";

    String VALUE = "value";
    String RESPONSE = "response";
    String REASON = "reason";
    String NO_SUCH_KEY = "No such key";


    public String startMenu(String received, Map<String, String> database) {
        responseMap = new LinkedHashMap<>();
        requestMap = gson.fromJson(received, Map.class);

        type = requestMap.get("type");
        key = requestMap.get("key");

        try {
            if (type.equalsIgnoreCase("exit")) {
                return "exit";
            } else {
                switch (type) {
                    case "set":
                        value = requestMap.get("value");
                        setCell(database);
                        break;
                    case "get":
                        getCell(database);
                        break;
                    case "delete":
                        deleteCell(database);
                        break;
                    case "exit":
                        return "exit";
                    default:
                        return ERROR;
                }
            }
            responseJson = gson.toJson(responseMap);
            return responseJson;
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            return ERROR;
        }
    }


    public void setCell(Map<String, String> database) {
        if (requestMap.containsKey("key") && requestMap.containsKey("value")) {
            database.put(key, value);
            responseMap.put(RESPONSE, OK);
        } else {
            responseMap.put(RESPONSE, ERROR);
        }
    }

    private void getCell(Map<String, String> database) {
        if (database.containsKey(key)) {
            responseMap.put(RESPONSE, OK);
            responseMap.put(VALUE, value);
        } else {
            responseMap.put(RESPONSE, ERROR);
            responseMap.put(REASON, NO_SUCH_KEY);
        }
    }

    private void deleteCell(Map<String, String> database) {
        if (database.containsKey(key)) {
            database.remove(key);
            responseMap.put(RESPONSE, OK);
        } else {
            responseMap.put(RESPONSE, ERROR);
            responseMap.put(REASON, NO_SUCH_KEY);
        }
    }


}
