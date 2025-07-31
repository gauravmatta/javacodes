package com.javaimplant.java17.main;

interface interf{
    public void methodOne();
}

interface interfg{
    public void sum(int a,int b);
}

public class LambdaImplementationMain implements interf {

    public static void main(String[] args) {
        MethodOne();
        MethodTwo();
        interfg g =new interfg() {
            @Override
            public void sum(int a, int b) {
                System.out.println(a+b);
            }
        };
        System.out.println(g.getClass().getName());
        g.sum(21,22);
        interfg ga=(var a,var b)->{
            var p=100;
            System.out.println(a+b);
            System.out.println(p);
        };
        ga.sum(21,22);
        var a="This is a string";
        System.out.println(a);
        System.out.println(a.getClass().getName());
        var b = 10.545454545455f;
        System.out.println(b);
    }

    private static void MethodTwo() {
        interf f =()->System.out.println("This is with lambda");
        f.methodOne();
    }

    private static void MethodOne() {
        interf f = new LambdaImplementationMain();
        f.methodOne();
    }

    @Override
    public void methodOne() {
        int i=0;
        while(i<10){
            System.out.println("Sqr("+i+")="+Math.pow(i,2));
            i++;
        }
    }
}
