package main02;

import java.util.*;

/**
 * 问题描述:开发一个简单记录功能小模块,能够记录出出错的代码所在的文件
 * 名称和行号.
 * 处理:
 * 1.记录最多8条错误记录,对相同的错误记录(即文件名称和行号完全匹配)只
 * 记录一条,错误计数增加;(文件所在的目录不同,文件名和行号相同也要合并)
 * 2.超出16个字符的文件名称,只记录文件的最后有效16个字符;(如果文件名
 * 不同,而只是文件名的后16个字符和行号相同,也不要合并)
 * 3.输入的文件可能带路径,记录文件名称不能带路径
 *
 * 输入描述:
 * 一行或多行字符串.每行包括带路径文件名称,行号,以空格隔开.
 *    文件路径为windows格式.
 *    如: E:\VIR2\product\fpgadrive.c 1325
 *
 * 输出描述:
 * 将所有记录统计并将结果输出,格式:文件名 代码行数 数目,一个空格隔开,如:
 * fpgadrive.c 1325 1
 * 结果根据数目从多到少排序, 数目相同的情况下, 按照输入第一次出现顺序排序.
 * 如果超过8条记录,则只输出前8条记录.
 * 如果文件名的长度超过16个字符,则只输出后16个字符
 *
 *输入:
 * E:\V1R2\product\fpgadrive.c 1325
 *
 *输出:
 * fpgadrive.c 1325 1
 *
 */

public class Main {



    //定义一个 Error 类
    private static class Error implements Comparable<Error>{
        private String name;
        private int lineNum;
        private int count;

        @Override
        public int compareTo(Error o) {
            return o.count - this.count;
        }

        public Error(String name, int lineNum){
            this.name = name;
            this.lineNum = lineNum;
        }

        public int getCount(){
            return count;
        }

        public void setCount(int count){
            this.count = count;
        }
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        ArrayList<Error> list = new ArrayList<>();
        String fileName = null;
        int lineNum = 0;
        int length = 0;
        int i = 0;
        //录入文件信息
        while (in.hasNext()) {
            fileName = in.next();
            lineNum = in.nextInt();
            //获取最后一个 \ 的位置
            int index = fileName.lastIndexOf("\\");
            fileName = fileName.substring(index + 1);
            //获取已存错误记录的个数
            length = list.size();
            //遍历 list,判断是否已保存该错误信息
            for (i = 0; i < length; i++){
                Error error = list.get(i);
                //若已存在相似的错误信息,更新错误数量,并跳出循环
                if (error.name.equals(fileName) && error.lineNum == lineNum){
                    error.setCount(error.getCount() + 1);
                    break;

                }
            }

            //若不存在该错误信息,将该错误信息插入 list
            if (i == length){
                Error error = new Error(fileName, lineNum);
                error.setCount(1);
                list.add(error);

            }
        }
        in.close();
        //归并排序
        length = list.size();
        if (length > 8){
            length = 8;
        }
        mergeSort(list, 0, length);

        //打印结果
        for (i = 0; i < length; i++){
            Error error = list.get(i);
            String name = error.name;
            int size = name.length();
            if (size > 16){
                name = name.substring(name.length() - 16);
            }
            System.out.println(name + " " + error.lineNum + " " + error.count);
        }

    }

    private static void mergeSort(ArrayList<Error> list, int left, int right){
        if (left + 1 >= right){
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid, right);
        merge(list, left, mid, right);
    }

    private static void merge(ArrayList<Error> list, int left, int mid, int right) {
        int low = left;
        int high = mid;
        int  length = right - left;
        ArrayList<Error> tempList = new ArrayList<>();
        while (low < mid && high < right){
            if (list.get(low).compareTo(list.get(high)) <= 0){
                Error error = new Error(list.get(low).name,list.get(low).lineNum);
                error.count = list.get(low).count;
                tempList.add(error);
                low++;
            }else{
                Error error = new Error(list.get(high).name,list.get(high).lineNum);
                error.count = list.get(high).count;
                tempList.add(error);
                high++;
            }
        }

        while (low <  mid){
            Error error = new Error(list.get(low).name,list.get(low).lineNum);
            error.count = list.get(low).count;
            tempList.add(error);
            low++;
        }

        while (high < right){
            Error error = new Error(list.get(high).name,list.get(high).lineNum);
            error.count = list.get(high).count;
            tempList.add(error);
            high++;
        }

        for (int i = 0; i < length; i++){
            Error error = list.get(left + i);
            error.name = tempList.get(i).name;
            error.lineNum = tempList.get(i).lineNum;
            error.count = tempList.get(i).count;
        }
    }


}
