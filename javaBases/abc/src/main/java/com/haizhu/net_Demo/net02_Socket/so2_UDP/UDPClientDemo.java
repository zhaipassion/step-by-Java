package com.haizhu.net_Demo.net02_Socket.so2_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClientDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		byte[] message = new byte[1024];
		ds = new DatagramSocket(8888);
		dp = new DatagramPacket(message, message.length);
		ds.receive(dp);
		String str = new String(dp.getData(),0,dp.getLength());
		System.out.println(str);
		ds.close();
	}
}
