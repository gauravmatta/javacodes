package com.javaimplant.java17.utils;

import com.javaimplant.java17.interfaces.CarsInterface;
import com.javaimplant.java17.models.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsUtils{

    public final String[] cNames = {"Model S", "Mustang", "Civic", "Camry", "Corolla"};
    public final String[] cBrands = {"Tesla", "Ford", "Honda", "Toyota", "Toyota"};
    private final List<Cars> carsList = new ArrayList<>();

    public List<Cars> retListCars() {
        for(int i=0; i < cBrands.length; i++) {
            Cars car = CarsInterface.bifCar.apply(cNames[i], cBrands[i]);
            carsList.add(car);
        }
        return carsList;
    }

    public Cars retCar(String a,String b) {
        return new Cars(a,b);
    }
}
