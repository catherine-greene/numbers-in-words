package softserve.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneDigitNumTest {
    private NumberComponentsRepo repo = NumberComponentsRepo.getRepository();

    private static String[][] testData() {
        return new String[][]{
                {"1", "один"},
                {"2", "два"},
                {"3", "три"},
                {"4", "четыре"},
                {"5", "пять"},
                {"6", "шесть"},
                {"7", "семь"},
                {"8", "восем"},
                {"9", "девять"}
        };
    }

    @ParameterizedTest(name = "[{index}] --> {1}")
    @MethodSource("testData")
    void testOneDigitNumber(int number, String expected) {
        assertEquals(expected, repo.getOneDigitNumString(number));
    }
}
