package javaimplant.defaultstaticmethods;

public class DemoImpl implements Demo {
	
	@Override
	public void abc() {
		System.out.println("in abc");
	}

	public void show() {
		Demo.super.show();
		System.out.println("In new Show");
		Demo.mystatic();
	}
}
