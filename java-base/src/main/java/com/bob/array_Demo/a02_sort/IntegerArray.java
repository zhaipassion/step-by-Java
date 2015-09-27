package com.bob.array_Demo.a02_sort;

import java.util.Random;

public class IntegerArray {
	/**
	 * initialize the array with 10 number
	 */
	private Integer arrLength = 20;
	private Integer[] array = new Integer[arrLength];

	IntegerArray(){
		Random random = new Random();
		System.out.println("The random array:");
		for(int x=0;x<arrLength;x++){
			array[x] = random.nextInt(100);
			System.out.print(array[x] + "  ");
		}
		System.out.println("\n");
	}
	
	public Integer[] getArray() {
		return array;
	}
	
	public void printArray(Integer[] array){
		System.out.println("The sort result:");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i] + "  ");
		}
	}
	
}
