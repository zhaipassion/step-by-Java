package com.haizhu.generic_Demo;

public class Gen01_Introduction {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/**
		 * Object
		 */
		Tool t = new Tool();
		t.setObj(new Student());
		Worker w = (Worker)t.getObj();
		/**
		 * Generic
		 */
		Utils<Worker> u = new Utils<Worker>();
		u.setGd(new Worker());
		Worker wor = u.getGd();
	}
}
/**
 * 没有泛型的时候使用Object
 * @author Haizhu
 */
class Tool{
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
/**
 * 使用泛型
 * @author Haizhu
 * @param <GenericDemo>
 */
class Utils<GenericDemo>{
	private GenericDemo gd;
	public GenericDemo getGd() {
		return gd;
	}
	public void setGd(GenericDemo gd) {
		this.gd = gd;
	}
}

class Student{
	
}
class Worker{
	
}