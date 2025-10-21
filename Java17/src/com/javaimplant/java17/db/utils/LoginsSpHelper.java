package com.javaimplant.java17.db.utils;

import com.javaimplant.java17.db.records.Logins;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginsSpHelper extends SharedConnection {
    public List<Logins> retLogins() throws SQLException {
        List<Logins> ll=new ArrayList<Logins>();
        CallableStatement cs=conn.prepareCall("CALL splogins()");
        ResultSet rs=cs.executeQuery();
        while(rs.next()) {
            Logins l=new Logins(rs.getString(1), rs.getString(2));
            ll.add(l);
        }
        return ll;
    }


}
