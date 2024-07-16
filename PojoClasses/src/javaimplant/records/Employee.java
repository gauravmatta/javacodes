package javaimplant.records;

import java.io.Serializable;

public record Employee(String name,String email,int employeeNumber) implements Serializable {
	public Employee() {
		this("Gaurav","test@test.com",1);
	}
	
	public Employee(EmployeeBuilder eb) {
		this(eb.name,eb.email,eb.employeeNumber);
	}
	
	public static class EmployeeBuilder {
		private String name;
		private int employeeNumber;
		private String email;
		
		public EmployeeBuilder() {}

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        public EmployeeBuilder mail(String mail) {
            this.email = mail;
            return this;
        }

        public EmployeeBuilder employeeNumber(int num) {
            this.employeeNumber = num;
            return this;
        }
        
        public Employee build() {
            return new Employee(this);
        }
	}
}
