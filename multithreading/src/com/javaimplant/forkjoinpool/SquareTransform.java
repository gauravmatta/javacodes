package com.javaimplant.forkjoinpool;

import java.util.concurrent.RecursiveAction;

public class SquareTransform extends RecursiveAction {

	private static final long serialVersionUID = 2312435525914339444L;
	
	static final int THRESHOLD=10;
	int[] data;
	int start;
	int end;
	
	public SquareTransform(int[] data, int start, int end) {
		super();
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if((end-start) < THRESHOLD){
			for(int i=start;i<end;i++) {
				int original = data[i];
				data[i]=data[i]*data[i];
				System.out.println(data[i]+" square of "+original+" Computed by: "+ Thread.currentThread().getName());
			}
		} else {
			int middle = (start+end)>>>1;
			invokeAll(new SquareTransform(data, start, middle),
					new SquareTransform(data, middle, end));
		}
	}

}
