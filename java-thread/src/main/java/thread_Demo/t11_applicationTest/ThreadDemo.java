package thread_Demo.t11_applicationTest;

/**
 * If don't use thread, the three "for" iterator will execute one by one,
 * if the first takes a long time, it will be not good for the next two,
 * so, we can use Thread to solve this problem.
 * @author Haizhu
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		for (int x = 0; x < 100; x++) {
			System.out.println(Thread.currentThread().getName() + "-->" + x);
		}
		
		// inner class
		new Thread() {
			public void run() {
				for (int x = 0; x < 100; x++) {
					System.out.println(Thread.currentThread().getName() + "-->"
							+ x);
				}
			}
		}.start();

		// another way
		Runnable r = new Runnable(){
			public void run(){
				for (int x = 0; x < 100; x++) {
					System.out.println(Thread.currentThread().getName() + "-->" + x);
				}
			}
		};
		new Thread(r).start();
	}
}
