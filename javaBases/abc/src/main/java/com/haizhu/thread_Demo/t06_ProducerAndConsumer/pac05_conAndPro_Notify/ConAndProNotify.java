package com.haizhu.thread_Demo.t06_ProducerAndConsumer.pac05_conAndPro_Notify;

public class ConAndProNotify {
	public static void main(String[] args) {
		Resource res = new Resource();

		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();

		/**
		 * if hidden code below, there is nothing wrong
		 */
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
		
		/* if add the code below,there will be two res, but no relationship with "res1"
		Resource res2 = new Resource();
		new Thread(new Producer(res2)).start();
		new Thread(new Consumer(res2)).start();
		*/
	}
}

/**
 * Result:
 * right part: consumer after producer
 * wrong part: not one by one
 *
 */

/**
 * Tips:
 * 1. the set(),out() methods in the Resource class, the OOP patterns
 * 2. The producer and consumer class contains the resource property
 * 3. The producer and consumer class use the constructor to make suer that: the res they both operated is the same one.
 */

class Resource {
	private String name;
	private Integer count = 1;
	private Boolean flag = false;

	public synchronized void set(String name) {
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + count++;
		System.out.println(Thread.currentThread().getName() + "++++ produce ++++"
				+ this.name);
		flag = true;
		this.notify();
	}

	public synchronized void out() {
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "---- consume ----"
				+ this.name);
		flag = false;
		this.notify();
	}
}

class Producer implements Runnable {
	private Resource res;
	Producer(Resource res) {
		this.res = res;
	}
	public void run() {
		while (true) {
			res.set("resource - ");
		}
	}
}

class Consumer implements Runnable {
	private Resource res;
	Consumer(Resource res) {
		this.res = res;
	}
	public void run() {
		while (true) {
			res.out();
		}
	}
}
