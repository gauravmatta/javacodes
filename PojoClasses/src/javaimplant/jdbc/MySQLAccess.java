/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaimplant.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.transaction.xa.Xid;

/**
 *
 * @author Gaurav Matta
 */
public class MySQLAccess implements Xid{
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    protected int formatid;
    protected byte gtrid[];
    protected byte bqual[];

    public MySQLAccess(int formatid, byte[] gtrid, byte[] bqual) {
        this.formatid = formatid;
        this.gtrid = gtrid;
        this.bqual = bqual;
    }
    
    public MySQLAccess()
    {
        
    }
    
    @Override
    public int getFormatId() {
        return formatid;
    }

    @Override
    public byte[] getGlobalTransactionId() {
        return gtrid;
    }

    @Override
    public byte[] getBranchQualifier() {
       return bqual;
    }
    
    public DataSource getDataSource() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=root&password=");
        connect.setAutoCommit(false);
        statement=connect.createStatement();
        String sql="insert into comments (id,MYUSER,EMAIL,WEBPAGE,DATUM,SUMMARY,COMMENTS) values ('2','rajesh','kaka@gmail.com','kaka.com','2009-09-14','Webpage','Test')";
        statement.executeUpdate(sql);
        connect.commit();
        connect.close();
        return null;
    }
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException
    {
       MySQLAccess msa=new MySQLAccess();
       msa.getDataSource();
    }
}
