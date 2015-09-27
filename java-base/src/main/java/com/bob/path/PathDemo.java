package com.bob.path;

public class PathDemo {

    public static void main(String[] args) {
        // 当前类所运行的根目录
        String path = Class.class.getClass().getResource("/").getPath();
        System.out.println(path);
    }
}
