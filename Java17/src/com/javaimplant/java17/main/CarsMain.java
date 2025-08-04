package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.CarsInterface;
import com.javaimplant.java17.models.Cars;
import com.javaimplant.java17.utils.CarsUtils;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CarsMain implements CarsInterface {
    public static void main(String[] args) {
        // This is the main method where you can test the CarsInterface and Cars classes.
        CarsUtils carsUtil = new CarsUtils();
        bifCarTest(carsUtil);
        listTestCars(carsUtil);
        ListIterator<Cars> carsListIterator = carsUtil.retListCars().listIterator();
        while(carsListIterator.hasNext()){
            System.out.println(funCarA.apply(carsListIterator.next()));
        }
    }

    private static void listTestCars(CarsUtils carsUtil) {
        List<String> carNames = CarsInterface.funCarB.apply(carsUtil.retListCars());
        for(String carName : carNames) {
            System.out.println(carName);
        }
    }

    private static void bifCarTest(CarsUtils carsUtil) {
        String[] arr1= carsUtil.cNames;
        String[] arr2= carsUtil.cBrands;
        for(int i = 0; i < arr1.length; i++) {
            // Create a car using the bifCar BiFunction
            Cars car = CarsInterface.bifCar.apply(arr1[i], arr2[i]);
            // Print the car details using the funCarA Function
            System.out.println(CarsInterface.funCarA.apply(car));
        }
    }
}
