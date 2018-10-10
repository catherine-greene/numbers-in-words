package softserve.academy;

public class App {
    public static void main(String[] args) {

        String input = "";
        if (args.length == 1) {
            input = args[0];

        } else if (args.length > 1) {
            input = concatArgs(args);
        }
        try {
            long num = Long.parseLong(input);
            String output = WordMatcher.match(num);
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
}
