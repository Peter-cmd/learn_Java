package com.test;

public class MyString {
    char value[];

    public MyString(char[] value){
        this.value = value;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        
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
}
