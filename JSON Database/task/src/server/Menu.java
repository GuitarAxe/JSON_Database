package server;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public String startMenu(Scanner scanner, String[] list) {
        String command = scanner.next();
        int index = scanner.nextInt() - 1;
        String input = scanner.nextLine();

        try {
            if (command.equalsIgnoreCase("exit")) {
                return "exit";
            } else {
                if (index > 100 || index < 0) {
                    errorMessage();
                } else {
                    switch (command) {
                        case "set":
                            return setCell(list, index, input);
                        case "get":
                            return getCell(list, index);
                        case "delete":
                            return delete(list, index);
                        case "exit":
                            return "exit";
                        default:
                            return errorMessage();
                    }
                }
            }
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            return errorMessage();
        }
        return errorMessage();
    }


    public static String setCell(String[] list, int index, String input) {
        list[index] = input;
        return okMessage();
    }

    private static String getCell(String[] list, int index) {
        String cell = list[index];
        if (cell == null || cell.equals("")) {
            return errorMessage();
        } else {
            System.out.println(cell);
            return cell;
        }
    }

    private static String delete(String[] list, int index) {
        list[index] = "";
        return okMessage();
    }

    private static String errorMessage() {
        String error = "ERROR";
        System.out.println(error);
        return error;
    }

    private static String okMessage() {
        String ok = "OK";
        System.out.println(ok);
        return ok;
    }

}
