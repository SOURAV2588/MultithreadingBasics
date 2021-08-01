package com.sourav.concurrency;

/**
 * 
 * @author dell
 * 
 * Just did not get one thing, why it did not work when called from the object itself?
 *
 */
public class WaitAndNotifyExample {

	public static void main(String[] args) throws InterruptedException {

		Processor processor = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}

class Processor {

	public void produce() throws InterruptedException {

		synchronized (this) {
			System.out.println("Inside Producer");
			wait();
			System.out.println("Inside Producer again");
		}
	}

	public void consume() throws InterruptedException {

		synchronized (this) {
			System.out.println("Inside Consumer");
			notify();
		}
	}
}
