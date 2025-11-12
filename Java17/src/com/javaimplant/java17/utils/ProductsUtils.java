package com.javaimplant.java17.utils;

import com.javaimplant.java17.db.utils.SharedConnection;
import com.javaimplant.java17.records.Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsUtils extends SharedConnection {
    public List<Products> retPList(){
        List<Products> lp=new ArrayList<Products>();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(queryProds);
            while(rs.next()) {
                var p=new Products(rs.getInt(1), rs.getString(2), rs.getInt(3));
                lp.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }
}
