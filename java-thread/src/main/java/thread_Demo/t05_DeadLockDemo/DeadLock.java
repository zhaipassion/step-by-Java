package thread_Demo.t05_DeadLockDemo;

public class DeadLock extends Thread {

  private Boolean flag;

  DeadLock(Boolean flag) {
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
