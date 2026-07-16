package trade.util;
import java.util.Scanner;
import trade.model.exception.EmptyInputException;
import trade.model.exception.InvalidNumberException;


public class CLIUtil {

    public static int getInt(String prompt) throws EmptyInputException, InvalidNumberException {
        String input = getString(prompt);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("angka bulat only"); // Syarat #7
        }
    }

    public static double getDouble(String prompt) throws EmptyInputException, InvalidNumberException {
        String input = getString(prompt);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("input harus angka");
        }
    }
}