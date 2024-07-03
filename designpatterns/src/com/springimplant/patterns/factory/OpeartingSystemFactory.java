package com.springimplant.patterns.factory;

public class OpeartingSystemFactory {
	
	public OS getInstance(String str) {
		if(str.equals("windows")) {
			return new Windows();
		}
		else if(str.equals("linux")) {
			return new Linux();
		}
		return null;
	}

}
