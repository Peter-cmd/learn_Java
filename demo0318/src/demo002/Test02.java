package demo002;

public class Test02 {
    public static boolean print(char x){
        System.out.print(x);
        return true;
    }

    public static void main(String[] args){
        int i = 0;
        for (print('A');print('B')&&i<2; print('C')){
            i++;
            print('D');
        }
    }
}
