package T01;

/**
 *
 * 问题描述:在国外企业喜欢把电话号码设计成与自己公司名字相对应。例如公司的Help Desk号码是4357，
 * 因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。同理，TUT-GLOP就代表888-4567、
 * 310-GINO代表310-4466.NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码
 * 列表，请你帮他转换成数字形式的号码，并去除重复的部分。
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneNumber {
    //规定名字与数字之间的映射表
    private static final String TEMPLATE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String NUMBER =   "222333444555666777788899991234567890";
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //保存结果
        ArrayList<String> results =  new ArrayList<>();
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 0; i < n ; i++) {
                //接收公司名
                String name = in.next();
                //去掉公司名中的 "-"
                name = name.replace("-", "");
                //根据公司名和映射表获取电话号码
                String result = "";
                for (int j = 0; j < 7; j++) {
                    result += NUMBER.charAt(TEMPLATE.indexOf(name.charAt(j) + ""));
                }
                result = result.substring(0, 3) + "-" + result.substring(3, 7);

                //判断是否包含重复的号码
                if (!results.contains(result)) {
                    results.add(result);
                }
            }
            Collections.sort(results);
            for (int i = 0; i < results.size(); i++){
                System.out.println(results.get(i));
            }
            System.out.println();
        }
    }
}
