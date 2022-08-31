package javaimplant.serialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	}

}
