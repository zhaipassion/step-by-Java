
# 语法
## 参数类型声明可选
1.Declaring the types of the parameters is optional.
## 如果只有一个参数，圆括号可选
2.Using parentheses around the parameter is optional if you have only one parameter.
## 如果只有一个表达式，花括号可选
3.Using curly braces is optional (unless you need multiple statements).
## 如果只有一个表达式，return关键字可选
4.The “return” keyword is optional if you have a single expression that returns a value.

# 范例
*  () -> System.out.println(this)
*  (String str) -> System.out.println(str)
*  str -> System.out.println(str)
*  (String s1, String s2) -> { return s2.length() - s1.length(); }
*  (s1, s2) -> s2.length() - s1.length()

最后一种实际使用范例:
Arrays.sort(strArray, (String s1, String s2) -> s2.length() - s1.length());
表示实现Comparator接口，根据字符串长度排序。
Bob:
这个范例中，在需要Comparator接口实例对象的地方，直接使用 “()-> ……” lambda表达式来实现匿名内部类


# 问题
* lambda表达式的作用？

Bob：
1.在java中，lambda表达式主要来实现匿名内部类。在Python语言中，可是实现匿名函数。
2.
