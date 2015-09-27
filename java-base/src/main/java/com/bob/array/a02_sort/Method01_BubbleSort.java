package com.bob.array.a02_sort;

public class Method01_BubbleSort {
	/**
	 * bubbleSort method
	 */
	public static void bubbleSort(Integer[] array){
		Integer temp = null;
		Integer count = 0;
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				count++;
			}
		}
		System.out.println("Interator times:"+ count +"\n");
	}
	
	public static void main(String[] args) {
		/**
		 * Get a random array.
		 */
		IntegerArray intArray = new IntegerArray();
		Integer[] array = intArray.getArray();
		
		/**
		 * execute the method:
		 */
		bubbleSort(array);

		/**
		 * print the result:
		 */
		intArray.printArray(array);
	}
}
