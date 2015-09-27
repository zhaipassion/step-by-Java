package thread_Demo.t04_anotherDemo;

public class Cus implements Runnable {
    private Bank b = new Bank();

    public void run() {
        for (int i = 0; i < 3; i++) {
            b.add(100);
        }
    }
}
