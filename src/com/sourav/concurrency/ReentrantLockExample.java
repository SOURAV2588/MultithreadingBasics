package com.sourav.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		Worker5 worker = new Worker5();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					worker.producer();
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
					worker.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}

class Worker5 {

	// Why we would be needing a re-entrantlock
	// when we can create a object and use it as a lock?
	private Lock lock = new ReentrantLock();

	// what does this do?
	private Condition condition = lock.newCondition();

	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Inside producer");
		condition.await();
		System.out.println("Inside producer again");
		lock.unlock();
	}

	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(1000);
		System.out.println("Inside consumer");
		condition.signal();
		lock.unlock();
	}
}
