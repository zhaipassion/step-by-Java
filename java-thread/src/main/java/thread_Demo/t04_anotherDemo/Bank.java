package thread_Demo.t04_anotherDemo;

import java.util.Random;

public class Bank {
  private Integer sum = 0;
  Random random = new Random();

  /**
   * 方法上的锁是 this 对象，就是每次调用这个方法的那个对象，
   * 这样的话，即便有多个线程执行，如果是同一个对象就不会执行多次；
   * 而如果是不同的对象，这个锁就不起租用，让别的对象顺利执行。
   * @param n
   */
  public synchronized void add(Integer n) {
    sum = sum + n;
    System.out.println(Thread.currentThread().getName());
    try {
      Thread.sleep(random.nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(sum);
  }
}

/**
 * Tips:
 * 分别对于 code block,method,static method 锁的选择：
 * <p>
 * code block:     obj          -->  Object obj = new Object();
 * method:	       this         -->  relative with the new class;
 * static method:  Ticket.calss -->  the class contains the static method
 */
