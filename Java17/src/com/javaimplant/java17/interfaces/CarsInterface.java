package com.javaimplant.java17.interfaces;

import com.javaimplant.java17.models.Cars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface CarsInterface {
    BiFunction<String,String, Cars> bifCar = Cars::new;
    Function<Cars,String> funCarA= Cars::toString;
    Function<List<Cars>,List<String>> funCarB=(a)->{
        List<String> li = new ArrayList<>();
        for(Iterator<Cars> iterator = a.iterator(); iterator.hasNext();){
            Cars cars = (Cars) iterator.next();
            li.add(cars.getCname());
        }
        return li;
    };
}