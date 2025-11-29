package com.javaimplant.java17.tools;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassA implements Serializable {
    Connection conn = null;
    public ClassA() {
        System.out.println("ClassA: Constructor called");
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/deltajavad", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void methA() {
        System.out.println("ClassA: methA called");
    }
}
