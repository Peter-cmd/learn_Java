package t01;

import com.sun.javafx.binding.StringFormatter;

import java.text.SimpleDateFormat;

public class T01 {
    public static void main(String[] args){
        String stringFormat = "%5f";
        String result = String.format(stringFormat, 10 / 3.0);
        System.out.println(result);
    }
}
