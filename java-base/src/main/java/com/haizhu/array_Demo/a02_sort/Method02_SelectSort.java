package com.haizhu.array_Demo.a02_sort;

public class Method02_SelectSort {
	/**
	 * selectSort method 
	 */
	public static void selectSort(Integer[] array){
		// the "temp" should out of the "for" iterator
		Integer temp = null;
		Integer count = 0;
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				count++;
			}
		}
		System.out.println("iterator times: "+ count +"\n");
	}
	
	/**
	 * Test the result:
	 */
	public static void main(String[] args) {
		/**
		 * Get a random array.
		 */
		IntegerArray intArray = new IntegerArray();
		Integer[] array = intArray.getArray();
		
		/**
		 * execute the method:
		 */
		selectSort(array);

		/**
		 * print the result:
		 */
		intArray.printArray(array);
	}
}
