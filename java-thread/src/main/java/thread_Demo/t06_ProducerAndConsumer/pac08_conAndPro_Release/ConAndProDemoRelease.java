package thread_Demo.t06_ProducerAndConsumer.pac08_conAndPro_Release;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition_pro,condtion_con only weak the opposite thread
 *
 * @author Bob
 */
public class ConAndProDemoRelease {
    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Producer(res)).start();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();
        new Thread(new Consumer(res)).start();
    }
}

/**
 * Tips: use two conditons
 * condition   --> condition_pro,condition_con
 * signalAll() --> signal()
 * <p>
 * Attention:
 * start from JDK1.5+
 * synchronized --> lock
 * Object(wait,notify,notifyAll) --> condition
 */

class Resource {
    private String name;
    private Integer count = 1;
    private Boolean flag = false;
    // get the lock
    private Lock lock = new ReentrantLock();
    // get the condition
    private Condition condition_pro = lock.newCondition();
    private Condition condition_con = lock.newCondition();

    public void set(String name) throws InterruptedException {
        // lock the res
        lock.lock();
        try {
            while (flag) {
                // await()
                condition_pro.await();
            }
            this.name = name + count++;
            System.out.println(Thread.currentThread().getName()
                    + "++++ produce ++++" + this.name);
            flag = true;
            condition_con.signal();
        } finally {
            // unlock the res
            lock.unlock();
        }
    }

    public void out() throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                condition_con.await();
            }
            System.out.println(Thread.currentThread().getName()
                    + "---- consume ----" + this.name);
            flag = false;
            condition_pro.signal();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private Resource res;

    Producer(Resource res) {
        this.res = res;
    }

    public void run() {
        while (true) {
            try {
                res.set("resource - ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Resource res;

    Consumer(Resource res) {
        this.res = res;
    }

    public void run() {
        while (true) {
            try {
                res.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
