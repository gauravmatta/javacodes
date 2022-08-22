package reflexion_api;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class Employee implements Serializable, Cloneable {
	public static int eno=1;
	static String ename = "Gaurav";
	public static String eaddr = "Delhi";
	
	public Employee() {
		
	}
	
	public Employee(int eno, String ename, String eaddr) throws ClassCastException,ArithmeticException {
		
	}
	
	public Employee(int eno, String ename) throws RemoteException,SQLException {
		
	}
	
	public Employee(int eno) throws InterruptedException {
		
	}
	
	public void add(String eno, String ename, String eaddr) throws ClassNotFoundException, ClassCastException {
		
	}
	
	public String search(int eno) throws ArithmeticException, InterruptedException {
		return null;
	}
	
	public void delete(int eno) throws SQLException {
		
	}
}
