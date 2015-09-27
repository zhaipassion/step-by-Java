package com.bob.annotation.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bob.annotation.annotation.SayHiAnnotation;
import com.bob.annotation.element.SayHiEmlement;

public class AnnotionOperator {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ClassNotFoundException {
        SayHiEmlement element = new SayHiEmlement(); // 初始化一个实例，用于方法调用
        Method[] methods = SayHiEmlement.class.getDeclaredMethods(); // 获得所有方法

        for (Method method : methods) {
            SayHiAnnotation annotationTmp = null;
            if ((annotationTmp = method.getAnnotation(SayHiAnnotation.class)) != null) // 检测是否使用了我们的注解
                method.invoke(element, annotationTmp.paramValue()); // 如果使用了我们的注解，我们就把注解里的"paramValue"参数值作为方法参数来调用方法
            else
                method.invoke(element, "Rose"); // 如果没有使用我们的注解，我们就需要使用普通的方式来调用方法了
        }
    }
}