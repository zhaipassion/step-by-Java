package thread_Demo.t02_shareResource.extendsThread;

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
