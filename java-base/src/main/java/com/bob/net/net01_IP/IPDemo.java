package com.bob.net.net01_IP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
    public static void main(String[] args) {
        demo01();
        System.out.println("-------------------------分割线-------------------------");
        demo02();
        System.out.println("-------------------------分割线-------------------------");
        demo03();
    }

    private static void demo03() {
        try {
            InetAddress[] i = InetAddress.getAllByName("www.baidu.com");
            for (int m = 0; m < i.length; m++) {
                System.out.println("name:" + i[m].getHostName());
                System.out.println("address:" + i[m].getHostAddress());
                System.out.println("...........................");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void demo02() {
        try {
            InetAddress i = InetAddress.getByName("www.baidu.com");
            System.out.println("name:" + i.getHostName());
            System.out.println("address:" + i.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void demo01() {
        try {
            InetAddress i = InetAddress.getLocalHost();
            System.out.println(i);
            System.out.println("address:" + i.getHostAddress());
            System.out.println("name:" + i.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
