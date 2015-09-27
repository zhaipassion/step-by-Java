package com.haizhu.thread_Demo.t01_startThread;

/**
 * test the thread 
 * @author Haizhu
 * in this demo,there are three threads: two demo threads, one main thread
 */
public class ThreadStartDemo {
	public static void main(String[] args) {
		// create two threads
		ThreadDemo d1 = new ThreadDemo("Thread one ");
		ThreadDemo d2 = new ThreadDemo("Thread two ");
		// start threads
		d1.start();
		d2.start();
		for(int i=0;i<1000;i++){
			System.out.println("main..."+i);
		}
	}
}
