package com.javaimplant.java17.main;

import com.javaimplant.java17.models.Cube;
import com.javaimplant.java17.models.Cuboid;
import com.javaimplant.java17.models.GenClassShaped;
import com.javaimplant.java17.models.Octahedron;

import java.util.ArrayList;
import java.util.List;

public class ShapesMain {
    static int[] arr1 = { 1, 2, 3, 4, 5 };
    static int[] arr2 = { 11, 12, 13, 14, 15 };
    public static void main(String[] args) {
        GenClassShaped.draw3dShape(retOcta());
        GenClassShaped.draw3dShape(retCubes());
        GenClassShaped.draw3dShape(retCuboid());
        List<Integer> li= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
			li.add(i+1);
		}
        System.out.println(addNums(li));
        List<Float> lf= new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			lf.add(i+1.111f);
		}
        System.out.println(addNums(lf));
        List<Double> ld=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ld.add(i+1.54545455454);
		}
        System.out.println(addNums(ld));
        List<Long> ll=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ll.add(i+11L);
        }
        System.out.println(addNums(ll));
    }

    public static List<Cube> retCubes(){
        List<Cube> li=new ArrayList<Cube>();
        for (int j : arr1) {
            Cube c = new Cube();
            c.setSide(j);
            li.add(c);
        }
        return li;
    }

    public static List<Cuboid> retCuboid(){
        List<Cuboid> li=new ArrayList<Cuboid>();
        for (int i = 0; i < arr1.length; i++) {
            Cuboid c=new Cuboid();
            c.setLen(arr1[i]);
            c.setHght(arr2[i]);
            li.add(c);
        }
        return li;
    }

    public static List<Octahedron> retOcta(){
        List<Octahedron> li=new ArrayList<>();
        for (int j : arr1) {
            Octahedron c = new Octahedron();
            c.setSide(j);
            li.add(c);
        }
        return li;
    }

    static double sum=0.0;
    public static Double addNums(List<? extends Number> l) {
        l.forEach(n->{
            sum=sum+n.doubleValue();
        });
        return sum;
    }
}
