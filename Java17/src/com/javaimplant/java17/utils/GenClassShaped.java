package com.javaimplant.java17.utils;

import com.javaimplant.java17.models.BaseShape;

import java.util.List;

public class GenClassShaped {
    public static void draw3dShape(List<? extends BaseShape> l) {
        l.forEach(BaseShape::paintMe);
    }
}
