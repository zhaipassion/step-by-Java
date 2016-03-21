package thread_Demo.t01_startThread;

/**
 * thread测试类
 * 在本范例中，一共有三个线程。两个自己手动启动的测试线程，要给main函数线程
 *
 * @author Bob
 */
public class ThreadStartDemo {
  public static void main(String[] args) {
    // create two threads
    ThreadDemo d1 = new ThreadDemo("Thread one ");
    ThreadDemo d2 = new ThreadDemo("Thread two ");
    // start threads
    d1.start();
    d2.start();
  }
}
