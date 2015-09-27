package com.haizhu.thread_Demo.t02_shareResource.implementsRunnalbe;

import java.util.Random;

public class Ticket implements Runnable {
    private Integer tickets = 10;
    Random random = new Random();

    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    // get the sleepTime by random,so that every time is not the same
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
