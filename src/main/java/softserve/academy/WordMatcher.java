package softserve.academy;

class WordMatcher {

    private static String[] digits = new String[10];
    private static String[] teens = new String[10];
    private static String[] tens = new String[10];
    private static String[] hundreds = new String[10];
    private static String[] thousands = new String[3];
    private static String[] millions = new String[3];
    private static String[] billions = new String[3];

    static {
        digits[0] = "ноль";
        digits[1] = "один";
        digits[2] = "два";
        digits[3] = "три";
        digits[4] = "четыре";
        digits[5] = "пять";
        digits[6] = "шесть";
        digits[7] = "семь";
        digits[8] = "восем";
        digits[9] = "девять";
    }

    static {
        teens[1] = "одинадцать";
        teens[2] = "двенадцать";
        teens[3] = "тринадцать";
        teens[4] = "четырнадцать";
        teens[5] = "пятнадцать";
        teens[6] = "шестнадцать";
        teens[7] = "семнадцать";
        teens[8] = "восемнадцать";
        teens[9] = "девятнадцать";

    }

    static {
//        tens[0] = "ноль";
        tens[1] = "десять";
        tens[2] = "двадцать";
        tens[3] = "тридцать";
        tens[4] = "сорок";
        tens[5] = "пятьдесят";
        tens[6] = "шестьдесят";
        tens[7] = "семдесят";
        tens[8] = "восемдесят";
        tens[9] = "девяносто";
    }

    static {
//        hundreds[0] = "ноль";
        hundreds[1] = "сто";
        hundreds[2] = "двести";
        hundreds[3] = "триста";
        hundreds[4] = "четыреста";
        hundreds[5] = "пятсот";
        hundreds[6] = "шестьсот";
        hundreds[7] = "семсот";
        hundreds[8] = "восемсот";
        hundreds[9] = "девятсот";
    }

    static {
        thousands[0] = "тысяча";
        thousands[1] = "тысячи";
        thousands[2] = "тысяч";
    }

    static {
        millions[0] = "миллион";
        millions[1] = "миллиона";
        millions[2] = "миллионов";
    }

    static {
        billions[0] = "миллиард";
        billions[1] = "миллиарда";
        billions[2] = "миллиардов";
    }

    static String match(String num) throws NumberFormatException {
        int number = Integer.parseInt(num);
        switch (num.length()) {
            case 1:
                return digits[number];
            case 2:
                if (number < 20) {
                    return number == 10 ? tens[1] : teens[number - 10];
                } else if (number % 10 == 0) {
                    return tens[number / 10];
                } else {
                    return getTwoDigitNumString(num);
                }
            case 3:
                if (number % 100 == 0) {
                    return hundreds[number / 100];
                } else {
                    return getThreeDigitNumString(num);
                }
            case 4:
//                if (number % 1000 == 0) {
//                    return
//                }
                return "";
            case 5:
                return "";
            case 6:
                return "";
            case 7:
                return "";
            case 8:
                return "";
            case 9:
                return "";
            default:
                return "";
        }
//        return result;
    }

    private static String getThreeDigitNumString(String num) {
        StringBuilder strBuilder = new StringBuilder();
        String[] numComponents = num.split("");
        int hundredsComponent = Integer.parseInt(numComponents[0]);
        int tensComponent = Integer.parseInt(numComponents[1]);
        int digitsComponent = Integer.parseInt(numComponents[2]);
        if (tensComponent == 0) {
            strBuilder
                    .append(hundreds[hundredsComponent])
                    .append(" ")
                    .append(digitsComponent == 0 ? "" : digits[digitsComponent]);
        } else if (digitsComponent == 0) {
            strBuilder
                    .append(hundreds[hundredsComponent])
                    .append(" ")
                    .append(tens[tensComponent]);
        } else if (tensComponent == 1) {
            strBuilder
                    .append(hundreds[hundredsComponent])
                    .append(" ")
                    .append(teens[digitsComponent]);
        } else {
            strBuilder
                    .append(hundreds[hundredsComponent])
                    .append(" ")
                    .append(tens[tensComponent])
                    .append(" ")
                    .append(digits[digitsComponent]);
        }
        return strBuilder.toString();
    }

    private static String getTwoDigitNumString(String num) {
        StringBuilder strBuilder = new StringBuilder();
        String[] numComponents = num.split("");
        int tensComponent = Integer.parseInt(numComponents[0]);
        int digitsComponent = Integer.parseInt(numComponents[1]);
        strBuilder
                .append(tens[tensComponent])
                .append(" ")
                .append(digits[digitsComponent]);

        return strBuilder.toString();
    }
}
