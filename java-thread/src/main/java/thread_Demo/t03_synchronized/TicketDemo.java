package thread_Demo.t03_synchronized;

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
