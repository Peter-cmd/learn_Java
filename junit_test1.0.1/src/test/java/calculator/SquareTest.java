package calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SquareTest {
    public static Calculator calculator = new Calculator();
    public Integer param;
    public Integer result;

    public SquareTest(Integer param, Integer result) {
        this.param = param;
        this.result = result;
    }

    @Parameters
    public static Collection getParamResult() {
        return Arrays.asList(new Object[][]{{2, 4}, {0, 0}, {-3, 9}});
    }

    @Test
    public void testSquare() {
        calculator.square(param);
        assertEquals(result, calculator.getResult());
    }

}
