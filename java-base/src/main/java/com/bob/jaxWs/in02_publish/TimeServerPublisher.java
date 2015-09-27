package com.bob.jaxWs.in02_publish;

import javax.xml.ws.Endpoint;

import com.bob.jaxWs.in01_server.TimeServerImpl;

/**
 * 服务发布类Publisher
 *
 * @author Bob
 */
public class TimeServerPublisher {
    public static void main(String[] args) {
        // 第一个参数是发布的URL
        // 第二个参数是SIB实现
        Endpoint.publish("http://127.0.0.1:10100/myweb", new TimeServerImpl());
    }
}
