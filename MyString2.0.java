package com.test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyString {
    char value[];

    public MyString(char[] value){
        this.value = value;
    }

    //模拟equals方法
    public boolean myEquals(Object obj){
        //直接比较两对象的身份是否相同
        if (this == obj){
            return true;
        }

        //实现两对象内容的比较
        if (obj instanceof MyString){
            MyString str = (MyString) obj;
            int n = this.value.length;
            if (n != str.value.length){
                return false;
            }else{
                char[] v1 = this.value;
                char[] v2 = str.value;
                int i = 0;
                while(n-- != 0){
                    if (v1[i] != v2[i]){
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    //模拟实现compareTo方法
    public int myCompareTo(MyString anotherString){
        int len1 = this.value.length;
        int len2 = anotherString.value.length;
        int lim = 0;
        if (len1 < len2){
            lim = len1;
        }else{
            lim = len2;
        }
        char[] v1 = this.value;
        char[] v2 = anotherString.value;
        for (int i = 0; i < lim; i++){
            if (v1[i] != v2[i]){
                return v1[i] - v2[i];
            }
        }
        return len1 - len2;
    }

    //模拟实现toCharArray方法
    public char[] myToCharArray(){
        char[] v = this.value;
        return v;
    }

    //模拟实现contains方法
    public boolean myContains(MyString subString){
        int len1 = this.value.length;
        int len2 = subString.value.length;
        char[] v1 = this.value;
        char[] v2 = subString.value;
        int tagV1 = 0;
        int tagV2;
        for (int i = 0; i < len1; i++){
            tagV2 = 0;
            if (v1[i] == v2[0]){  //若子串的第一个元素匹配成功
                tagV1 = i;  //记录此时i的位置
                while(tagV2 < len2 && i < len1){  //遍历子串,同时i向后移动
                    if (v1[i] != v2[tagV2]){
                        break;
                    }
                    tagV2++;
                    i++;
                }
                if (tagV2 == len2){  //匹配成功
                    return true;
                }
                i = tagV1;  //i回到子串遍历前的位置
            }
        }
        return false;
    }

    //模拟实现indexOf方法
    public int myIndexOf(MyString subString){
        int len1 = this.value.length;
        int len2 = subString.value.length;
        int tagV1 = 0;
        int tagV2;
        char[] v1 = this.value;
        char[] v2 = subString.value;
        //遍历v1数组
        for (int i = 0; i < len1; i++){
            if (v1[i] == v2[0]){
                tagV1 = i;
                tagV2 = 0;
                while (tagV2 < len2 && i < len1){
                    if (v1[i] != v2[tagV2]){
                        break;
                    }
                    tagV2++;
                    i++;
                }
                if (tagV2 == len2){
                    return tagV1;
                }
                i = tagV1;
            }

        }
        return -1;
    }

    //模拟实现lastIndexOf方法
    public int myLastIndexOf(MyString subString){
        int len1 = this.value.length;
        int len2 = subString.value.length;
        int tagV1 = len1 - 1;
        int tagV2;
        char[] v1 = this.value;
        char[] v2 = subString.value;
        for (int i = len1 - 1; i >= 0; i--){  //从后向前遍历v1
            if (v1[i] == v2[len2 - 1]){  //若子串第一个元素匹配成功
                tagV1 = i;
                tagV2 = len2 - 1;
                while(tagV2 >= 0 && i >= 0){  //若v1和v2都未遍历完
                    if (v1[i] != v2[tagV2]){  //若匹配失败
                        break;
                    }
                    tagV2--;  //遍历v2前一个元素
                    i--;  //遍历v1前一个元素
                }
                if (tagV2 == -1){  //若tagV2遍历结束
                    return tagV1;
                }
                i = tagV1;  //i返回子串遍历前的位置
            }
        }
        return -1;
    }

    //模拟实现replaceAll方法
    public String myReplaceAll(String str1, String str2){
        char[] v1 = str1.toCharArray();
        char[] v2 = str2.toCharArray();
        char[] v3 = this.value;

        int len1 = v1.length;
        int len2 = v2.length;
        int len3 = v3.length;

        int tagV1;
        int tagV2;
        int tagV3 = 0;

        for (int i = 0; i < len3; i++){
            if (v3[i] == v1[0]){
                tagV3 = i;
                tagV1 = 0;
                while (tagV1 < len1 && i < len3){
                    if (v3[i] != v1[tagV1]){
                        break;
                    }
                    tagV1++;
                    i++;
                }
                i = tagV3;
                tagV2 = 0;
                if (tagV1 == len1){
                    while(tagV2 < len2) {
                        v3[i] = v2[tagV2];
                        tagV2++;
                        i++;
                    }
                    i--;  //减掉多跳过的1次
                }
            }
        }
        return new String(v3);
    }

    //模拟实现repalceFirst方法
    public String myReplaceFirst(String str1, String str2){
        char[] v1 = str1.toCharArray();
        char[] v2 = str2.toCharArray();
        char[] v3 = this.value;

        int len1 = v1.length;
        int len2 = v2.length;
        int len3 = v3.length;

        int tagV1;
        int tagV2;
        int tagV3 = 0;

        for (int i = 0; i < len3; i++){
            if (v3[i] == v1[0]){  //若v1的第一个元素匹配成功
                tagV3 = i;  //记录此时i的位置
                tagV1 = 0;
                //匹配子串的每一个元素
                while (tagV1 < len1 && i < len3){
                    if (v3[i] != v1[tagV1]){
                        break;
                    }
                    tagV1++;
                    i++;
                }
                i = tagV3;  //i回到子串匹配前的位置
                tagV2 = 0;  //tagV2置零
                //子串匹配成功
                if (tagV1 == len1){
                    while(tagV2 < len2) {
                        v3[i] = v2[tagV2];
                        tagV2++;
                        i++;
                    }
                    return new String(v3);
                }
            }
        }
        return new String(v3);
    }

    //模拟实现subString方法
    public MyString mySubString(int begin, int end){
        int len1 = this.value.length;
        int len2 = end - begin;
        char[] v1 = this.value;
        char[] v2 = new char[len2];
        int i = 0;
        //判定起始和结束的范围是否合法
        if (len2 < 0 || begin < 0 || end < 0 || end > len1){
            return null;
        }
        //拷贝起始和结束范围内的元素
        for (; begin < end; begin++){
            v2[i] = v1[begin];
            i++;
        }
        return new MyString(v2);
    }


    //模拟实现split方法
    public MyString[] mySplit(MyString splitChar){
        int len1 = this.value.length;
        int len2 = splitChar.value.length;
        char[] v1 = this.value;
        char[] v2 = splitChar.value;
        //匹配的子串只能有一个字符
        if (len2 > 1){
            return null;
        }
        int begin = 0;
        int end = 0;
        ArrayList<MyString> list = new ArrayList<>();
        //遍历数组v1
        for (int i = 0; i < len1; i++){
            end = i;
            if (v1[i] == v2[0]){
                if (begin == end){  //处理字符串开头有N个匹配字符的情况
                    begin = end + 1;
                    continue;
                }
                list.add(mySubString(begin,end));  //将分隔的子串存入list
                begin = end + 1;  //跳过分隔用得子串
            }
        }
        //若最后一个元素不是分隔子串
        if (begin != end + 1){
            list.add(mySubString(begin,end + 1));
        }
        int listSize = list.size();  //获取list的长度
        MyString[] strings = new MyString[listSize];  //创建一个MyString类的数组
        return list.toArray(strings);  //将list转为MySring类的数组并返回
    }

    //模拟实现trim方法
    public MyString myTrim(){
        int len = this.value.length;
        int strBegin = 0;
        int strEnd = len - 1;
        char[] v = this.value;
        while (strBegin < len && v[strBegin] <= ' '){
            strBegin++;
        }
        while (strEnd > 0 && v[strEnd] <= ' '){
            strEnd--;
        }
        //若字符串中所有元素不为空
        if (strBegin < strEnd){
            return this.mySubString(strBegin,strEnd + 1);  //mySubString方法切割效果为[strBegin,strEnd + 1)
        }
        return null;
    }

    //模拟实现length方法
    public int length(){
        return this.value.length;
    }

    //模拟实现isEmpty方法
    public boolean isEmpty(){
        return this.value.length == 0;
    }
}
