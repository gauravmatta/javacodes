package com.springimplant.patterns.main;

import com.springimplant.patterns.singleton.Singleton;
import com.springimplant.patterns.singleton.SingletonEnum;

public class SingletonMain {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			Singleton singleton = Singleton.getInstance();
			System.out.println("Thread 1"+singleton);
		});
		Thread t2 = new Thread(()->{
			Singleton singleton1 = Singleton.getInstance();
			System.out.println("Thread 2"+singleton1);
		});
		t1.start();
		t2.start();
		Singleton singleton = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println("Instance 1"+singleton);
		System.out.println("Instance 2"+singleton2);
		SingletonEnum enum1 = SingletonEnum.INSTANCE;
		enum1.i=5;
		enum1.show();
		SingletonEnum enum2 = SingletonEnum.INSTANCE;
		enum2.i=6;
		enum2.show();
	}
}
