package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.DefaultMethodsExample;
import com.javaimplant.java17.interfaces.IFaceI;
import com.javaimplant.java17.interfaces.ILeft;
import com.javaimplant.java17.interfaces.IRight;

public class DefaultMethodInterfaceHandler implements ILeft, IRight, IFaceI {
    public static void main(String[] args) {
        DefaultMethodsExample example = new DefaultMethodsExample() {
            @Override
            public void metha() {
                System.out.println("I am overriden");
            }

            @Override
            public void metha(int a) {
                System.out.println("Overloaded and Overridden at the same time");
            }
        };
        example.metha();
        example.metha(10);
        DefaultMethodInterfaceHandler dh = new DefaultMethodInterfaceHandler();
        dh.m1();
        dh.m2();
        IFaceI.revStr("Gaurav");
    }

    @Override
    public void m1() {
        System.out.println("After Overriding ");
        ILeft.super.m1();
        IRight.super.m1();
    }

}
