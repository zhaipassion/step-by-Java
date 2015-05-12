package com.haizhu.reflect_Demo.rf00_args;

import java.util.Date;

/**
 * @ClassName: 可变长参数 
 * @Description: TODO(描述) 
 * @author ZhuHongbo 
 * @date 2014年1月7日 下午9:36:56
 */
public class Demo {
	/** 可变长参数等同于数组 */
	public static void method(String... args){
		System.out.println("遍历开始：");
		for(int i=0;i<args.length;i++){
			System.out.print(args[i]);
		}
		System.out.println("\n------------------------------");
	}

	/** 如果有精确匹配的就会调用精确匹配的方法：如果有且只有一个参数就会调用这个方法 */
	public static void method(String str){
		System.out.println("精确匹配："+str);
		System.out.println("------------------------------");
	}
	
	/** class 类型的可变长参数 */
	public static void classMethod(Class<?>... args) throws Exception{
		System.out.println("\n\nclassMethod test:");
		for(int i=0;i<args.length;i++){
			Class<?> clazz = args[i];
			System.out.println(clazz.newInstance());
			System.out.println("------------------------------");
		}
	}
	
	/** 不同类型的可变长参数：只能有一个可变长参数，且只能放在最后 */
	public static void multyMthod(String name,Integer... score){
		System.out.print("\n\nmultyMethod test:");
		System.out.println("姓名："+name+"\n分数：");
		for(int i=0;i<score.length;i++){
			System.out.print(score[i]+"、");
		}
	}
	
	public static void main(String[] args) throws Exception {
		method();
		method("a");
		method("a","b");
		method("a","b","c");

		String[] str = {"a","b","c","d"};
		method(str);

		classMethod(Date.class);

		multyMthod("John",90,80,100);
	
	}
}
