package dp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeastRemoveTest {

    LeastRemove leastRemove = null;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsPalindrome() {
        int a = 3;
        String input = "ab";
        Assert.assertFalse(LeastRemove.isPalindrome(a, input));
    }
}