/**
 * 网络通讯的原理：
 * 1、找到对方的IP
 * 2、数据要发送到对方指定的应用程序上，为了标识这些应用程序，所以给这些网络应用程序
 * 都用数字进行标识，为了方便称呼这个数字，叫做端口（逻辑端口）。
 * 3、定义通信规则，这个通讯规则称为协议。国际组织定义了通用协议ICP/IP。
 * 
 * 两种方式：
 * UDP:不可靠
 * 1、将数据及源和目的封装成数据包中，不需要建立连接
 * 2、每个数据包的大小限制在64k内
 * 3、无连接，是不可靠协议
 * 4、速度快
 * 
 * TCP：可靠
 * 1、建立连接，想成传输数据的通道
 * 2、在连接中进行大数据量传输
 * 3、通过三次握手完成连接，是可靠协议
 * 4、必须建立连接，效率会稍低
 * 
 * 
 * java.net.*
 * 
 * @author Haizhu
 *
 */
package com.haizhu.net_Demo;