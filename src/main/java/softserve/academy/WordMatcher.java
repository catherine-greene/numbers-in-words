package softserve.academy;

class WordMatcher {

    private static String[] digits = new String[10];
    private static String[] digitsExcep = new String[2];
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
        digitsExcep[0] = "одна";
        digitsExcep[1] = "две";
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

    static String match(long number) {
        int remainderOfDivisionOn1000 = (int) (number % 1000);
        String thousandString = getThousandString((int) (number / 1000));

        switch (getNumLength(number)) {
            case 1:
                return getOneDigitString((int) number);
            case 2:
                return getTwoDigitNumString((int) number);
            case 3:
                return getThreeDigitNumString((int) number);
            case 4:

                if (remainderOfDivisionOn1000 == 0) {
                    return thousandString;
                } else {
                    int remainderLength = getNumLength(remainderOfDivisionOn1000);
                    String restString = getRestString(remainderLength, remainderOfDivisionOn1000);
                    return thousandString + " " + restString;
                }

            case 5:
                if (remainderOfDivisionOn1000 == 0) {
                    return thousandString;
                } else {
                    int remainderLength = getNumLength(remainderOfDivisionOn1000);
                    String restString = getRestString(remainderLength, remainderOfDivisionOn1000);
                    return thousandString + " " + restString;
                }
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
    }

    private static int getNumLength(long intNum) {
        return String.valueOf(intNum).length();
    }

    private static String getOneDigitString(int number) {
        return digits[number];
    }

    private static String getRestString(int length, int num) {
        switch (length) {
            case 1:
                return getOneDigitString(num);
            case 2:
                return getTwoDigitNumString(num);
            case 3:
                return getThreeDigitNumString(num);
            default:
                return "";
        }
    }

    private static String getThousandString(int thousandNum) {
        switch (getNumLength(thousandNum)) {
            case 1:
                if (thousandNum == 1) {
                    return digitsExcep[0] + " " + thousands[0];
                } else if (thousandNum == 2) {
                    return digitsExcep[1] + " " + thousands[1];
                } else if (thousandNum == 3 || thousandNum == 4) {
                    return digits[thousandNum] + " " + thousands[1];
                } else {
                    return digits[thousandNum] + " " + thousands[2];
                }
            case 2:
                if (thousandNum > 10 && thousandNum < 20) {
                    return getTwoDigitNumString(thousandNum) + " " + thousands[0];
                }
                int remainder = thousandNum % 10;
                if (remainder == 1) {
                    return getTwoDigitNumString(thousandNum - remainder) + " " + digitsExcep[0] + " " + thousands[0];
                } else if (remainder == 2) {
                    return getTwoDigitNumString(thousandNum - remainder) + " " + digitsExcep[1] + " " + thousands[1];
                } else if (remainder == 3 || thousandNum % 10 == 4) {
                    return getTwoDigitNumString(thousandNum - remainder) + " " + digits[thousandNum % 10] + " " + thousands[1];
                } else {
                    return getTwoDigitNumString(thousandNum) + " " + thousands[2];
                }
            case 3:
                if (thousandNum % 10 == 1) {
                    return getThreeDigitNumString(thousandNum / 10) + " " + digitsExcep[0] + " " + thousands[0];
                } else if (thousandNum % 10 == 2) {
                    return getThreeDigitNumString(thousandNum / 10) + " " + digitsExcep[1] + " " + thousands[1];
                } else if (thousandNum % 10 == 3 || thousandNum % 10 == 4) {
                    return getThreeDigitNumString(thousandNum / 10) + " " + digits[thousandNum % 10] + " " + thousands[1];
                } else {
                    return getThreeDigitNumString(thousandNum) + thousands[2];
                }

            default:
                return "";
        }
    }

    private static String getThreeDigitNumString(int number) {
        if (number % 100 == 0) {
            return hundreds[number / 100];
        } else {
            StringBuilder strBuilder = new StringBuilder();
            String[] numComponents = String.valueOf(number).split("");
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
    }

    private static String getTwoDigitNumString(int number) {
        if (number < 20) {
            return number == 10 ? tens[1] : teens[number - 10];
        } else if (number % 10 == 0) {
            return tens[number / 10];
        } else {
            StringBuilder strBuilder = new StringBuilder();
            String[] numComponents = String.valueOf(number).split("");
            int tensComponent = Integer.parseInt(numComponents[0]);
            int digitsComponent = Integer.parseInt(numComponents[1]);
            strBuilder
                    .append(tens[tensComponent])
                    .append(" ")
                    .append(digits[digitsComponent]);

            return strBuilder.toString();
        }
    }
}
