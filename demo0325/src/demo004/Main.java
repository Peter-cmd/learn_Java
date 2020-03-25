package demo004;

import com.sun.xml.internal.bind.v2.runtime.output.IndentingUTF8XmlOutput;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 问题描述: 对消息原文中的每个字母,分别用该字母之后的第5个字母
 替换(例如: 消息原文中的每个字母A都分别替换成字母F),其他字符不
 变,并且消息原文的所有字母都是大写的.密码中的字母与原文中的字母
 对应关系如下:
 密码字母: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 原文字母: V W X Y Z A B C D E F G H I J K L M N O P Q R S T U

 输入描述:
 输入包括多组数据,每组数据一行,为收到的密文.
 密文仅有空格和大写字母组成.

 输出描述:
 对应每一组数据,输出解密后的明文

 输入:
 HELLO WORLD
 SNHJ

 输出:
 CZGGJ RJMGY
 NICE

 */

public class Main {


    public static void main(String[] args){
    }
}
