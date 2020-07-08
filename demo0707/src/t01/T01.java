package t01;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T01 {
    public static void main(String[] args){

        String url = "verb";
        String pattern = "[a-z]";
        //boolean result = url.matches(pattern);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(url);


    }
}
