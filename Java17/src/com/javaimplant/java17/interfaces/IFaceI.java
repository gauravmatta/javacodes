package com.javaimplant.java17.interfaces;

public interface IFaceI {
    static void revStr(String h){
        System.out.println(new StringBuffer(h).reverse().toString());
    }
}
