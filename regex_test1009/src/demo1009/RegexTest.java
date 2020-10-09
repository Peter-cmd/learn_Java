package demo1009;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args){
        String regex = "([a-z])\\1+|([a-z])\\1([a-z])\\2";
        String string = "aaaa123ddcc23";
        System.out.println(string.replaceAll("([a-z])\\1+", "$1$1").replaceAll("([a-z])\\1([a-z])\\2", "$1$1$2"));
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        String s = m.replaceAll("$");
        System.out.println();

    }
}
