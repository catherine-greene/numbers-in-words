package softserve.academy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NumberComponentsRepoTest {
    private final int num;
    private final String numStr;
    private final NumberComponentsRepo repo;

    public NumberComponentsRepoTest(int num, String numStr) {
        this.num = num;
        this.numStr = numStr;
        repo = NumberComponentsRepo.getRepository();
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {10, "десять тысяч"}, {11, "одинадцать тысяч"}, {12, "двенадцать тысяч"}, {20, "двадцать тысяч"},
                {31, "тридцать одна тысяча"}, {42, "сорок две тысячи"}, {53, "пятьдесят три тысячи"},
                {64, "шестьдесят четыре тысячи"}, {75, "семдесят пять тысяч"}, {100, "сто тысяч"},
                {201, "двести одна тысяча"}, {302, "триста две тысячи"}, {403, "четыреста три тысячи"},
                {504, "пятсот четыре тысячи"}, {605, "шестьсот пять тысяч"}, {210, "двести десять тысяч"},
                {311, "триста одинадцать тысяч"}, {412, "четыреста двенадцать тысяч"}, {520, "пятсот двадцать тысяч"},
                {631, "шестьсот тридцать одна тысяча"}, {742, "семсот сорок две тысячи"}, {853, "восемсот пятьдесят три тысячи"},
                {964, "девятсот шестьдесят четыре тысячи"}, {195, "сто девяносто пять тысяч"}, {999, "девятсот девяносто девять тысяч"}
        };

    }


    @Test
    public void testGetThousandString() {
        //WHEN
        String result = repo.getThousandString(num);
        //THEN
        Assert.assertEquals(numStr, result);
    }
}
