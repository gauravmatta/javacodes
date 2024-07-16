package com.javaimplant.synchronizedstatic;

public class NumberThread implements Runnable {
	private int number=0;
	
	public NumberThread(int number) {
		this.number=number;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		StaticList.addToList(number);
	}

}
