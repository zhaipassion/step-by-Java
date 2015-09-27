package thread_Demo.t08_setDaemon;

/**
 * anoter way to stop the thread
 *
 * @author Haizhu
 *         Tips: use this method before start() method
 */
public class SetDaemonTest {
    public static void main(String[] args) {
        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        // before start() method to stop the thread t1,t2
        t1.setDaemon(true);
        t2.setDaemon(true);
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
                System.out.println(Thread.currentThread().getName() + " Exception ...");
            }
            System.out.println(Thread.currentThread().getName() + " run ...");
        }
    }
}

