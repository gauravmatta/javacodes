package com.javaimplant.synchronizedstatic;

public class SynchroniedNumberThread implements Runnable {
	private int number=0;
	
	public SynchroniedNumberThread(int number) {
		this.number=number;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		synchronized (StaticList.class) {
			StaticList.addToList(number);	
		}
	}

}
