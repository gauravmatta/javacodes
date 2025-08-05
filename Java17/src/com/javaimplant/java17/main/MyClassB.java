package com.javaimplant.java17.main;

public class MyClassB {
    private String name;
    private String brand;

    public MyClassB(String name, String brand) {
        this.name = name;
        this.brand = brand;
        String fin=String.format("MyClassB created with name: %s and brand: %s", this.name, this.brand);
        System.out.println(fin);
    }
}
