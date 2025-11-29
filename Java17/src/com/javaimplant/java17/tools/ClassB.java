package com.javaimplant.java17.tools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassB extends ClassA {

    public ClassB() {
        System.out.println("ClassB: Constructor called");
        super();
    }

    public List<String> getData() {
        System.out.println("ClassB: getData called");
       List<String> ls = new ArrayList<>();
         try(Statement stmt = conn.createStatement()) {
              ResultSet rs = stmt.executeQuery("SELECT author,name FROM Books");
              while (rs.next()) {
                ls.add(rs.getString("name") +"==>"+rs.getString("author"));
              }
         } catch (SQLException e) {
              e.printStackTrace();
         }
         return ls;
    }
}
