package thread_Demo.t03_synchronized;

import java.util.Random;

public class Ticket implements Runnable {

  private Integer tickets = 10;

  Object obj = new Object();
  Random random = new Random();

  public void run() {
    while (true) {
      synchronized (obj) {
        if (tickets > 0) {
          try {
            Integer sleepTime = random.nextInt(10000);
            Thread.sleep(sleepTime);
            System.out.println(Thread.currentThread().getName() + " $ ticket:" + tickets);
            tickets--;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
