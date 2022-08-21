package reflexion_api;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c =Class.forName("reflexion_api.Employee");
		System.out.println("Name :" + c.getName());
		System.out.println("Super Class :" + c.getSuperclass().getName());
		Class[] cl = c.getInterfaces();
		System.out.println("Interface List : ");
		Arrays.asList(cl).stream().map(cls -> cls.getName()+" ").forEach(System.out::println);
		int i = c.getModifiers();
		System.out.println("Access Modifiers: "+ Modifier.toString(i));
	}

}
