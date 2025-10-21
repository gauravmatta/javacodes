package com.javaimplant.java17.db.main;

import com.javaimplant.java17.db.records.Logins;
import com.javaimplant.java17.db.utils.LoginsSpHelper;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LoginMain {
    private static final LoginsSpHelper lhelper=new LoginsSpHelper();
    public static void main(String[] args) throws SQLException {
        List<Logins> lu =lhelper.retLogins();
        lu.stream().forEach((e)->{
            String fin=String.format("username:%s\npassword:%s\n", e.username(),e.password());
            System.out.println(fin);
        });
        lu.stream().filter(n->n.username().endsWith("0")).forEach(System.out::println);
        List<String> lia = lu.stream().map(Logins::username).toList();
        for(String s:lia){
            System.out.println(s);
        }
        lu.stream().map(n->n.username().toUpperCase()+" "+n.password().toLowerCase()).forEach(System.out::println);
        lu.stream().map(n->n.username().length()).forEach(System.out::println);
        lu.stream().sorted((a,b)->a.username().compareTo(b.username())).forEach(System.out::println);
        lu.stream().sorted((a,b)->b.username().compareTo(a.username())).forEach(System.out::println);
        System.out.println(" Count of Objects"+lu.stream().count());
        //Find Length of distinct Usernames
        lu.stream().map(n->n.username().length()).distinct().forEach(System.out::println);
        lu.stream().map(n->n.username().length()+" "+n.password().length()).forEach(System.out::println);
        Function<Integer, String> drawLine=(s)->"*".repeat(s);
        System.out.println(drawLine.apply(50));
        Consumer<Logins> cl=new Consumer<Logins>() {
            @Override
            public void accept(Logins t) {
                String fin=String.format("username:%s\npassword:%s\n", t.username(),t.password());
                System.out.println(fin);
                System.out.println(drawLine.apply(50));
            }
        };
        lhelper.retLogins().stream().forEach(cl);
    }
}
