package thread_Demo.t05_DeadLockDemo;

class Test extends Thread {
    private Boolean flag;

    Test(Boolean flag) {
        this.flag = flag;
    }

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void run() {
        if (flag) {
            synchronized (lock1) {
                System.out.println("if lock1...");
                synchronized (lock2) {
                    System.out.println("if lock2...");
                }
            }
        } else {
            synchronized (lock2) {
                System.out.println("else lock2...");
                synchronized (lock1) {
                    System.out.println("else lock1...");
                }
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        /**
         *
         * the requirement of the deadLock:
         * 1. more than one thread
         * 2. more than one lock
         *
         * more information:
         * http://www.cnblogs.com/simonhaninmelbourne/archive/2012/11/24/2786215.html
         */
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}
