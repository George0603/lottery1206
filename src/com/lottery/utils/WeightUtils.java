package com.lottery.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 权重工具类
 */
public class WeightUtils {

	private WeightUtils() {
		throw new IllegalStateException("Algorithm class");
	}

	public static Map<Integer, Integer> weightFactory() {
		Map<Integer, Integer> weightMap = new HashMap<>();
		weightMap.put(0, 7);
		weightMap.put(1, 6);
		weightMap.put(2, 5);
		weightMap.put(3, 4);
		weightMap.put(4, 3);
		weightMap.put(5, 2);
		weightMap.put(6, 1);
		return weightMap;
	}

	public static Integer getNumByWeight() {
		Map<Integer, Integer> weightMap = weightFactory();
		// 根据权重，制造容器
		Map<Integer, Integer> container = new HashMap<>();
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : weightMap.entrySet()) {
			Integer num = entry.getKey();
			Integer weight = entry.getValue();
			for (int i = 0; i < weight; i++) {
				container.put(index, num);
				index++;
			}
		}
		Integer random = new Random().nextInt(index);
		return container.get(random);
	}
}
