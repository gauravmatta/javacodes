package java8.entity;

public class Student {
	private int grade;
	private String car;
	private String name;
	private double stipend;
	
	public Student(int grade, String car, String name,double stipend) {
		super();
		this.grade = grade;
		this.car = car;
		this.name = name;
		this.stipend = stipend;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", car=" + car + ", name=" + name + ", stipend=" + stipend + "]";
	}
	
	public int getGrade() {
		return grade;
	}

	public double getStipend() {
		return stipend;
	}

	public void setStipend(double stipend) {
		this.stipend = stipend;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
