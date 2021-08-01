package com.sourav.concurrency;

public class UsingJoin {

	public static void main(String[] args) throws InterruptedException {
		
		JoinRunner1 thread1 = new JoinRunner1();
		JoinRunner2 thread2 = new JoinRunner2();
		thread1.start();
		thread2.start();
		
		// this means that any code written after join will be executed after 
		//all tasks related to thread1 is finished
		thread1.join();
		thread2.join();
		
		System.out.println("Finished");
	}

}

class JoinRunner1 extends Thread{

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

class JoinRunner2 extends Thread{

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
