package thread_Demo.t07_stop;

/**
 * This demo is not the best solution,see SetDaimon.java
 * 
 * How to stop a thread: 
 * --> A thread will stop when run() is stop, 
 * But how to stop a run() ? 
 * --> Stop the iterator
 * 
 * If in the program there is no wait() method, the thread t1,t2 will stop 
 * followed by the main thread, but if the wait() method exists, 
 * -->use interrupt() 
 * @author Haizhu
 */
public class StopThreadTest {
	public static void main(String[] args) {
		StopThread st = new StopThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.start();
		t2.start();
		Integer num = 0;
		while (true) {
			if (num++ == 100) {
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println("main run ...");
		}
		System.out.println("Game over.");
	}
}

class StopThread implements Runnable {
	private Boolean flag = true;
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()
						+ " Exception ...");
				// stop the thread t1,t2
				flag = false;
			}
			System.out.println(Thread.currentThread().getName() + " run ...");
		}
	}
}
