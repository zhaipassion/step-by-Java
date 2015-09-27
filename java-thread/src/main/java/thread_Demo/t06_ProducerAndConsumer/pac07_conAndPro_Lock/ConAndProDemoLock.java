package thread_Demo.t06_ProducerAndConsumer.pac07_conAndPro_Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * use the lcok(ReentantLock) instead of synchronized
 *
 * @author Haizhu
 */
public class ConAndProDemoLock {
    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(new Producer(res)).start();
        new Thread(new Producer(res)).start();
        new Thread(new Consumer(res)).start();
        new Thread(new Consumer(res)).start();
    }
}

/**
 * Tips: two change between ConAndProDemo, 1, synchronized --> lock 2,
 * notifyAll() --> signalAll()
 */

class Resource {
    private String name;
    private Integer count = 1;
    private Boolean flag = false;
    // get the lock
    private Lock lock = new ReentrantLock();
    // get the condition
    private Condition condition = lock.newCondition();

    public void set(String name) throws InterruptedException {
        // lock the res
        lock.lock();
        try {
            while (flag) {
                // await()
                condition.await();
            }
            this.name = name + count++;
            System.out.println(Thread.currentThread().getName()
                    + "++++ produce ++++" + this.name);
            flag = true;
            // same as notifyAll
            condition.signalAll();
        } finally {
            // unlock the res
            lock.unlock();
        }
    }

    public void out() throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()
                    + "---- consume ----" + this.name);
            flag = false;
            condition.signalAll();
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
