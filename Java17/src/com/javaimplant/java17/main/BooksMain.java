package com.javaimplant.java17.main;

import com.javaimplant.java17.interfaces.BooksInterface;
import com.javaimplant.java17.models.Books;
import com.javaimplant.java17.utils.BookUtils;

import java.util.List;
import java.util.function.Predicate;

public class BooksMain implements BooksInterface {
    private static final BookUtils bu = new BookUtils();
    public static void main(String[] args) {
        List<Books> libo=bu.retBooks();
        predictesTest(libo);
        bu.drawLine();
        predictesTest2(libo);
        bu.drawLine();
        predictesTest3(libo);
        bu.drawLine();
        predictesTest4(libo);
        bu.drawLine();
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
}
