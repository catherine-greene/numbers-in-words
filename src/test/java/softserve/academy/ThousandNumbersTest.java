package softserve.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThousandNumbersTest {
    private NumberComponentsRepo repo = NumberComponentsRepo.getRepository();

    private static String[][] testData() {
        return new String[][]{
                {"1000", "одна тысяча"},
                {"2001", "две тысячи один"},
                {"4010", "четыре тысячи десять"},
                {"5012", "пять тысяч двенадцать"},
                {"10000", "десять тысяч"},
                {"20000", "двадцать тысяч"},
                {"21200", "двадцать одна тысяча двести"},
                {"32110", "тридцать две тысячи сто десять"},
                {"43004", "сорок три тысячи четыре"},
                {"100303", "сто тысяч триста три"},
                {"201320", "двести одна тысяча триста двадцать"},
                {"202320", "двести две тысячи триста двадцать"},
                {"311400", "триста одинадцать тысяч четыреста"},
                {"420404", "четыреста двадцать тысяч четыреста четыре"},
                {"431000", "четыреста тридцать одна тысяча"},
                {"500002", "пятсот тысяч два"},
                {"800000", "восемсот тысяч"},
                {"808000", "восемсот восем тысяч"},
                {"909000", "девятсот девять тысяч"},
                {"909990", "девятсот девять тысяч девятсот девяносто"},
                {"999999", "девятсот девяносто девять тысяч девятсот девяносто девять"}
        };
    }

    @ParameterizedTest(name = "[{0}] --> {1}")
    @MethodSource("testData")
    void testOneDigitNumber(int number, String expected) {
        assertEquals(expected, repo.getThousandNumString(number));
    }

}
