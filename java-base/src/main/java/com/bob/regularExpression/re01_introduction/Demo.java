package com.bob.regularExpression.re01_introduction;

public class Demo {
    public static void main(String[] args) {
        String qq = "122111111111";
        /**
         * 默认一个中括号表示 一个占位符，如果后面有大括号，则大括号之间的数字是规定的位数
         */
        String regex = "[1-9][0-9]{2,10}";
        Boolean flag = qq.matches(regex);
        if (flag) {
            System.out.println("QQ合法！");
        } else {
            System.out.println("QQ不合法！");
        }
    }
}
