package javaimplant.teammember.example;

public class Member {
	private String name;
	private String type;
	private int level;
	private int rank;
	
	public Member(String name, String type, int level, int rank) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
