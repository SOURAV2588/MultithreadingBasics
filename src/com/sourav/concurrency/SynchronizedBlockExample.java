package com.sourav.concurrency;

public class SynchronizedBlockExample {

	private static int counter1 = 0;
	private static int counter2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	private static void add() {
		synchronized(lock1) {
			++counter1;
		}
	}

	private static void addAgain() {
		synchronized(lock2) {
			++counter2;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					add();
					addAgain();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					add();
					addAgain();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		
		System.out.println(counter1);
		System.out.println(counter2);
	}

}
