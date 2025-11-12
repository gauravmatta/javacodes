package com.javaimplant.java17.models;

import java.util.List;

public class GenClassShaped {
    public static void draw3dShape(List<? extends BaseShape> l) {
        l.stream().forEach(n->{
            n.paintMe();
        });
    }
}
