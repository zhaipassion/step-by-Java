package com.haizhu.thread_Demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SpeedTest {

	/**   
	 * @Description: TODO 
	 * @param args     
	 * @author yumeng
	 * @date 2014-1-2 下午01:57:42 
	 * @return void   
	 */
	final CountDownLatch count = new CountDownLatch(10);
	ExecutorService service = Executors.newCachedThreadPool();
	class Counter {
		int i = 0;
		AtomicInteger j = new AtomicInteger(0);

		public synchronized void add(){
			i++;
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}

		public void addJ() {
			j.getAndIncrement();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class DoSomething implements Runnable {
		private Counter c;

		public DoSomething(Counter c) {
			this.c = c;
		}
		public void run() {
			for (int i = 0; i < 10000; i++) {
				c.addJ();
			}
			count.countDown();
		}

	}
	public static void main(String[] args) {

		SpeedTest t = new SpeedTest();
		t.test();
	}
	public void test(){
		long s = System.currentTimeMillis();
		Counter c = new Counter();
		for (int i = 0; i < 10; i++) {
			service.execute(new DoSomething(c));
		}
		System.out.println("等待全部执行完毕");
		try {
			count.await();
			System.out.println("当前Counter中i的值:" + c.i);
			long e = System.currentTimeMillis();
			System.out.println("耗时:" + (e - s));
			service.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

