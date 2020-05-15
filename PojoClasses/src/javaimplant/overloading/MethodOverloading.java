package javaimplant.overloading;

public class MethodOverloading {
	
	public void method()
	{
		System.out.println("Rose");
	}
	
	public void method(String args)
	{
		System.out.println("Roses are "+args);
	}

	public static void main(String[] args) {
		MethodOverloading m=new MethodOverloading();
		m.method();
		m.method("Tulips");
	}
}
