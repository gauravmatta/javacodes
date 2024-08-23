package javaimplant.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = -4608784905582638890L;
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private void writeObject(ObjectOutputStream oos) {
		try {
			oos.defaultWriteObject();
			oos.writeInt(getId());
			oos.writeObject(getName());
			oos.writeInt(getAge());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream ois) {
		try {
			ois.defaultReadObject();
			setId(ois.readInt());
			setName((String) ois.readObject());
			setAge(ois.readInt());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Employee [email=" + email + ", password=" + password + "]";
	}
	
	
	

}
