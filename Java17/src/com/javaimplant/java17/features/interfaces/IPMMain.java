package com.javaimplant.java17.features.interfaces;

public class IPMMain implements InterfaceWithPrivateMethods{

    public void addNums(){
        int aa = addEvens(1,2,3,4,5,6,7,8,9,10);
        int ab = addOdds(1,2,3,4,5,6,7,8,9,10);
        int ac = addGreaterThanFive(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Sum of Evens: "+aa);
        System.out.println("Sum of Odds: "+ab);
        System.out.println("Sum of Greater than Five: "+ac);
    }

    static void main() {
        IPMMain ipmm = new IPMMain();
        ipmm.addNums();
    }
}
