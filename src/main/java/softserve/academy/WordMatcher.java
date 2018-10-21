package softserve.academy;

class WordMatcher {
    static String match(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Enter positive number!");
        }
        String result;
        NumberComponentsRepo repo = NumberComponentsRepo.getRepository();
        int numLength = repo.getNumLength(number);

        if (numLength == 1) {
            result = repo.getOneDigitNumString((int) number);
        } else if (numLength == 2) {
            result = repo.getTwoDigitNumString((int) number);

        } else if (numLength == 3) {
            result = repo.getThreeDigitNumString((int) number);

        } else if (numLength > 3 && numLength < 7) {
            result = repo.getThousandNumString((int) number);

        } else if (numLength >= 7 && numLength < 10) {
            result = repo.getMillionNumString((int) number);

        } else if (numLength >= 10 && numLength < 13) {
            result = repo.getBillionNumString(number);
        } else {
            throw new NumberFormatException();
        }
        return result;
    }
}
