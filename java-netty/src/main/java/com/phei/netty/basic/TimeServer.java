/*
 * Copyright 2013-2018 Lilinfeng.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phei.netty.basic;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author lilinfeng
 * @version 1.0
 * @date 2014年2月14日
 */
public class TimeServer {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {
        // 采用默认值
      }
    }
    new TimeServer().bind(port);
  }

  public void bind(int port) throws Exception {
    // NioEventLoopGroup：配置服务端的NIO线程组(Reactor线程组)，用于网络事件的处理
    // 创建两个线程组的原因是，一个用于接收客户端连接，一个用于SocketChannel的网络读写
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      // ServerBootstrap是Netty启动NIO服务端的辅助启动类，降低服务端开发复杂度
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup)
              // NioServerSocketChannel 对应JDK NIO中的ServerSocketChannel类
              .channel(NioServerSocketChannel.class)
              // 设置TCP参数：backlog=1024
              .option(ChannelOption.SO_BACKLOG, 1024)
              // ChildChannelHandler：事件处理类，作用类似于Reactor中的handler类
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                  ch.pipeline().addLast(new TimeServerHandler());
                }
              });

      System.out.println("我是来打酱油的~");

      // 绑定端口，同步等待成功
      ChannelFuture f = b.bind(port).sync();

      // 等待服务端监听端口关闭
      f.channel().closeFuture().sync();
    } finally {
      // 优雅退出，释放线程池资源
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }

}
