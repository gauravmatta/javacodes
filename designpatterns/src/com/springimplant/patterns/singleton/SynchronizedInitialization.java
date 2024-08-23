package com.springimplant.patterns.singleton;

public class SynchronizedInitialization {
	private static SynchronizedInitialization object;
	
	private SynchronizedInitialization() {
		
	}
	
	public static synchronized SynchronizedInitialization getInstance() {
		if(object==null) {
			object = new SynchronizedInitialization();
		}
		return object;
	}
}
