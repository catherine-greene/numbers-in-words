package softserve.academy;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Enter a number in range of 0 and 999 999 999 999" + "(or \"exit\" to quit) ");
        do {
            Scanner scanner = new Scanner(System.in);
            String input = getFormattedInput(scanner.nextLine());
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                long number = Long.parseLong(input);
                String output = WordMatcher.match(number);
                System.out.println(output);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input number.  Enter a number in range of 0 and 999 999 999 999!");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);

    }

    private static String getFormattedInput(String input) {
        return input.trim().replace(" ", "");
    }
}
