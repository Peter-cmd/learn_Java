package demo002;

import demo001.Test01;

import java.io.File;

public class Test02 {

    public static void main(String[] args){
        File file = new File(".");
        String absolutePath  = file.getAbsolutePath();
        System.getProperties().list(System.out);
        System.out.println(absolutePath);
    }
}
