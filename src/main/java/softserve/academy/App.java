package softserve.academy;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

//        if (args.length == 1) {
//            input = args[0];
//
//        } else if (args.length > 1) {
//            input = concatArgs(args);
//        }
        try {
//            long num = parseToLong(input);
            String output = WordMatcher.match(input);
            System.out.println(output);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input number.  Enter a number in range of 0 and 999 999 999 999!");
        }

    }

    private static String concatArgs(String[] args) {
        StringBuilder strBuff = new StringBuilder();
        for (String arg : args) {
            strBuff.append(arg);
        }

        return strBuff.toString();
    }

    private static long parseToLong(String input) throws NumberFormatException {
        return Long.parseLong(input);
    }
}
