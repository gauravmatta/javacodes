package javaimplant.equalshashcode;

import java.util.Objects;

public class Student {
	int stuRollNo;
	String stuName;
	String stuSchoolName;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stuName == null)?0:stuName.hashCode());
		result = prime * result + stuRollNo;
		result = prime * result + ((stuSchoolName == null)?0:stuSchoolName.hashCode());
		return result;
//		return Objects.hash(stuName, stuRollNo, stuSchoolName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if(stuName == null) {
			if(other.stuName != null)
				return false;
		}else if(!stuName.equals(other.stuName))
			return false;
		System.out.println("Passed Student Name");
		if(stuRollNo!=other.stuRollNo)
			return false;
		System.out.println("Passed Student Rollno.");
		if(stuSchoolName==null)
		{
			if(other.stuSchoolName != null)
				return false;
		}else if(!stuSchoolName.equals(other.stuSchoolName))
			return false;
		System.out.println("Passed Student School Name");
		return true;
	}
}
