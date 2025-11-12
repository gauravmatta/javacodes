package com.javaimplant.java17.main;

import com.javaimplant.java17.records.Books;
import com.javaimplant.java17.records.Person;
import com.javaimplant.java17.records.PersonBooks;
import com.javaimplant.java17.utils.BookUtils;
import com.javaimplant.java17.utils.PersonBookUtils;
import com.javaimplant.java17.utils.PersonUtil;

import java.sql.SQLException;
import java.util.List;

public class MethodGenericsMain {
    private static BookUtils helper =new BookUtils();
    private static PersonUtil phelper=new PersonUtil();
    private static PersonBookUtils pbhelper=new PersonBookUtils();
    public static void main(String[] args) throws SQLException {
        List<Books> lsBooks=helper.retBookRecords();
        List<Person> people = phelper.retViewList();
        List<PersonBooks> lp=pbhelper.retViewList();
        prnResults(lsBooks);
        prnResults(people);
        prnResults(lp);
    }

    public static<E> void prnResults(List<E> l){
        l.forEach(n->{
            System.out.println(n.toString());
        });
    }
}
