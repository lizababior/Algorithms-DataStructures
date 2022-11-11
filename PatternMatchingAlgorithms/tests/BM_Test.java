import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class BM_Test {
    BoyerMoore matcher = new BoyerMoore();

    @Test
    public void illegalArg() {
        //null pattern
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            matcher.searchBM(null, "xxx");
        });
        String expectedMessage = "Pattern can not be null or empty.";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        //null text
        exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            matcher.searchBM("text", null);
        });
        expectedMessage = "Text can not be null or empty.";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        //text length < pattern length
        exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            matcher.searchBM("xxx", "x");
        });
        expectedMessage = "Text can not be shorter than pattern.";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void search() {
        Result result = matcher.searchBM("xxx", "abcdexxxunbexxxke");
        Assert.assertTrue(result.isFound());
        Assert.assertEquals(2, result.getOccurrences());
        Assert.assertEquals(new ArrayList<>(Arrays.asList(5, 12)), result.getIndices());

        result = matcher.searchBM("yyy", "abcdexxxunbexxxke");
        Assert.assertFalse(result.isFound());
        Assert.assertEquals(0, result.getOccurrences());
        Assert.assertEquals(new ArrayList<>(), result.getIndices());
    }
}
