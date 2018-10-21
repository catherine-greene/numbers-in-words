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

    int getNumLength(long intNum) {
        return String.valueOf(intNum).length();
    }

    String getOneDigitNumString(int number) {
        return digits[number];
    }

    String getTwoDigitNumString(int number) {
        if (number < 20) {
            return number == 10 ? tens[1] : teens[number % 10];
        } else if (number % 10 == 0) {
            return tens[number / 10];
        } else {
            StringBuilder strBuilder = new StringBuilder();
            String[] numComponents = String.valueOf(number).split("");
            int tensComponent = Integer.parseInt(numComponents[0]);
            int digitComponent = Integer.parseInt(numComponents[1]);
            strBuilder
                    .append(tens[tensComponent])
                    .append(" ")
                    .append(digits[digitComponent]);
            return strBuilder.toString();
        }
    }

    String getThreeDigitNumString(int number) {
        String result;
        int remainderOn100 = number % 100;
        String hundredsString = hundreds[number / 100];
        if (remainderOn100 == 0) {
            result = hundredsString;
        } else if (remainderOn100 < 10) {
            result = hundredsString + " " + getOneDigitNumString(remainderOn100);
        } else {
            result = hundredsString + " " + getTwoDigitNumString(remainderOn100);
        }
        return result;
    }

    String getThousandNumString(int number) {
        String result;
        int remainderOn1000 = number % 1000;
        String thousandString = getThousandString(number / 1000);
        if (remainderOn1000 == 0) {
            result = thousandString;
        } else if (remainderOn1000 > 0 && remainderOn1000 < 10) {
            result = thousandString + " " + getOneDigitNumString(remainderOn1000);
        } else if (remainderOn1000 >= 10 && remainderOn1000 < 100) {
            result = thousandString + " " + getTwoDigitNumString(remainderOn1000);
        } else {
            result = thousandString + " " + getThreeDigitNumString(remainderOn1000);
        }
        return result;
    }

    String getMillionNumString(long number) {
        String result;
        long remainderOn1000000 = number % 1000000;
        String millionString = getMillionString(number / 1000000);
        if (remainderOn1000000 == 0) {
            result = millionString;
        } else if (remainderOn1000000 < 1000) {
            result = millionString + " " + getStringEnding(getNumLength(remainderOn1000000), (int) remainderOn1000000);
        } else {
            String thousandString = getThousandNumString((int) remainderOn1000000);
            result = millionString + " " + thousandString;
        }
        return result;
    }

    String getBillionNumString(long number) {
        long remainderOn1_000_000_000 = number % 1_000_000_000;
        String billionString = getBillionString(number / 1_000_000_000);
        if (remainderOn1_000_000_000 == 0) {
            return billionString;
        } else if (remainderOn1_000_000_000 < 1000) {
            return billionString + " " + getStringEnding(getNumLength(remainderOn1_000_000_000), (int) remainderOn1_000_000_000);
        } else if (remainderOn1_000_000_000 < 1_000_000) {
            return billionString + " " + getThousandNumString((int) remainderOn1_000_000_000);
        } else {
            return billionString + " " + getMillionNumString(remainderOn1_000_000_000);
        }
    }

    private String getStringEnding(int length, int num) {
        String result = "";
        switch (length) {
            case 1:
                result = getOneDigitNumString(num);
                break;
            case 2:
                result = getTwoDigitNumString(num);
                break;
            case 3:
                result = getThreeDigitNumString(num);
                break;
        }
        return result;
    }

    private String getThousandString(int thousandNum) {
        String result = "";
        switch (getNumLength(thousandNum)) {
            case 1:
                result = getOneDigitThousandString(thousandNum);
                break;
            case 2:
                result = getTwoDigitThousandString(thousandNum);
                break;
            case 3:
                result = getThreeDigitThousandString(thousandNum);
                break;
        }
        return result;

    }

    private String getThreeDigitThousandString(int thousandNum) {
        String result;
        int remainderOn10 = thousandNum % 10;
        int remainderOn100 = thousandNum % 100;
        if (remainderOn100 > 10 && remainderOn100 < 20) {
            result = getThreeDigitNumString(thousandNum - remainderOn100)
                    + " " + getTwoDigitNumString(remainderOn100) + " " + thousands[2];
        } else if (remainderOn10 == 1) {
            result = getThreeDigitNumString(thousandNum - remainderOn10) + " " + getOneThousandString();
        } else if (remainderOn10 == 2) {
            result = getThreeDigitNumString(thousandNum - remainderOn10) + " " + getTwoThousandString();
        } else if (remainderOn10 == 3 || remainderOn10 == 4) {
            result = getThreeDigitNumString(thousandNum) + " " + thousands[1];
        } else {
            result = getThreeDigitNumString(thousandNum) + " " + thousands[2];
        }
        return result;
    }

    private String getTwoDigitThousandString(int thousandNum) {
        String result;
        int remainderOn10 = thousandNum % 10;
        if (thousandNum > 10 && thousandNum < 20) {
            result = getTwoDigitNumString(thousandNum) + " " + thousands[2];
        } else if (remainderOn10 == 1) {
            result = getTwoDigitNumString(thousandNum - remainderOn10) + " " + getOneThousandString();
        } else if (remainderOn10 == 2) {
            result = getTwoDigitNumString(thousandNum - remainderOn10) + " " + getTwoThousandString();
        } else if (remainderOn10 == 3 || remainderOn10 == 4) {
            result = getTwoDigitNumString(thousandNum) + " " + thousands[1];
        } else {
            result = getTwoDigitNumString(thousandNum) + " " + thousands[2];
        }
        return result;
    }

    private String getOneDigitThousandString(int thousandNum) {
        String result;
        if (thousandNum == 1) {
            result = digitsExcep[0] + " " + thousands[0];
        } else if (thousandNum == 2) {
            result = digitsExcep[1] + " " + thousands[1];
        } else if (thousandNum == 3 || thousandNum == 4) {
            result = getOneDigitNumString(thousandNum) + " " + thousands[1];
        } else {
            result = getOneDigitNumString(thousandNum) + " " + thousands[2];
        }
        return result;
    }

    private String getTwoThousandString() {
        return digitsExcep[1] + " " + thousands[1];
    }

    private String getOneThousandString() {
        return digitsExcep[0] + " " + thousands[0];
    }

    private String getMillionString(long millionNum) {
        String result = "";
        switch (getNumLength(millionNum)) {
            case 1:
                result = getOneDigitMillionString((int) millionNum);
                break;
            case 2:
                result = getTwoDigitMillionString((int) millionNum);
                break;
            case 3:
                result = getThreeDigitMillionString((int) millionNum);
                break;
        }
        return result;
    }

    private String getThreeDigitMillionString(int millionNum) {
        String result;
        int remainderOn100 = millionNum % 100;
        int remainderOn10 = millionNum % 10;
        if (remainderOn100 > 10 && remainderOn100 < 20) {
            result = getThreeDigitNumString(millionNum) + " " + millions[2];
        } else if (remainderOn10 == 1) {
            result = getThreeDigitNumString(millionNum) + " " + millions[0];
        } else if (remainderOn10 >= 2 && remainderOn10 <= 4) {
            result = getThreeDigitNumString(millionNum) + " " + millions[1];
        } else {
            result = getThreeDigitNumString(millionNum) + " " + millions[2];

        }
        return result;
    }

    private String getTwoDigitMillionString(int millionNum) {
        String result;
        int remainderOn10 = millionNum % 10;
        if (millionNum > 10 && millionNum < 20) {
            result = getTwoDigitNumString(millionNum) + " " + millions[2];
        } else if (remainderOn10 == 1) {
            result = getTwoDigitNumString(millionNum) + " " + millions[0];
        } else if (remainderOn10 >= 2 && remainderOn10 <= 4) {
            result = getTwoDigitNumString(millionNum) + " " + millions[1];
        } else {
            result = getTwoDigitNumString(millionNum) + " " + millions[2];
        }

        return result;
    }

    private String getOneDigitMillionString(int firstPartOfNum) {
        String result;
        if (firstPartOfNum == 1) {
            result = digits[1] + " " + millions[0];
        } else if (firstPartOfNum == 2) {
            result = digits[2] + " " + millions[1];
        } else if (firstPartOfNum == 3 || firstPartOfNum == 4) {
            result = getOneDigitNumString(firstPartOfNum) + " " + millions[1];
        } else {
            result = getOneDigitNumString(firstPartOfNum) + " " + millions[2];
        }
        return result;

    }

    private String getBillionString(long billionNum) {

        String result = "";
        switch (getNumLength(billionNum)) {
            case 1:
                result = getOneDigitBillionString((int) billionNum);
                break;
            case 2:
                result = getTwoDigitBillionString((int) billionNum);
                break;
            case 3:
                result = getThreeDigitBillionString((int) billionNum);
                break;
        }
        return result;
    }

    private String getThreeDigitBillionString(int billionNum) {
        String result;
        int remainderOn100 = billionNum % 100;
        int remainderOn10 = billionNum % 10;
        if (remainderOn100 > 10 && remainderOn100 < 20) {
            result = getThreeDigitNumString(billionNum) + " " + billions[2];
        } else if (remainderOn10 == 1) {
            result = getThreeDigitNumString(billionNum) + " " + billions[0];
        } else if (remainderOn10 >= 2 && remainderOn10 <= 4) {
            result = getThreeDigitNumString(billionNum) + " " + billions[1];
        } else {
            result = getThreeDigitNumString(billionNum) + " " + billions[2];

        }
        return result;
    }

    private String getTwoDigitBillionString(int billionNum) {
        String result;
        int remainderOn10 = billionNum % 10;
        if (billionNum > 10 && billionNum < 20) {
            result = getTwoDigitNumString(billionNum) + " " + billions[2];
        } else if (remainderOn10 == 1) {
            result = getTwoDigitNumString(billionNum) + " " + billions[0];
        } else if (remainderOn10 >= 2 && remainderOn10 <= 4) {
            result = getTwoDigitNumString(billionNum) + " " + billions[1];
        } else {
            result = getTwoDigitNumString(billionNum) + " " + billions[2];
        }

        return result;
    }

    private String getOneDigitBillionString(int billionNum) {
        String result;
        if (billionNum == 1) {
            result = digits[1] + " " + billions[0];
        } else if (billionNum == 2) {
            result = digits[2] + " " + billions[1];
        } else if (billionNum == 3 || billionNum == 4) {
            result = getOneDigitNumString(billionNum) + " " + billions[1];
        } else {
            result = getOneDigitNumString(billionNum) + " " + billions[2];
        }
        return result;

    }


}
