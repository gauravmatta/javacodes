package com.javaimplant.module.c;

import com.javaimplant.module.b.ClassLog;

public class UClass {
    static void main(String[] args) {
        System.out.println("UClass main: Hello from UClass in module c");
        for(int i=0;i<=args.length;i++){
          new ClassLog().callLog(Integer.toString(i));
        }
    }
}
