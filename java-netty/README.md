1. 须将lib加入项目依赖路径




范例顺序

1.传统bio编程：同步阻塞式IO
bio

2.伪异步IO编程
pio - client使用bio中的TimeClient.java

3.NIO编程
nio - 非阻塞IO

4.AIO编程
基于NIO2.0的异步非阻塞IO

5.Netty初步
basic

6.黏包范例
frame.fault

7.修正黏包范例
frame.correct

8.delimiter黏包解决方案
frame.delimiter -- 服务端和客户端可以使用不同的分隔符，只要符合自己定义的解析要求就能解析，互不影响

9.fixedLen黏包解决方案
frame.fixedLen -- 定长截取

10.编解码codec
10.1.JDK序列化和字节序列化大小对比
codec.serializable.TestUserInfo
10.2.JDK序列化和字节序列化性能对比
codec.serializable.PerformTestUserInfo
10.3.netty序列化范例
serializable.netty

11.谷歌编解码工具protobuf
codec.protobuf

12.Jboss编解码工具marshalling
codec.marshalling

13.http协议实现
protocol.http

14.WS协议实现
protocol.websocket.server

15.UDP协议实现
protocol.udp

16.文件传输
protocol.file

17.私有协议
protocol.netty

18.





