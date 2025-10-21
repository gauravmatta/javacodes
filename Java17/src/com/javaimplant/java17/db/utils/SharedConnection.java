package com.javaimplant.java17.db.utils;

import com.javaimplant.java17.db.consts.DbConsts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SharedConnection implements DbConsts {
    static Connection conn=null;
    static {
        try {
            Class.forName(className);
            conn= DriverManager.getConnection(dbConn, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}