package java8.entity;

public class Pupil {

	String name;
	int sid;
	char grade;
	
	public Pupil(String name, int sid, char grade) {
		super();
		this.name = name;
		this.sid = sid;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
}
