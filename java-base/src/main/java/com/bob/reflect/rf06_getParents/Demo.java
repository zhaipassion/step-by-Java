package com.bob.reflect.rf06_getParents;

/**
 * @author ZhuHongbo
 * @ClassName: 获取反射类的父类和父接口
 * @Description: TODO(描述)
 * @date 2014年1月8日 下午8:09:46
 */
public class Demo {
    public static void main(String[] args) {
        String className = "Student";
        String stringName = "java.lang.String";
        try {
            getParent(className);
            System.out.println("-----------------------------");
            getParent(stringName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getParent(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        /** 父类 */
        Class<?> superClazz = clazz.getSuperclass();
        /** 接口 */
        Class<?>[] interfaceClazz = clazz.getInterfaces();

        System.out.println(superClazz + "\n" + interfaceClazz);
    }
}
