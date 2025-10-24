package com.javaimplant.java17.utils;

import com.javaimplant.java17.records.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.javaimplant.java17.db.consts.DbConsts.queryPera;
import static com.javaimplant.java17.db.utils.SharedConnection.conn;

public class PersonUtil {
    public static String formatPersonRecord(int pid, String pname, String pemail) {
        return "pid:" + pid + ", pname:" + pname + ", pemail:" + pemail;
    }

    public List<Person> retViewList() throws SQLException {
        List<Person> lp=new ArrayList<Person>();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(queryPera);
        while(rs.next()) {
            var pv=new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            lp.add(pv);
        }
        return lp;
    }
}
