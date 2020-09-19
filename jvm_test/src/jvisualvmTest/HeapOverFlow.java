package jvisualvmTest;

import java.util.ArrayList;

public class HeapOverFlow {
    public static void main(String[] args){
        ArrayList<HeapOverFlow> list = new ArrayList<>();
        for (; ;){
            list.add(new HeapOverFlow());
            System.gc();
        }
    }
}
