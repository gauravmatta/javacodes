package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.BooksInterface;
import com.javaimplant.java17.models.Books;
import com.javaimplant.java17.utils.BookUtils;

import java.util.List;
import java.util.function.Predicate;

public class BooksMain implements BooksInterface {
    private static final BookUtils bu = new BookUtils();
    List<Books> libo=bu.retBooks();

    public static void main(String[] args) {
        BooksMain bm = new BooksMain();
        bm.predicatesCall();
        predicatesJoin();
    }

    private static void predicatesJoin() {
        int[] arr = {0,5,10,15,20,25,30,35,40,45,50};
        for(int i: arr){
            bu.prnStatus(predFirst, i);
        }
        bu.drawLine();
        for(int i: arr){
            bu.prnStatus(predSecond, i);
        }
        bu.drawLine();
        for(int i: arr){
            bu.prnStatus(predFirst.and(predSecond), i);
        }
        bu.drawLine();
        for(int i: arr){
            bu.prnStatus(predFirst.or(predSecond), i);
        }
        bu.drawLine();
        for(int i: arr){
            bu.prnStatus(predFirst.negate(), i);
        }
        bu.drawLine();
        for(int i: arr){
            bu.prnStatus(predSecond.negate(), i);
        }
        bu.drawLine();
        boolean predicateStringResult = predThird.test("Gaurav is Implanting Java 17");
        System.out.println("Predicate String Result: " + predicateStringResult);
        bu.drawLine();
    }

    private void predicatesCall() {
        predictesTest(libo);
        bu.drawLine();
        predictesTest2(libo);
        bu.drawLine();
        predictesTest3(libo);
        bu.drawLine();
        predictesTest4(libo);
        bu.drawLine();
        predictesTest5(libo);
    }

    private static void predictesTest(List<Books> libo) {
        for(Books b: libo){
            bu.prnStatus(predBookd,b);
        }
    }
    private static void predictesTest2(List<Books> libo) {
        for(Books b: libo){
            bu.prnStatus(predBooka,b);
        }
    }

    private static void predictesTest3(List<Books> libo) {
        for(Books b: libo){
            bu.prnStatus(predBookb,b);
        }
    }

    private static void predictesTest4(List<Books> libo) {
        for(Books b: libo){
            bu.prnStatus(predBookc,b);
        }
    }

    private static void predictesTest5(List<Books> libo) {
        boolean d = predBooke.test(libo);
        System.out.println("The collection is empty: " + d);
    }
}
