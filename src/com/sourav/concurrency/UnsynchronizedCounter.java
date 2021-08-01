package com.sourav.concurrency;

/**
 * 
 * @author dell
 * 
 * This is an excellent program to demonstrate race condition
 *
 */
public class UnsynchronizedCounter {

	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		process();
		System.out.println(counter);
	}

	public static void process() throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					++counter;
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					++counter;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
