package thread_Demo.t06_ProducerAndConsumer.pac01_first;

public class FirstDemo {
    public static void main(String[] args) {
        /**
         * the conditions of dead lock:
         * operate the same resource(Res r) but use not same method(Input ip && Output op)
         */
        Res r = new Res();
        Output op = new Output(r);
        Input ip = new Input(r);
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(ip);
        t1.start();
        t2.start();
        /**
         * result:
         * right part:  two thread
         * wrong part:  not name --> price, such as "-------- : 0.0", "|||||||| : 1.1"
         */
    }
}

class Res {
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
            System.out.println(r.getName() + " : " + r.getPrice());
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
        Boolean flag = true;
        while (true) {
            if (flag) {
                r.setName("--------");
                r.setPrice(0.0);
            } else {
                r.setName("||||||||");
                r.setPrice(1.1);
            }
            flag = !flag;
        }
    }
}

