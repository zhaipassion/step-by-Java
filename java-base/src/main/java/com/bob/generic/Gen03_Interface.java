package com.bob.generic;

interface Inter<T> {
    void show(T t);
}

// 实现类指定具体的参数类型
class InterImpl implements Inter<String> {
    @Override
    public void show(String str) {
        System.out.println(str);
    }
}

// 实现类也是泛型
class InterImplT<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println("T:" + t);
    }
}

public class Gen03_Interface {
    public static void main(String[] args) {
        InterImpl i = new InterImpl();
        i.show("Hello world!");
        InterImplT<Integer> itInt = new InterImplT<Integer>();
        itInt.show(24);
        InterImplT<String> itStr = new InterImplT<String>();
        itStr.show("Hello world!");
    }
}
