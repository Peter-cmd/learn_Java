package demo002;

import java.io.File;

public class Test02 {
    public static void main(String[] args){
        File file = new File(".");
        String absolutePath  = file.getAbsolutePath();

        System.out.println(absolutePath);
    }
}
