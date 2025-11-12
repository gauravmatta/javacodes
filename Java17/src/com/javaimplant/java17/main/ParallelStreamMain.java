package com.javaimplant.java17.main;

import com.javaimplant.java17.db.utils.LoginsSpHelper;
import com.javaimplant.java17.models.Books;
import com.javaimplant.java17.utils.BookUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamMain {
    private static BookUtils helper=new BookUtils();
    private static LoginsSpHelper lhelper=new LoginsSpHelper();
    public static void main(String[] args) throws SQLException {
        mainMeth();
    }

    private static void mainMeth() throws SQLException {
        Integer[] arr= {21,22,23,24,25,26,27,28,29,30};
        Stream<Integer> stra= Arrays.asList(arr).stream();
        useStream(stra);
        drawLine();
        var strb=Arrays.asList(arr).parallelStream();
        usePStreams(strb);
        drawLine();
        String[] arr2= {"Physics","Remote sensing","Geo physics","Petrology","Rock sciences"};
        Stream<String> strc=Arrays.asList(arr2).stream();
        strStreams(strc);
        drawLine();
        var strd=Arrays.asList(arr2).parallelStream();
        strPStreams(strd);
        drawLine();
        List<Books> lb=helper.retBooks();
        norBookStr(lb);
        drawLine();
        parStreamsBooks(lb);
        drawLine();
        strLogins();
        drawLine();
        parStreamLogins();
        drawLine();
    }

    private static void drawLine() {
        System.out.println("*".repeat(50));
    }

    private static void parStreamLogins() throws SQLException {
        lhelper.retLogins().parallelStream().forEach(System.out::println);
    }

    private static void strLogins() throws SQLException {
        lhelper.retLogins().stream().forEach(System.out::println);
    }

    private static void parStreamsBooks(List<Books> lb) {
        lb.parallelStream().forEach(n->{
            System.out.println(n.toString());
        });
    }

    private static void norBookStr(List<Books> lb) {
        lb.forEach(n->{
            System.out.println(n.toString());
        });
    }


    private static void strPStreams(Stream<String> strd) {
        strd.forEach(System.out::println);
    }

    private static void strStreams(Stream<String> strc) {
        strc.forEach(System.out::println);
    }

    private static void usePStreams(Stream<Integer> strb) {
        strb.forEach(System.out::println);
    }

    private static void useStream(Stream<Integer> stra) {
        stra.forEach(System.out::println);
    }
}
