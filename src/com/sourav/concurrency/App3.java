package com.sourav.concurrency;

public class App3 {

	public static void main(String[] args) {
		Worker2 worker2 = new Worker2();
		Thread thread = new Thread(worker2);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		worker2.setTerminated(true);
		System.out.println("Finished");
	}

}

class Worker2 implements Runnable{
	
	private volatile boolean isTerminated = false;
	
	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public void run() {
		
		while(!isTerminated) {
			System.out.println("Hello");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
