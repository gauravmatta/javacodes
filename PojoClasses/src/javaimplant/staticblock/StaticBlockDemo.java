package javaimplant.staticblock;

public class StaticBlockDemo {

	static
	{
		System.out.println("Hello");
		// Shuts down JVM
//		System.exit(0);
	}
	
	static {
		System.out.println("I am second static Block");
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Main Called");

	}

}
