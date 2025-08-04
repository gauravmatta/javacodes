package com.javaimplant.java17.main;

import com.javaimplant.java17.models.Cars;
import com.javaimplant.java17.models.MyClass;
import com.javaimplant.java17.utils.CarsUtils;

interface Greet{
    void wish();
}

interface GreetWithName {
    String wishName(String name);
}

interface GetCar{
    Cars getCar(String cname, String cBrand); // Method to get a car by name and brand
}

public class MethodReferenceMain {
    public static void main(String[] args) {
        // This is the main method where you can test the Method Reference functionality.
        System.out.println("Method Reference Main is running.");
        Greet g= MethodReferenceMain::myWish; // Method reference to myWish method
        g.wish();
        GreetWithName gn = MyClass::wishName; // Method reference to myWishName method
       System.out.println(gn.wishName("Java Implant"));
       CarsUtils carsUtils = new CarsUtils();
       GetCar getCar = carsUtils::retCar;
       Cars car = getCar.getCar("Model X", "Tesla"); // Using method reference to get a car
       System.out.println("Car Details: " + car);
    }

    public static void myWish() {
        System.out.println("Hello, this is a method reference example!");
    }
}
