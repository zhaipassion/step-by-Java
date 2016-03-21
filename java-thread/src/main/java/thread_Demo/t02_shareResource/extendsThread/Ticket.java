package thread_Demo.t02_shareResource.extendsThread;

import java.util.Random;

/**
 * 通过继承Thread启动线程，这种方法每个线程都会有10张票，默认情况下不能进行数据共享
 *
 * @author Bob
 */
public class Ticket extends Thread {
  private Integer tickets = 10;
  Random random = new Random();

  public void run() {
    while (true) {
      if (tickets > 0) {
        try {
          // 进行随机时间d休眠
          Integer sleepTime = random.nextInt(10000);
          Thread.sleep(sleepTime);
          System.out.println();

          // 卖票：每次执行票数减1
          System.out.println(Thread.currentThread().getName() + " $ ticket:" + tickets);
          tickets--;
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
