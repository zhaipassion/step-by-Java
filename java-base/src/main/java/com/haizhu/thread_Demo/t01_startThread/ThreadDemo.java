package com.haizhu.thread_Demo.t01_startThread;

/**
 * the thread class
 * @author Haizhu
 */
public class ThreadDemo extends Thread {
	ThreadDemo(String name){
		// use the super constructor
		super(name);
	}
	// override the run() function
	public void run(){
		for(int i=0;i<1000;i++){
			// the two ways to get the currentThread's name,if not defined manually,it has a default one
			System.out.println((Thread.currentThread().getName())+"== "+this.getName()+i);
		}
	}
}
