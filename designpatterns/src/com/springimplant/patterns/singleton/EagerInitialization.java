package com.springimplant.patterns.singleton;

public class EagerInitialization {
	private static EagerInitialization object = new EagerInitialization();
	
	private EagerInitialization() {
		
	}
	
	public static EagerInitialization getInstance() {
		return object;
	}
}
