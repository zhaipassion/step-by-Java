package com.bob.properties.pro01_PropertiesClass;

import java.util.Properties;
import java.util.Set;

public class PC01_Introduction {
    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("NO.1", "Tom");
        pro.setProperty("NO.2", "John");
        pro.setProperty("NO.3", "Alex");
        Set<String> names = pro.stringPropertyNames();
        for (String name : names) {
            /**
             * 打印到控制台
             * Print to the console
             */
            System.out.println(pro.getProperty(name));
        }
    }
}
