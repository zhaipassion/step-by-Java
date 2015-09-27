package com.haizhu.ABC;

import java.util.Map;

public class ABC {
	public static void main(String[] args) {
	}

	public static Integer sum(Map<String,Integer> map){
		int sum = 0;
		for(Integer i: map.values()){
			sum += i;
		}
		return sum;
	}
}
