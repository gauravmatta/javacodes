package javaimplant.threads;

public class MyRunnable implements Runnable {

	private String nameString;
	
	public MyRunnable(String name) {
		this.nameString=name;
	}

	@Override
	public void run() {
		System.out.println("Start Thread:"+ nameString);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ended Thread :" + nameString);		
	}

}
