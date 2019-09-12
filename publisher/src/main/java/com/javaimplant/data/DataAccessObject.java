package com.javaimplant.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class DataAccessObject {
	private static DataSource datasource;
	private Object idLock=new Object();
}
