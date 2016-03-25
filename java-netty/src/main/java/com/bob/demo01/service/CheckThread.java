package com.bob.demo01.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by Bob on 2016/3/21.
 */

public class CheckThread implements Runnable {

  private static Log logger = LogFactory.getLog(CheckThread.class);

  public void run() {
    while (true) {
      SocketCui socket = null;
      for (SocketEntity socketEntity : SocketKeep.socketEntityList) {
        if (null != socketEntity && socketEntity.isKeepConn()) {
          String isLock = SocketKeep.socketIsLock.get(socketEntity.getName());
          // 如果当前未被使用
          if (!"1".equals(isLock)) {
            // 锁定引用
            SocketKeep.socketIsLock.put(socketEntity.getName(), "1");
            socket = SocketKeep.socketMap.get(socketEntity.getName());
            try {
              // 发送一个心跳包
              socket.sendUrgentData(0xFF);
              // 释放资源
              SocketKeep.socketIsLock.put(socketEntity.getName(), "0");
            } catch (Exception e) {
              logger.error("检查连接时异常！启动重连！资源名称：" + socketEntity.getName(), e);
              // 如果异常，应该建立一个线程去初始化该连接
              InitSocket initS = new InitSocket(socketEntity.getName());
              new Thread(initS).start();
            }
          }
        }
      }
      // 执行间隔
      try {
        logger.error("本次检测结束！");
        Thread.sleep(SocketKeep.commonCheckTime * 1000);
      } catch (Exception e) {
      }
    }
  }
}
