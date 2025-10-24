package com.javaimplant.java17.db.consts;

public interface DbConsts {
    String className="com.mysql.cj.jdbc.Driver";
    String username="root";
    String password="";
    String dbConn="jdbc:mysql://localhost:3306/deltajavad";
    String queryBooks="select * from Books";
    String queryBooksa="select * from Books where id=?";
    String queryPera="select * from Persons";
    String queryPerb="select * from perview";
    String queryProds="select * from tblproducts";
}