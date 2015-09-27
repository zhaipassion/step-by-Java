package thread_Demo.t06_ProducerAndConsumer.pac04_notify;

public class NotifyDemo {
    public static void main(String[] args) {
        Res r = new Res();
        Output op = new Output(r);
        Input ip = new Input(r);
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(ip);
        t1.start();
        t2.start();
    }
}

class Res {
    private String name;
    private Double price;
    private Boolean lockFlag = false;

    public synchronized void set(String name, Double price) {
        if (lockFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.price = price;
        lockFlag = true;
        notify();
    }

    public synchronized void out() {
        if (!lockFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "-->" + this.price);
        lockFlag = false;
        notify();
    }

    public Boolean getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Boolean lockFlag) {
        this.lockFlag = lockFlag;
    }
}

class Output implements Runnable {
    private Res r;

    Output(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }
}

class Input implements Runnable {
    private Res r;

    Input(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        Boolean proType = true;
        while (true) {
            if (proType) {
                r.set("--------", 0.0);
            } else {
                r.set("||||||||", 1.1);
            }
            proType = !proType;
        }
    }
}

