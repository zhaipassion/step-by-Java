package com.bob.collection.c04_Map;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        // map 可以使用 null 作为 key键 存储
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "HZ");
        map.put("A", "AA");
        System.out.println(map.size());
        System.out.println(map.keySet().toString());
        System.out.println(map.get(null));
    }
}
