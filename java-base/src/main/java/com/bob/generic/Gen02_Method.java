package com.bob.generic;

public class Gen02_Method {
	public static void main(String[] args) {
		GenericClass<String> gc = new GenericClass<String>();
		// 只能传入String类型
		gc.show("Hello world!");
		gc.print("24");
		GenericMethod gm = new GenericMethod();
		// 可以传入任意类型
		gm.show("Hello world!");
		gm.show(24);
		gm.print("Hello world!");
		gm.print(24);
	}
}

/**
 * 在类中定义泛型：在初始化的时候就设定了可以传入方法的数据类型，且只有一种
 * 比如，使用集合（Collection）的时候
 * @author Haizhu
 * @param <T>
 */
class GenericClass<T>{
	public void show(T t){
		System.out.println("show:"+t);
	}
	public void print(T t){
		System.out.println("print:"+t);
	}
	/* 以前需要设定特定的类型
	public void show(String str){
		System.out.println("show(String)"+str);
	}
	public void show(Integer inte){
		System.out.println("show(Integer)"+inte);
	}
	*/
}
/**
 * 在方法中定义泛型：可以将任意类型的参数传入方法
 * @author Haizhu
 * @param <T>
 * @param <S>
 */
class GenericMethod{
	public <T> void show(T t){
		System.out.println("show:"+t);
	}
	public <S> void print(S s){
		System.out.println("print:"+s);
	}
	/**
	 * 静态方法不可以使用类中定义的泛型，只能使用泛型方法。
	 */
	public static <W> void method(W w){
		System.out.println("static:"+w);
	}
}