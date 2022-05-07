package javaimplant.records;

import java.util.Objects;

public class EmployeeClass {
	private final String employeeName;
	private final int employeeNumber;
	
	public EmployeeClass(String employeeName, int employeeNumber) {
		super();
		this.employeeName = employeeName;
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeName, employeeNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeClass other = (EmployeeClass) obj;
		return Objects.equals(employeeName, other.employeeName) && employeeNumber == other.employeeNumber;
	}
	
	
}
