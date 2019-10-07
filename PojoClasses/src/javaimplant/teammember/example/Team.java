package javaimplant.teammember.example;

public class Team {
	Member member;
	
	public Team(Member member) {
	this.member = member;
	}
	
	public static void main(String[] args) 
	{
		Member myMember = new Member("Gaurav", "DevOps", 10, 1);
		Team myTeam = new Team(myMember);
		System.out.println(myTeam.member.getName());
		System.out.println(myTeam.member.getType());
		System.out.println(myTeam.member.getLevel());
		System.out.println(myTeam.member.getRank());
	}
}