package com.Operation;
import com.Build.Libary;

public class ExitOperation implements Operation{
    public void work(Libary libary){
        System.out.println("再见!");
        System.exit(1);
    }

}
