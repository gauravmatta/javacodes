package com.springimplant.patterns.singleton;

public class BillPughSolution {

	private BillPughSolution() {
		
	}
	
	private static class BillPughSolutionHelper{
		private static final BillPughSolution INSTANCE_OBJECT = new BillPughSolution();
	}
	
	public static BillPughSolution getInstance() {
		return BillPughSolutionHelper.INSTANCE_OBJECT;
	}
}
