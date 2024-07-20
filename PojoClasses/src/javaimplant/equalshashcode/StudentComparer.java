package javaimplant.equalshashcode;

public class StudentComparer {

	public static void main(String[] args) {
		Student s1= new Student();
		s1.stuRollNo=5;
		s1.stuName="Gaurav";
		s1.stuSchoolName="CFS";
		
		Student s2= new Student();
		s2.stuRollNo=5;
		s2.stuName="Gaurav";
		s2.stuSchoolName="CFS";
		
		System.out.println(s1.equals(s2));
		
		Laptop obj = new Laptop();
		obj.model="HP";
		obj.price=1000;
		System.out.println(obj);
		
		Laptop obj1 = new Laptop();
		obj1.model="HP";
		obj1.price=1000;
		System.out.println(obj.equals(obj1));

	}

}
