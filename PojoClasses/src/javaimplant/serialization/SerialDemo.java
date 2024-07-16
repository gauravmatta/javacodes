package javaimplant.serialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javaimplant.records.Employee;

public class SerialDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Save objSave = new Save();
		objSave.i=4;
		
		File file = new File("javaimplant.txt");
		File file2 = new File("Object.txt");
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		try (DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
			dataOutputStream.writeUTF("Java Implant");
		}
		FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream2)) {
			objectOutputStream.writeObject(objSave);
		}
		
		FileInputStream fileInputStream =new FileInputStream(file);
		try (DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
			String string = dataInputStream.readUTF();
			System.out.println(string);
		}
		FileInputStream fileInputStream2 = new FileInputStream(file2);
		try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream2)) {
			Save objSave2 = (Save) objectInputStream.readObject();
			System.out.println("Value og obj"+ objSave2.i);
		}
		
		
		/*
		 * Try below with and without adding Serial Version UID in Employee Class
		 * comment deserializeObject method and run file
		 * now add a field to Employee class(change class)
		 * comment serializeObject method and uncomment deserializeObject method you will get Exception 
		 */
		String fileNameString = "employee.ser";
		serializeObject(fileNameString);
		deserializeObject(fileNameString);
	}
	
	private static void deserializeObject(String fileName) throws IOException, ClassNotFoundException {
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(fileName)))){
			Object object = objectInputStream.readObject();
			Employee employee = (Employee) object;
			System.out.println("Employee Object is Deserialized");
			System.out.println("ID:"+employee.employeeNumber());
			System.out.println("Name:"+employee.name());
			System.out.println("Email:"+employee.email());
			System.out.println("Employee Object is Deserialized");	
		}
	}
	
	private static void serializeObject(String fileName) throws IOException {
		Employee employee = new Employee.EmployeeBuilder()
				.employeeNumber(1001)
				.name("Java Implant")
				.mail("java@implant.com")
				.build();
		try(ObjectOutputStream objectOutputStream =new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
			objectOutputStream.writeObject(employee);
			System.out.println("Employee Object is Serialized");	
		}
	}

}
