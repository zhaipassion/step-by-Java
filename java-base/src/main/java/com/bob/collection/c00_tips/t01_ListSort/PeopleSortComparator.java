package com.bob.collection.c00_tips.t01_ListSort;

import java.util.Comparator;

public class PeopleSortComparator implements Comparator<People> {
    @Override
    public int compare(People dr1, People dr2) {
        // 数值类型直接比较大小
        int flag = dr1.getAge() - dr2.getAge();
        if (flag == 0) {
            // 字符串比较，使用compare方法
            flag = dr1.getName().compareTo(dr2.getName());
            // 也可用这种方法，忽略大小写
            flag = dr1.getName().compareToIgnoreCase(dr2.getName());
        }
        return flag;
    }
}
