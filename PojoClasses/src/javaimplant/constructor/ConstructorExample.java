package javaimplant.constructor;

public class ConstructorExample 
{
	private String name;

	public ConstructorExample() 
	{
		System.out.println("Please also initialize name");
	}

	public ConstructorExample(String name) {
		super();
		this.name = name;
		System.out.println("Initialized with name "+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		ConstructorExample c=new ConstructorExample("Gaurav");
	}
}
