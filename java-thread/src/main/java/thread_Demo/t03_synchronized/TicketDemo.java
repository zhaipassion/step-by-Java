package com.haizhu.thread_Demo.t03_synchronized;

import thread_Demo.t03_synchronized.Ticket;

/**
 * Well done,this time the program can also share the 10 tickets
 * and control the negative number.Attention,use the "Object" class
 * as the lock.
 *
 * @author Bob
 */
public class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
    }
}