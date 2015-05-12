package com.books.book01.chapter03.Message;

/**
 * @ClassName: Message
 * @Description: 命令行参数：运行的时候输入参数，传给main函数
 * @author HZ
 * @date 2015年2月15日 上午12:43:21
 */
public class Message {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("运行此main函数时，请输入参数！");
		} else {
			if (args[0].equals("-h")) {
				System.out.print("Hello,");
			} else if (args[1].equals("-g")) {
				System.out.print("GoodBye,");
			}
			for (int i = 1; i < args.length; i++) {
				System.out.print(" " + args[i]);
			}
			System.out.println("!");
		}
	}
}