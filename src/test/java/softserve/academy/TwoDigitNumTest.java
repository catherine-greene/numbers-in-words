package softserve.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDigitNumTest {
    private NumberComponentsRepo repo = NumberComponentsRepo.getRepository();

    private static String[][] testData() {
        return new String[][]{
                {"10", "десять"},
                {"11", "одинадцать"},
                {"12", "двенадцать"},
                {"13", "тринадцать"},
                {"14", "четырнадцать"},
                {"15", "пятнадцать"},
                {"16", "шестнадцать"},
                {"17", "семнадцать"},
                {"18", "восемнадцать"},
                {"19", "девятнадцать"},
                {"20", "двадцать"},
                {"21", "двадцать один"},
                {"32", "тридцать два"},
                {"43", "сорок три"},
                {"54", "пятьдесят четыре"},
                {"65", "шестьдесят пять"},
                {"76", "семдесят шесть"},
                {"87", "восемдесят семь"},
                {"98", "девяносто восем"},
                {"99", "девяносто девять"}
        };
    }

    @ParameterizedTest(name = "[{0}] --> {1}")
    @MethodSource("testData")
    void testOneDigitNumber(int number, String expected) {
        assertEquals(expected, repo.getTwoDigitNumString(number));
    }

}
