package demo001;

public class Demo001 {
    char[] chars = {'b', 'c'};
    private static void TestMethod(){
        System.out.println("testMethod");
    }

    public static void main(String[] args){
        Demo001 demo001 = new Demo001();
        System.out.println(demo001.chars);
        ((Demo001)null).TestMethod();
    }
}
