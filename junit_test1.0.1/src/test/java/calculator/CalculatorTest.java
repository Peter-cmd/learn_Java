package calculator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    static Calculator calculator = null;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Before
    public void initState() {
        calculator.clear();
    }

    @Test
    public void testAdd() {
        calculator.add(2);
        assertEquals(2, calculator.getResult().longValue());
    }

    @Test
    public void testSubStruct() {
        calculator.substract(3);
        assertEquals(-3, calculator.getResult().longValue());
    }

    @Test(timeout = 2000)
    public void testSquareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult().longValue());
    }



//    @Ignore("代码未实现, 暂不测试!")
    @Test
    public void testSquare() {
//        calculator.square(2);
        fail("代码未实现!");
    }


}