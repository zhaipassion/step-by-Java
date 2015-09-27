package com.bob.collection_Demo.c02_List;

import java.util.LinkedList;

/**
 * 注释的是原始的操作方法，本范例中使用的是JDK1.6开始升级的方法
 * 区别在于，以前的remove方法如果没有值会抛出None异常，现在的
 * 方法如果没有取到值会返回null
 * @author Haizhu
 *
 */
public class list02_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<String>();
		/**
		 * link.addFirst("link01");
		 * link.addFirst("link02");
		 * link.addFirst("link03");
		 * link.addFirst("link04");
		 * link.addFirst("link05");
		 */
		link.offerFirst("link01");
		link.offerFirst("link02");
		link.offerFirst("link03");
		link.offerFirst("link04");
		link.offerFirst("link05");
		System.out.println(link);
		/**
		 * System.out.println(link.getFirst());
		 * System.out.println(link.getLast());
		 */
		System.out.println(link.pollFirst());
		System.out.println(link.pollLast());
		/**
		 * System.out.println(link.removeFirst());
		 */
		System.out.println(link.peekFirst());
		System.out.println(link);
		/**
		 * System.out.println(link.removeLast());
		 */
		System.out.println(link.peekLast());
		System.out.println(link);
		/**
		 * 遍历
		 */
		while(!link.isEmpty()){
			String element = link.pollFirst();
			System.out.println(element);
		}
	}
}
