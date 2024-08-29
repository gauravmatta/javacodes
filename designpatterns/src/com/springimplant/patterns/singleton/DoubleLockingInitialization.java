package com.springimplant.patterns.singleton;

public class DoubleLockingInitialization {
	
	private static volatile DoubleLockingInitialization object;
	
	private DoubleLockingInitialization() {
		
	}
	
	public static DoubleLockingInitialization getInstance() {
		if(object==null) {
			synchronized(DoubleLockingInitialization.class) {
				if(object==null) {
					object = new DoubleLockingInitialization();
				}
			}
		}
		return object;
	}

}
