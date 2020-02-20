import org.junit.*;

import static org.junit.Assert.*;

public class CaculatorTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("创建class实例之前.");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("创建class实例之后.");
    }
    @Before
    public void before(){
        Caculator.a = 22;
        System.out.println("运行测试方法之前.");
    }
    @Test
    public void add() {
        Caculator caculator = new Caculator();
        int add = caculator.add(10, 10);
        System.out.println(add);
        System.out.println(caculator.a);
    }

    @After
    public void after(){
        System.out.println("运行测试之后.");
    }


    public void  print(){
        System.out.println("测试方法是否运行");
    }
}