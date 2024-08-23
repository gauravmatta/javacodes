package javaimplant.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeInheritenceMain {

	public static void main(String[] args) {	
		String filename="employee.ser";
		serializeObject(filename);
		deserializeobject(filename);
	}
	
	private static void deserializeobject(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))){
			System.out.println("Object is deserialized...");
			Object object = ois.readObject();
			Employee employee = (Employee) object;
			System.out.println("ID:"+employee.getId());
			System.out.println("Name:"+employee.getName());
			System.out.println("Age:"+employee.getAge());
			System.out.println("Email:"+employee.getEmail());
			System.out.println("Password:"+employee.getPassword());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void serializeObject(String fileName) {
		Employee employee = new Employee();
		employee.setId(1001);
		employee.setName("Javaimplant");
		employee.setAge(30);
		employee.setEmail("java@Implant.com");
		employee.setPassword("pass@246");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
			oos.writeObject(employee);
			System.out.println("Object is serialized");
			System.out.println("-----------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}