package trade.util;

import trade.model.exception.EmptyInputException;
import trade.model.exception.InvalidNumberException;
import java.util.Scanner;

public class CLIUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) throws EmptyInputException {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input == null || input.trim().isEmpty()) {
            throw new EmptyInputException("tidak boleh kosong");
        }
        return input.trim();
    }

    public static int getIntInput(String prompt) throws EmptyInputException, InvalidNumberException {
        String input = getStringInput(prompt);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("harus angka bulat");
        }
    }

    public static double getDoubleInput(String prompt) throws EmptyInputException, InvalidNumberException {
        String input = getStringInput(prompt);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("harus angka");
        }
    }
}