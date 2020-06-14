import org.junit.*;

import static org.junit.Assert.*;

public class CaculatorTest {

    @BeforeClass
    public static void bforeClass(){
        System.out.println("类的实例创建之前");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("类的实例创建之后");
    }

    @Before
    public void before(){
        Caculator.a = 22;
        System.out.println("测试之前");
    }

    @Test
    public void add() {
        Caculator c = new Caculator();
        int add = c.add(10, 10);
        System.out.println("a = " + Caculator.a);
        System.out.println("add = " + add);
    }

    @Test
    public void print(){
        System.out.println("测试该方法是否运行");
    }

    @After
    public void after(){
        System.out.println("测试之后");
    }


}