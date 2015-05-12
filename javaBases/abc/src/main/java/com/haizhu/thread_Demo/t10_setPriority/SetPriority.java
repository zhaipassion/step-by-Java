package com.haizhu.thread_Demo.t10_setPriority;

public class SetPriority{
	public static void main(String[] args) throws InterruptedException {
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		// setPriority()
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		t2.setPriority(Thread.MIN_PRIORITY);
		for(int i=0;i<200;i++){
			System.out.println("main --> "+i);
			// yield(): 
			Thread.yield();
		}
		System.out.println("Game over.");
	}
}

class Demo implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+ " --> " +i);
		}
	}
}

