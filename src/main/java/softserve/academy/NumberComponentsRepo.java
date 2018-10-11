package softserve.academy;

class NumberComponentsRepo {
    private static NumberComponentsRepo repository;
    private String[] digits = new String[10];
    private String[] digitsExcep = new String[2];
    private String[] teens = new String[10];
    private String[] tens = new String[10];
    private String[] hundreds = new String[10];
    private String[] thousands = new String[3];
    private String[] millions = new String[3];
    private String[] billions = new String[3];

    private NumberComponentsRepo() {
        initDigits();
        initDigitsExcep();
        initTeens();
        initTens();
        initHundreds();
        initThousands();
        initMillions();
        initBillions();
    }

    static NumberComponentsRepo getRepository() {
        if (repository == null) {
            repository = new NumberComponentsRepo();
        }
        return repository;
    }

    private void initDigits() {
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

    private void initDigitsExcep() {
        digitsExcep[0] = "одна";
        digitsExcep[1] = "две";
    }

    private void initTeens() {
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

    private void initTens() {
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

    private void initHundreds() {
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

    private void initThousands() {
        thousands[0] = "тысяча";
        thousands[1] = "тысячи";
        thousands[2] = "тысяч";
    }

    private void initMillions() {
        millions[0] = "миллион";
        millions[1] = "миллиона";
        millions[2] = "миллионов";
    }

    private void initBillions() {
        billions[0] = "миллиард";
        billions[1] = "миллиарда";
        billions[2] = "миллиардов";
    }

    private int getNumLength(long intNum) {
        return String.valueOf(intNum).length();
    }

    private String getOneDigitString(int number) {
        return digits[number];
    }

    private String getRestString(int length, int num) {
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

    String getThousandString(int thousandNum) {
        int remainderOn10 = thousandNum % 10;

        switch (getNumLength(thousandNum)) {

            case 1:
                if (thousandNum == 1) {
                    return digitsExcep[0] + " " + thousands[0];
                } else if (thousandNum == 2) {
                    return digitsExcep[1] + " " + thousands[1];
                } else if (thousandNum == 3 || thousandNum == 4) {
                    return getOneDigitString(thousandNum) + " " + thousands[1];
                } else {
                    return getOneDigitString(thousandNum) + " " + thousands[2];
                }
            case 2:
                if (thousandNum > 10 && thousandNum < 20) {
                    return getTwoDigitNumString(thousandNum) + " " + thousands[2];
                }
                if (remainderOn10 == 1) {
                    return getTwoDigitNumString(thousandNum - remainderOn10) + getOneThousandString();
                } else if (remainderOn10 == 2) {
                    return getTwoDigitNumString(thousandNum - remainderOn10) + getTwoThousandString();
                } else if (remainderOn10 == 3 || remainderOn10 == 4) {
                    return getTwoDigitNumString(thousandNum) + " " + thousands[1];
                } else {
                    return getTwoDigitNumString(thousandNum) + " " + thousands[2];
                }
            case 3:
                int remainderOn100 = thousandNum % 100;
                if (remainderOn100 > 10 && remainderOn100 < 20) {
                    return getThreeDigitNumString(thousandNum - remainderOn100)
                            + " " + getTwoDigitNumString(remainderOn100) + " " + thousands[2];
                }

                if (remainderOn10 == 1) {
                    return getThreeDigitNumString(thousandNum - remainderOn10) + getOneThousandString();
                } else if (remainderOn10 == 2) {
                    return getThreeDigitNumString(thousandNum - remainderOn10) + getTwoThousandString();
                } else if (remainderOn10 == 3 || thousandNum % 10 == 4) {
                    return getThreeDigitNumString(thousandNum) + " " + thousands[1];
                } else {
                    return getThreeDigitNumString(thousandNum) + " " + thousands[2];
                }

            default:
                return "";
        }
    }

    private String getTwoThousandString() {
        return " " + digitsExcep[1] + " " + thousands[1];
    }

    private String getOneThousandString() {
        return " " + digitsExcep[0] + " " + thousands[0];
    }

    private String getThreeDigitNumString(int number) {
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

    private String getTwoDigitNumString(int number) {
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
