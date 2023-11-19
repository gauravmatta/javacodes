package reflexion_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
		
		Employee e = new Employee();
		c=e.getClass();
		Field[] flds = c.getDeclaredFields();
		Arrays.asList(flds).stream().map(f -> {
			try {
				return f.getName()+ " " + f.getType().getName()+ " " + Modifier.toString(f.getModifiers())+ " " +f.get(f);
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}).forEach(System.out::println);
		
		
		System.out.println("Methods=============>");
		c=Employee.class;
		Method[] mthd = c.getDeclaredMethods();
		Arrays.asList(mthd).stream()
		.map(m -> {
			Class[] pts = m.getParameterTypes();
			for (Class c1:pts)
			{
				System.out.println(c1.getName()+" ");
			}
			Class[] exTypes = m.getExceptionTypes();
			for (Class c1:exTypes)
			{
				System.out.println(c1.getName()+" ");
			}
			return m.getName() + " " +m.getReturnType().getName()+" "+Modifier.toString(m.getModifiers());
			})
		.forEach(System.out::println);
		System.out.println("Constructors=============>");
		Constructor[] con = c.getDeclaredConstructors();
		Arrays.asList(con).stream().map(co -> {
			Class[] pts = co.getParameterTypes();
			for (Class c1:pts)
			{
				System.out.println(c1.getName()+" ");
			}
			Class[] exTypes = co.getExceptionTypes();
			for (Class c1:exTypes)
			{
				System.out.println(c1.getName()+" ");
			}
			return co.getName() + " " + Modifier.toString(co.getModifiers());
		}).forEach(System.out::println);
	}

}
