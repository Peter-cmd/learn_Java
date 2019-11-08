package com.operation;
import com.build.Libary;

public class ExitOperation implements Operation{
    public void work(Libary libary){
        System.out.println("再见!");
        System.exit(1);
    }

}