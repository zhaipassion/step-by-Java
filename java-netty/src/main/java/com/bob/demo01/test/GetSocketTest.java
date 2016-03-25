package com.bob.demo01.test;

import com.bob.demo01.service.CommonSocket;
import com.bob.demo01.service.SocketKeep;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bob on 2016/3/21.
 */
public class GetSocketTest {
  public static void main(String[] args) {
    SocketKeep.initSocketKeep();
    while(true){
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
        Socket socket1 = CommonSocket.getSocketByName("socket1");
        if(null != socket1){
          System.out.println(format.format(new Date()) + " " + socket1.toString());
          socket1.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        Socket socket2 = CommonSocket.getSocketByName("socket2");
        if(null != socket2){
          System.out.println(format.format(new Date()) + " " + socket2.toString());
          socket2.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        Thread.sleep(1000);
      } catch (Exception e) {

      }
    }
  }
}
