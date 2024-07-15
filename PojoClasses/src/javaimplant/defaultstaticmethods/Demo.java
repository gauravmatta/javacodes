package javaimplant.defaultstaticmethods;

@FunctionalInterface
public interface Demo {
	void abc();
	default void show() {
		System.out.println("in show");
	}
	
	static void mystatic() {
		System.out.println("In Static");
	}
}
