package com.springimplant.patterns.singleton;

public class LazyInitialization {
	private static LazyInitialization object;
	private LazyInitialization() {
		
	}
	public static LazyInitialization getInstance() {
		if(object==null) {
			object = new LazyInitialization();
		}
		return object;
	}

}
