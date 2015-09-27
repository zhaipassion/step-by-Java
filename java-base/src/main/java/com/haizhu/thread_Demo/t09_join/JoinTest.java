package com.haizhu.thread_Demo.t09_join;

public class JoinTest{
	public static void main(String[] args) throws InterruptedException {
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		/**
		 *  t1 apply for the CPU executive,
		 *  until the t1 end,the main thread
		 *  and the t2 thread will execute.
		 */
		t1.join();
		t2.start();
		/**
		 * if place the "t1.join()" below,
		 * the result will be different.
		 */
		//t1.join();
		for(int i=0;i<200;i++){
			System.out.println("main --> "+i);
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

