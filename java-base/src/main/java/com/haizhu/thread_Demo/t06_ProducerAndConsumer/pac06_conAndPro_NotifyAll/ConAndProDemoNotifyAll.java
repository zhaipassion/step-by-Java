package com.haizhu.thread_Demo.t06_ProducerAndConsumer.pac06_conAndPro_NotifyAll;

public class ConAndProDemoNotifyAll {
	public static void main(String[] args) {
		Resource res = new Resource();

		new Thread(new Producer(res)).start();
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
		new Thread(new Consumer(res)).start();
		
		/* if add the code below,there will be two res, but no relationship with "res1"
		Resource res2 = new Resource();
		new Thread(new Producer(res2)).start();
		new Thread(new Consumer(res2)).start();
		*/
	}
}

/**
 * Tips:
 * two change between ConAndProDemo,
 * 1, if --> while
 * 2, notify() --> notifyAll()
 */

class Resource {
	private String name;
	private Integer count = 1;
	private Boolean flag = false;

	public synchronized void set(String name) {
		while (flag) {
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
		this.notifyAll();
	}

	public synchronized void out() {
		while (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "---- consume ----"
				+ this.name);
		flag = false;
		this.notifyAll();
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
