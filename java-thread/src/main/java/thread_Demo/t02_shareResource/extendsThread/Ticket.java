package thread_Demo.t02_shareResource.extendsThread;

import java.util.Random;

/**
 * the ticket demo class and function
 * the class extends Thread,so that every thread get 10 tickets to iterator
 *
 * @author Haizhu
 */
public class Ticket extends Thread {
    private Integer tickets = 10;
    Random random = new Random();

    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    // get the sleepTime by random,so that every time is not the same
                    Integer sleepTime = random.nextInt(10000);
                    Thread.sleep(sleepTime);
                    // sell the ticket,then number-1
                    System.out.println(Thread.currentThread().getName() + " $ ticket:" + tickets);
                    tickets--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
