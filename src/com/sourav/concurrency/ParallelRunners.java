package com.sourav.concurrency;

public class ParallelRunners {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new ParallelRunner1());
		
	
		Thread thread2 = new Thread(new ParallelRunner2());
		
		thread1.start();
		thread2.start();
		
		/*ParallelRunner1 runner1 = new ParallelRunner1();
		runner1.run();
		
		ParallelRunner2 runner2 = new ParallelRunner2();
		runner2.run();*/
	}

}

class ParallelRunner1 implements Runnable{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("Runner 1 : " + i);
		}
	}
}

class ParallelRunner2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("Runner 2 : " + i);
		}
	}
}
