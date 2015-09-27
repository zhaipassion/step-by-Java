package com.bob.net.net02_Socket.s01_TcpIp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket client = null;
		PrintWriter out = null;
		server = new ServerSocket(8888);
		// 客户端需要new，但是服务端只需要accept()就可以了
		client = server.accept();
		out = new PrintWriter(client.getOutputStream());
		out.println("Hello world!");
		// 记得刷新或者关闭，不然客户端取不到值
		out.close();
		server.close();
		client.close();
	}
}
