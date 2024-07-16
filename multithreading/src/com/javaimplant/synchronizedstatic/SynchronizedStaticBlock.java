package com.javaimplant.synchronizedstatic;

public class SynchronizedStaticBlock {

	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			new NumberThread(i);
		}
		for(int i=100;i<200;i++) {
			new SynchroniedNumberThread(i);
		}
		System.out.println("Active threads:"+Thread.activeCount());
		StaticList.displayList();
		
		System.out.println("Display Synchronized List ===>");
		while(Thread.activeCount()>1);
			synchronized (StaticList.class) {
				StaticList.displayList();
			}
		}
}
