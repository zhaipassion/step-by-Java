package thread_Demo.t02_shareResource.implementsRunnalbe;

import java.util.Random;

/**
 * 通过实现Runnable接口启动线程，这种方法默认进行线程间的数据共享
 *
 * @author Bob
 */
public class Ticket implements Runnable {
  private Integer tickets = 10;
  Random random = new Random();

  public void run() {
    while (true) {
      if (tickets > 0) {
        try {
          Integer sleepTime = random.nextInt(10000);
          Thread.sleep(sleepTime);
          System.out.println("");

          System.out.println(Thread.currentThread().getName() + " $ ticket:" + tickets);
          tickets--;
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
