package com.javaimplant.java17.main;

import com.javaimplant.java17.consumers.BooksConsumer;
import com.javaimplant.java17.records.Books;
import com.javaimplant.java17.records.Person;
import com.javaimplant.java17.records.PersonBooks;
import com.javaimplant.java17.utils.BookUtils;
import com.javaimplant.java17.utils.PersonBookUtils;
import com.javaimplant.java17.utils.PersonUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class RecordsMain {
    private static BookUtils helper =new BookUtils();
    private static PersonUtil phelper=new PersonUtil();
    private static PersonBookUtils pbhelper=new PersonBookUtils();
    public static void main(String[] args) throws SQLException {
        recordsInitialization();
        methQuery();
        viewPersons();
        personBooks();
    }

    private static void recordsInitialization() {
        Books b= new Books(21,"Java 17 Features","John Doe");
        System.out.println(b);
        String j="ID is "+b.id()+" , Name is "+b.name()+" , Author is "+b.author();
        System.out.println(j);
        var pReca=new Person(10, "Sunidhi Chauhan", "Chauhan@wood.com","9998887776");
        System.out.println(pReca.toString());
        System.out.println(String.format("Id:%d\tName:%s\tEmail%s", pReca.pid(),pReca.pname(),pReca.pemail()));
    }

    private static void personBooks() throws SQLException {
        List<PersonBooks> lp=pbhelper.retViewList();
        for(PersonBooks p:lp) {
            System.out.println(p.toString());
        }
    }

    private static void viewPersons() throws SQLException {
        phelper.retViewList().stream().forEach(new Consumer<Person>() {
            @Override
            public void accept(Person t) {
                if(!(t.pname().startsWith("r")))
                    System.out.println(t.toString());
            }
        });
    }

    private static void methQuery() {
        try {
            Scanner scan=new Scanner(System.in);
            int a=0;
            System.out.println("Enter 1 to view all records or 2 to view one record");
            a=Integer.parseInt(scan.nextLine());
            if(a==1) {
                prnBooksDb();
            }else if(a==2){
                System.out.println("Enter the id of record you want to enter");
                int b=Integer.parseInt(scan.nextLine());
                prnBooksDb(b);
            }else {
                System.out.println("Invalid choice");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prnBooksDb() throws SQLException {
        List<Books> lsBooks=helper.retBookRecords();
        BooksConsumer bc=new BooksConsumer();
        lsBooks.stream().forEach(bc);
    }

    private static void prnBooksDb(int a) throws SQLException {
        List<Books> lsBooks=helper.retBookRecord(a);
        BooksConsumer bc=new BooksConsumer();
        lsBooks.stream().forEach(bc);
    }
}
