package com.bob.reflect.rf02_newInstance;

import com.bob.reflect.Student;

/**
 * @author Bob
 * @ClassName: 通过反射取得类型，之后创建对象
 * @Description: TODO(描述)
 * @date 2014年1月7日 上午12:07:04
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        // 使用newInstance()必须要有无参构造方法
        Object obj = (Student) clazz.newInstance();
        // 操作初始化对象
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            stu.setName("Tom");
            stu.setAge(24);
            System.out.println(stu);
        }
    }
}
