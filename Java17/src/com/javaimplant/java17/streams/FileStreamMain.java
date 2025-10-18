package com.javaimplant.java17.streams;

import com.javaimplant.java17.streams.interfaces.FileInterface;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class FileStreamMain implements FileInterface {
    public static void main(String[] args) throws IOException {
        fileCreator();
        fileConsumer();
        fileConsumerR();
    }

    private static void fileConsumer() throws IOException {
        FileInputStream fis=new FileInputStream(new File(filePath));
        int a=0;
        String fin="";
        while((a=fis.read())!=-1) {
            fin = fin + (char) a;
        }
        fis.close();
        System.out.println("File read successfully");
        secWay(fin);
        firstWay(fin);
        thirdWay(fin);
    }

    private static void fileConsumerR() throws IOException {
        FileReader reader=new FileReader(new File(filePath));
        int b=0;
        String h="";
        while((b=reader.read())!=-1) {
            h+=(char)b;
        }
        Arrays.asList(h.split(":")).forEach(n->{
            System.out.println(n.stripLeading());
        });
    }

    private static void thirdWay(String fin) {
        Arrays.asList(fin.split(":")).forEach(System.out::println);
    }

    private static void secWay(String fin) {
        StringTokenizer stk=new StringTokenizer(fin, ":");
        while(stk.hasMoreTokens()) {
            String u=stk.nextToken();
            System.err.println(u.toUpperCase());
        }
    }

    private static void firstWay(String fin) {
        String[] sArr = fin.split(":");
        Arrays.asList(sArr).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });
    }



    private static void fileCreator() throws IOException {
        System.out.println("File path is: " + filePath);
        FileOutputStream fos =new FileOutputStream(new File(filePath));
        String str="";
        for(int i=0;i<1000;i++){
            str+="Log("+i+")="+Math.log(i)+":";
        }
        fos.write(str.getBytes());
        fos.flush();
        fos.close();
        System.out.println("File written successfully");
    }
}
