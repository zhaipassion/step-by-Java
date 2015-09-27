package thread_Demo.t04_anotherDemo;

/**
 * think about the OOP,the thread only do the things about thread,
 * specific operation, such as add() method, should in the Bank,Cus class.
 *
 * @author Haizhu
 */
public class TestBankAndCust {
    public static void main(String[] args) {
        /**
         * In short,to synchronize must meet two conditions, 1,more than two
         * thread, 2,use the same lock(Attention,the lock cann't in the run()
         * method)
         */
        Cus c1 = new Cus();
        Cus c2 = new Cus();
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c2);
        Thread t4 = new Thread(c2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
