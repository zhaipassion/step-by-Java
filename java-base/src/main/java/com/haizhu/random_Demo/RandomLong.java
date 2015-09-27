package com.haizhu.random_Demo;

import java.util.Random;

/**
 *
 * @author Haizhu
 * @Question how to get a long number between 100 and 1000?
 */
public class RandomLong {
	public static void main(String[] args) {
		Random random = new Random();
		for(Integer i=0;i<10;i++){
			Long l = random.nextLong();
			System.out.println(l);
		}
		for(Integer i=0;i<10;i++){
			Integer in = random.nextInt(100);
			System.out.println(in);
		}
	}
}
