package com.haizhu.thread_Demo.t02_shareResource.extendsThread;

import thread_Demo.t02_shareResource.extendsThread.Ticket;

/**
 * The demo can start three thread,but cann't share the 10 tickets,
 * because every thread got 10.
 * @author Haizhu
 *
 */
public class TicketDemo {
	public static void main(String[] args) {
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();
		t1.start();
		t2.start();
		t3.start();
	}
}
