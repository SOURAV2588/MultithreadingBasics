package com.sourav.concurrency;

public class SequentialRunners {

	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		runner1.startRunning();
		
		Runner2 runner2 = new Runner2();
		runner2.startRunning();
	}

}

class Runner1{
	
	public void startRunning() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("Runner 1 : " + i);
		}
	}
}

class Runner2{
	
	public void startRunning() {
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("Runner 2 : " + i);
		}
	}
}
