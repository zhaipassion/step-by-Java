package thread_Demo.t01_startThread;

/**
 * thread 类
 *
 * @author Bob
 */
public class ThreadDemo extends Thread {
  ThreadDemo(String name) {
    // use the super constructor
    super(name);
  }

  // override the run() function
  public void run() {
    for (int i = 0; i < 1000; i++) {
      // 两种获取当前线程名称的方法，获取的名称应该一致，如果不一致，说明有错误
      System.out.println((Thread.currentThread().getName()) + "== " + this.getName() + i);
    }
  }
}
