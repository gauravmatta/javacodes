package jniapplication;

public class JniMainApp {
	
	static {
		System.loadLibrary("native-lib");
	}
	
	private native void hello(String name);

	public static void main(String[] args) {
		new JniMainApp().hello("Java Implant");
	}

}
