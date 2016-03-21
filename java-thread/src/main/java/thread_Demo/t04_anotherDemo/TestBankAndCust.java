package thread_Demo.t04_anotherDemo;

/**
 * @author Bob
 */
public class TestBankAndCust {
  public static void main(String[] args) {
    /**
     * 在如下条件下才使用线程锁：
     * 1.至少两个线程
     * 2.使用同一个锁
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
