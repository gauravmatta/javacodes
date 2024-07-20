package com.javaimplant.volatil;

public class VolatileExample implements Runnable {
	
	private static volatile boolean stopRequested;

	@Override
	public void run() {
		int i = 0;
		while(!stopRequested) {
			i++;
		}
		System.out.println("BackThread Completed");
	}
	
	public static void main(String[] args) {
		VolatileExample v = new VolatileExample();
		Thread backThread = new Thread(v);
		backThread.start();
		try {
			Thread.sleep(1000);
			stopRequested=true;
			System.out.println("Main Completed :");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

}
