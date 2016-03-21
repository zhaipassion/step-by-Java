package thread_Demo.t05_DeadLockDemo;

/**
 * Created by Bob on 2016/3/21.
 */
public class DeadLockTest {
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
    Thread t1 = new Thread(new DeadLock(true));
    Thread t2 = new Thread(new DeadLock(false));
    t1.start();
    t2.start();
  }
}
