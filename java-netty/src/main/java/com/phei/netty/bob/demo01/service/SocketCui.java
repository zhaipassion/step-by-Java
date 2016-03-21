package com.phei.netty.bob.demo01.service;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Bob on 2016/3/21.
 */
public class SocketCui extends Socket {
  /**
   * 为对象增加名称属性
   */
  private String name;

  public SocketCui() {
  }

  public SocketCui(String ip, int port) throws UnknownHostException, IOException {
    super(ip, port);
  }

  /**
   * 覆盖关闭的方法
   */
  @Override
  public synchronized void close() throws IOException {
    SocketKeep.socketIsLock.put(this.name, "0");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
