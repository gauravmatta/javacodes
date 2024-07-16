package javaimplant.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Animal {
	String name;
	
	public void issueUnchecked() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	public void issueChecked() throws IOException {
		throw new IOException();
	}
	
	public void issue() {
		
	}
}
