package job01.test01;

public class Test {
    public static void main(String[] args){
        int[] arrays = new int[100];
        for (int i = 0; i < 10; i++){
            arrays[i] = i;
        }
        System.out.println(arrays.length);
        for (int i = 0; i < 20; i++){
            System.out.println(arrays[i]);
        }
    }
}
