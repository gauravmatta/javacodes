package javaimplant.immutableclass;

import java.util.HashSet;
import java.util.Set;

public class ImmuatableCaller {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(3);
		ImmutableClass obj = new ImmutableClass(0,"Gaurav",set);
		set.add(8);
		System.out.println("Object Copy : "+obj.getid()+": "+obj.getName()+": "+obj.getset());
		int id = obj.getid();
		String name = obj.getName();
		Set<Integer> objset = obj.getset();
		System.out.println("Local Copy: "+id+": "+name+": "+objset);
		id=3;
		name="Manu";
		objset.add(7);
		System.out.println("Altered Local Copy: "+id+": "+name+": "+objset);
		System.out.println("Object Copy : "+obj.getid()+": "+obj.getName()+": "+obj.getset());
	}

}
