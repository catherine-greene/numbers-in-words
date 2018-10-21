package softserve.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeDigitNumTest {
    private NumberComponentsRepo repo = NumberComponentsRepo.getRepository();

    private static String[][] testData() {
        return new String[][]{
                {"100", "сто"},
                {"101", "сто один"},
                {"110", "сто десять"},
                {"200", "двести"},
                {"202", "двести два"},
                {"211", "двести одинадцать"},
                {"300", "триста"},
                {"303", "триста три"},
                {"320", "триста двадцать"},
                {"400", "четыреста"},
                {"404", "четыреста четыре"},
                {"421", "четыреста двадцать один"},
                {"500", "пятсот"},
                {"505", "пятсот пять"},
                {"600", "шестьсот"},
                {"606", "шестьсот шесть"},
                {"700", "семсот"},
                {"707", "семсот семь"},
                {"800", "восемсот"},
                {"808", "восемсот восем"},
                {"900", "девятсот"},
                {"909", "девятсот девять"},
                {"990", "девятсот девяносто"},
                {"999", "девятсот девяносто девять"}
        };
    }

    @ParameterizedTest(name = "[{0}] --> {1}")
    @MethodSource("testData")
    void testOneDigitNumber(int number, String expected) {
        assertEquals(expected, repo.getThreeDigitNumString(number));
    }

}
