package com.springimplant.patterns.singleton;

public class Singleton {
	
	public static Singleton singleton;
	int i;
	private Singleton() {
		System.out.println("Instance Created");
	}
	public static Singleton getInstance() {
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null) {
					singleton= new Singleton();
				}
			}
		}
		return singleton;
	}

}
