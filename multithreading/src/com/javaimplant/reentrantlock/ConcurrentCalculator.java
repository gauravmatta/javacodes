package com.javaimplant.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCalculator {
	
	public static class Calculation{
		public static final int UNSPECIFIED = -1;
		public static final int ADDITION = 0;
		public static final int SUBTRACTION = 1;
		int type = UNSPECIFIED;
		
		public double value;
		
		public Calculation(int type,double value) {
			this.type=type;
			this.value=value;
		}
	}
	
	private double result = 0.0D;
	Lock lock = new ReentrantLock();
	
	public  void add(double value) {
		try {
			lock.lock();
			this.result+=value;	
		} finally {
			lock.unlock();
		}
	}
	
	public  void subtract(double value) {
		try {
			lock.lock();
			this.result -= value;	
		} finally {
			lock.unlock();
		}
	}
	
	public void calculate(Calculation ...calculations ) {
		try {
			lock.lock();
			for(Calculation c:calculations) {
				switch(c.type) {
				case Calculation.ADDITION : 
					add(c.value); 
					break;
				case Calculation.SUBTRACTION:
					subtract(c.value);
					break;
				default:
					add(c.value);
					subtract(c.value);
					break;
				}
			}
		}finally {
			lock.unlock();
		}
	}

}
