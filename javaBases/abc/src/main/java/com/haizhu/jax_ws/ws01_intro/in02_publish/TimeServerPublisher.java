package com.haizhu.jax_ws.ws01_intro.in02_publish;

import javax.xml.ws.Endpoint;

import com.haizhu.jax_ws.ws01_intro.in01_server.TimeServerImpl;

/**
 * 服务发布类Publisher
 * 
 * @author HZ
 * 
 */
public class TimeServerPublisher {
	public static void main(String[] args) {
		// 第一个参数是发布的URL
		// 第二个参数是SIB实现
		Endpoint.publish("http://127.0.0.1:10100/myweb", new TimeServerImpl());
	}
}
