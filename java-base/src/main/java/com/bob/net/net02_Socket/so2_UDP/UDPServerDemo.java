package com.bob.net.net02_Socket.so2_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerDemo {
    public static void main(String[] args) throws IOException {
        String str = "Hello world UDP!";
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        ds = new DatagramSocket(5000);
        dp = new DatagramPacket(str.getBytes(), 0, str.length(),
                InetAddress.getByName("localhost"), 8888);
        ds.send(dp);
        ds.close();
    }
}
