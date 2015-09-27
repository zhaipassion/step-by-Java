package thread_Demo.t04_anotherDemo;

import java.util.Random;

public class Bank {
    private Integer sum = 0;
    Random random = new Random();

    /**
     * this add() method's lock is Cus object. When more new a cus,
     * there will add a new lock,because method's lock is "this",
     * and in this demo, "this" is relative with new Cus(),not with
     * new Thread().
     *
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
 * what's the lock with code block,method,static method?
 * <p>
 * code block:     obj          -->  Object obj = new Object();
 * method:	       this         -->  relative with the new class;
 * static method:  Ticket.calss -->  the class contains the static method
 */
