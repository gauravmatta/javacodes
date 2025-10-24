package com.javaimplant.java17.utils;

import com.javaimplant.java17.records.PersonBooks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.javaimplant.java17.db.consts.DbConsts.queryPerb;
import static com.javaimplant.java17.db.utils.SharedConnection.conn;

public class PersonBookUtils {

    public List<PersonBooks> retViewList() throws SQLException {
        List<PersonBooks> lp= new ArrayList<>();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(queryPerb);
        while(rs.next()) {
            var pv=new PersonBooks(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            lp.add(pv);
        }
        return lp;
    }
}
