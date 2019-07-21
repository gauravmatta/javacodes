import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner bucky=new Scanner(System.in);
		double fnum,snum,answer;
		System.out.println("Enter First Num");
		fnum=bucky.nextDouble();
		System.out.println("Enter Second Num");
		snum=bucky.nextDouble();
		answer=fnum+snum;
		System.out.println(answer);
	}

}
