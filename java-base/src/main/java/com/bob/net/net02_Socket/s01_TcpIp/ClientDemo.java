package com.bob.net.net02_Socket.s01_TcpIp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) throws IOException {
		Socket client = null;
		BufferedReader buf = null;
		client = new Socket("localhost", 8888);
		buf = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		System.out.println(buf.readLine());
		buf.close();
		client.close();
	}
}
