package com.haizhu.thread_Demo.t02_shareResource.implementsRunnalbe;

/**
 * this program can share the 10 tickets,
 * but cann't control the negative number,
 * to see the next demo to solve this problem
 * @author Haizhu
 *
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
