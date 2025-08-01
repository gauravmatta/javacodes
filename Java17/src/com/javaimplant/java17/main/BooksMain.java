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
        for(Books b:libo){
            bu.prnStatus(predBookd,b);
            bu.drawLine();
            bu.prnStatus(predBookb,b);
        }
    }
}
