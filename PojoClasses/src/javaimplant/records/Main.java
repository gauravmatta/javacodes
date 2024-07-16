package javaimplant.records;

public class Main {

	public static void main(String[] args) {
		EmployeeClass ec = new EmployeeClass("Gaurav", 1);
		Employee er = new Employee("Jacob","Jacob@rob.com",2);
		System.out.println(ec.getEmployeeName());
		System.out.println(er.name());
	}

}
