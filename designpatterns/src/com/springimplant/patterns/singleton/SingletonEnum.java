package com.springimplant.patterns.singleton;

public enum SingletonEnum {
	INSTANCE;
	public int i;
	public void show()
	{
		System.out.println(i);
	}
}
