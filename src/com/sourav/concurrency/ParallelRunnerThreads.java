package com.sourav.concurrency;

public class ParallelRunnerThreads {

	public static void main(String[] args) {
		
		ParallelThreadRunner1 thread1 = new ParallelThreadRunner1();
		ParallelThreadRunner2 thread2 = new ParallelThreadRunner2();
		thread1.start();
		thread2.start();
		
		System.out.println("Finished");
	}

}

class ParallelThreadRunner1 extends Thread{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("Runner 1 : " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ParallelThreadRunner2 extends Thread{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("Runner 2 : " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
