package javaimplant.exceptions;

import java.io.FileNotFoundException;

public class Dog extends Animal {
	
	@Override
	public void issue() throws NullPointerException {
		throw new NullPointerException();
	}

	@Override
	public void issueUnchecked()  {
	}

	@Override
	public void issueChecked() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
}
