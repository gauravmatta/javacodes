package com.javaimplant.java17.db.consts;

public interface DbConsts {
    String className="com.mysql.cj.jdbc.Driver";
    String username="root";
    String password="";
    String dbConn="jdbc:mysql://localhost:3306/deltajavad";
    String queryBooks="select * from bookstab";
    String queryBooksa="select * from bookstab where id=?";
    String queryPera="select * from perview";
    String queryProds="select * from tblproducts";
}