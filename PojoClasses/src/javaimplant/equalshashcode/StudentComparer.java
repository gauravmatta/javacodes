package javaimplant.equalshashcode;

public class StudentComparer {

	public static void main(String[] args) {
		Student s1= new Student();
		s1.stuRollNo=5;
		s1.stuName="Gaurav";
		s1.stuSchoolName="CFS";
		
		Student s2= new Student();
		s1.stuRollNo=5;
		s1.stuName="Gaurav";
		s1.stuSchoolName="CFS";
		
		System.out.println(s1.equals(s2));

	}

}
