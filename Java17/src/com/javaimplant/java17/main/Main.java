package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.*;

@FunctionalInterface
interface IFaceA{
    void selMe();
    default void selMeA(){
        System.out.println("Hi There");
    }
    static void selMeB(){
        System.out.println("Next method");
    }
}

public class Main implements IFaceA, IFaceC {
    public static void main(String[] args) {
        firstMethod();
        secondMethod();
        thirdMethod();
        fourthMethod();
        fifthMethod();
        sixthMethod();
        AbstractClassImplementation();
        FunctionalInterfaceWithReturn();
        InterfaceExtensionExample();
    }

    private static void InterfaceExtensionExample() {
        IFaceF facf=(a,b)->{
            System.out.println(a.toUpperCase()+" "+b.toUpperCase());
        };
        IFaceF facLambda = (a,b)->System.out.println(a.toUpperCase()+" "+b.toUpperCase());
        facLambda.method("Matta","G");
        facf.method("Gaurav","M");
        facf.method1();
        facf.method2();
    }

    private static void FunctionalInterfaceWithReturn() {
        IFaceD facd=(String a)->{
         StringBuilder strb = new StringBuilder(a);
         String t = strb.reverse().toString();
         return t;
        };
        String j = "Anonymous types are complex to read i prefer lambdas as they sound simple to write but difficult to read";
        System.out.printf("%S\n",facd.retrev(j));
    }

    private static void AbstractClassImplementation() {
        MyBaseCls cls=new MyBaseCls() {
            @Override
            public void myMethC() {
                System.out.println("My method of abstract class");
            }
        };
        cls.myMethC();
    }

    private static void sixthMethod() {
        IFaceC fact=()->{
            for(int i=1;i<=10;i++){
                System.out.println("Log("+i+")="+Math.log(i));
            }
        };
        fact.prn10Logs();
    }

    private static void fifthMethod() {
        IFaceC fac = new IFaceC() {
            @Override
            public void prn10Logs() {
                for(int i=1;i<10;i++){
                    System.out.println("Log("+i+")="+Math.log(i));
                }
            }
        };
        fac.prn10Logs();
    }

    private static void fourthMethod() {
        Main a = new Main();
        a.prn10Logs();
    }

    private static void thirdMethod() {
        IFaceB faceB = (a)->System.out.println(a.toUpperCase());
        faceB.testerA("gaurav");
    }

    private static void secondMethod() {
        //Anonymous Function
        IFaceB fac = new IFaceB() {
            @Override
            public void testerA(String a) {
                System.out.println(a.toUpperCase());
            }
        };
        fac.testerA("gaurav");
    }

    private static void firstMethod() {
        Main a = new Main();
        a.selMe();
        a.selMeA();
        a.prn10Logs();
        IFaceA.selMeB();
    }

    @Override
    public void selMe() {
        System.out.println("I am a sel me method");
    }

    @Override
    public void prn10Logs() {
        for(int i=1;i<10;i++){
            System.out.println("Log("+i+")="+Math.log(i));
        }
    }
}