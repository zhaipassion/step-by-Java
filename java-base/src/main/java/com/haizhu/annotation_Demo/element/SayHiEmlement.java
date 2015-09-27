package com.haizhu.annotation_Demo.element;

import com.haizhu.annotation_Demo.annotation.SayHiAnnotation;

/**
 * 要使用SayHiAnnotation的元素所在类 由于我们定义了只有方法才能使用我们的注解，我们就使用多个方法来进行测试
 * 
 * @author Johness
 * 
 */
public class SayHiEmlement {

	// 普通的方法
	public void SayHiDefault(String name) {
		System.out.println("Hi, " + name);
	}

	// 使用注解并传入参数的方法
	@SayHiAnnotation(paramValue = "Jack")
	public void SayHiAnnotation(String name) {
		System.out.println("Hi, " + name);
	}

	// 使用注解并使用默认参数的方法
	@SayHiAnnotation
	public void SayHiAnnotationDefault(String name) {
		System.out.println("Hi, " + name);
	}
}