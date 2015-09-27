package com.bob.array.a01_init;

/**
 * @ClassName: InitArray 
 * @Description: 数组初始化的三种方法
 * @author HZ 
 * @date 2015年2月14日 上午12:04:57
 */
public class InitArray {
	public static void main(String[] args) {
		/**
		 * method one:
		 */
		String[] str = new String[3]; 
		str[0] = "Hello world !";

		/**
		 * method two:
		 */
		int[] intArray = new int[]{1,3,5,7};
		
		/**
		 * method three:
		 */
		String[] names = {"Tom","John"}; 
		
		/**
		 * test the three arrays:
		 */
		System.out.println(str[0]);
		for(int i=0;i<intArray.length;i++){
			System.out.println(intArray[i]);
		}
		for(int j=0;j<names.length;j++){
			System.out.println(names[j]);
		}
	}
}
