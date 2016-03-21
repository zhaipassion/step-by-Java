package com.phei.netty.bob.demo01.test;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bob on 2016/3/21.
 */
public class ServiceTest {
  public static void main(String[] args) {
    try {
      ServerSocket ss1 = new ServerSocket(8001);
      Runnable accumelatora1 = new Accumulatort(ss1);
      Thread threada = new Thread(accumelatora1, "ThreadA");
      threada.start();
      System.out.println("服务启动完毕！");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class Accumulatort implements Runnable {
  ServerSocket ss = null;

  public Accumulatort(ServerSocket s) {
    this.ss = s;
  }

  @SuppressWarnings("unchecked")
  public void run() {
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      while (true) {
        Socket s = ss.accept();
        System.out.println(format.format(new Date()) + " " + "---------收到请求！");
        new Thread(new ServiceImpl(s)).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
