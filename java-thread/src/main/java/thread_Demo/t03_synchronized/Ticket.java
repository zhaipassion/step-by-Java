package thread_Demo.t03_synchronized;

import java.util.Random;

public class Ticket implements Runnable {
    private Integer tickets = 10;
    /**
     * the Object obj cann't place in the function run(),
     * if in,every time the run() execute,the "obj" will be
     * created a new one,so that,the lock will not work any more.
     * So as the random,out the run() will be a better way.
     */
    Object obj = new Object();
    Random random = new Random();

    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        // get the sleepTime by random,so that every time is not
                        // the same
                        Integer sleepTime = random.nextInt(10000);
                        Thread.sleep(sleepTime);
                        System.out.println(Thread.currentThread().getName()
                                + " $ ticket:" + tickets);
                        tickets--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
