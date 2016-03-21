package com.phei.netty.bob.demo01.test;

import java.net.Socket;

/**
 * Created by Bob on 2016/3/21.
 */
public class ServiceImpl implements Runnable {
  Socket socket = null;
  public ServiceImpl(Socket s) {
    this.socket = s;
  }
  public void run() {
    boolean isKeep = true;
    try {
      while (isKeep) {
        socket.sendUrgentData(0xFF);
        Thread.sleep(1 * 1000);
      }
    } catch (Exception e) {
      isKeep = false;
    }
  }
}
