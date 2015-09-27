package com.books.book01.chapter04.FinalModifier;

/**
 * @author Bob
 * @ClassName: FinalModifier
 * @Description: final修饰符范例
 * @chapter 4.3.9 Final实例域
 * @date 2015年2月15日 上午10:47:06
 */
public class FinalModifier {
    public static void main(String[] args) {
        final Integer a = 1;
        System.out.println("初始值：" + a);
        /**
         * 被final修饰符标记的变量a不能进行值的更改，否则提示： The final local variable a cannot be
         * assigned. It must be blank and not using a compound assignment
         * 但是，如果将这个final值作为参数传递给一个方法，那么在那个方法内部是可以对这个final值进行修改的，
         * 只是修改的值的作用域是这个方法内部，不会改变变量在别的地方的值。
         */
        changeFinalVariable(a);
        System.out.println("更改后：" + a);

        // 对象：
        People p = new People("HZ", 27);
        System.out.println(p.toString());
        ;
    }

    public static int changeFinalVariable(Integer i) {
        ++i;
        System.out.println(i);
        return i;
    }

}

class People {
    private final String name;
    private final Integer age;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // 使用final修饰符修饰之后，不能再使用setName方法了
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return "name: " + name + ", age:" + age;
    }
}
