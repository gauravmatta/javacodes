package javaimplant.memoryleaks;

import java.util.ArrayList;
import java.util.List;

public class TestStaticMemoryLeaks {
	
	public static List<Double> list = new ArrayList<>();
	
	public void populateList() {
		for(int i=0;i<10000000;i++) {
			list.add(Math.random());
		}
		System.out.println("Check Point 2");
	}

	public static void main(String[] args) {
		System.out.println("Check Point 1");
		new TestStaticMemoryLeaks().populateList();
		System.out.println("Check Point 3");
	}
}
