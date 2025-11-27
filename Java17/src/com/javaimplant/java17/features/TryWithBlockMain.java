package com.javaimplant.java17.features;

import com.javaimplant.java17.features.interfaces.IConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithBlockMain implements IConstants {
    static void main() {
        System.out.println("App Name: " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("Paths: " + paths);
        System.out.println("User Home: " + USER_HOME);
        oldWay();
        newWay();
        customResourceJDK7();
        customResourceJDK9();
        MultipleResourceJDK9();
    }

    private static void MultipleResourceJDK9() {
        MyResource r1=new MyResource();
        MyResource r2=new MyResource();
        MyResource r3=new MyResource();
        MyResource r4=new MyResource();
        MyResource r5=new MyResource();
        try(r1;r2;r3;r4;r5){
            r1.doSomething();
            r2.doSomething();
            r3.doSomething();
            r4.doSomething();
            r5.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void customResourceJDK9() {
        MyResource r=new MyResource();
        try(r){
            r.doSomething();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void customResourceJDK7() {
        try(MyResource r=new MyResource()){
            r.doSomething();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void newWay() {
        try (BufferedReader br = new BufferedReader(new FileReader(paths))) {
            int j = 0;
            StringBuilder jj = new StringBuilder();
            while ((j = br.read()) != -1) {
                jj.append((char) j);
            }
            System.out.println(jj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void oldWay() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(paths));
            int j = 0;
            StringBuilder jj = new StringBuilder();
            while ((j = br.read()) != -1) {
                jj.append((char) j);
            }
            System.out.println(jj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
