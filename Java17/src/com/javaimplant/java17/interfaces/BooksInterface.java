package com.javaimplant.java17.interfaces;

import com.javaimplant.java17.models.Books;

import java.util.Collection;
import java.util.function.Predicate;

public interface BooksInterface {
    Predicate<Books> predBooka=(a)->a.getId()>3;
    Predicate<Books> predBookb=(a)->(a.getAuthor().startsWith("V")||a.getAuthor().startsWith("J"));
    Predicate<Books> predBookc=(a)->a.getId()%2==0;
    Predicate<Books> predBookd=(a)->a.equals(null);
    Predicate<Collection<Books>> predBooke=(a)->a.isEmpty();

}
