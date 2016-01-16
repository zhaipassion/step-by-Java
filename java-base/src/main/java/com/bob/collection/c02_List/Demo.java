package com.bob.collection.c02_List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 2015/11/3.
 */
public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 39; i++) {
            list.add(i + 1);
        }

        List<Integer> subList;
        Integer perCount = 10;// 每次处理的个数
        while (true) {
            if (list.size() > perCount) {
                subList = list.subList(0, perCount);
                list = list.subList(perCount, list.size());
                System.out.println(subList);
            } else {
                System.out.println(list);
                break;
            }
        }

    }

}
