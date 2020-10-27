package main;

import child.Child;
import deserializable.MyDeserializable;
import serializable.MySerializable;

import java.io.IOException;
import java.io.Serializable;


public class Main {
    final static String baseName = "E:\\Idea\\workspaces\\demo\\serializable_test\\src\\file\\";
    final static String fileName = "t1.txt";
    public static void main(String[] args) {
        Child child = new Child();
        MyDeserializable<Child> deserializable = new MyDeserializable<>();
        MySerializable<Child> serializable = new MySerializable<>();
        try {
            deserializable.deserializable(baseName, fileName, child);
            Child child1 = serializable.serializable(baseName, fileName, child);
            System.out.println(child1.b);
            System.out.println(child1.a);

        } catch (IOException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
