package com.bob.clazz.inCl01_UnStaticVariableInnerClass;

public class Outer {
    public static void main(String[] args) {
        // 使用内部类方法1：
        Outer Outter = new Outer();
        Outer.Inner inner = Outter.new Inner();
        inner.print("Outter.new");

        // 使用内部类方法2：
        inner = Outter.getInner();
        inner.print("Outter.get");
    }

    private final String name = "Haizhu";

    /**
     * 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 这么做也符合面向对象的思想，将内部类作为外部类的一个属性。
     *
     * @return 内部类的初始化实例
     */
    public Inner getInner() {
        return new Inner();
    }

    /**
     * 要注意的是，成员内部类不能含有static的变量和方法。因为成员内部类需要先创建了外部类，才能创建它自己的，在成员内部类要引用外部类对象时，
     * 使用Outter.this来表示外部类对象
     *
     * @author Bob
     */
    public class Inner {
        public void print(String str) {
            /**
             * 内部类可以直接访问外部类的属性--name,用外围类创建内部类对象时，此内部类对象会秘密的捕获一个指向外围类的引用，于是，
             * 可以通过这个引用来访问外围类的成员。
             * 通常，这些都是编译器来处理，我们看不到，也不用关心这个。正是因为如此，我们创建内部类对象时，必须与外围类对象相关联。
             */
            System.out.println(str + name);
        }
    }
}