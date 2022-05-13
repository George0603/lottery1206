package com.lottery.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utils class");
	}

	// 判断偶数个数
	public static boolean checkEvenNum(List<Integer> redNumList, int minLimit) {
		int evenNum = 0;
		int oddNum = 0;

		for (Integer n : redNumList) {
			if (n % 2 == 0)
				evenNum++;
			else
				oddNum++;
		}
		return evenNum < minLimit || oddNum < minLimit;
	}

	/**
	 * 将集合转换为数组
	 * 
	 * @param <T>
	 * 
	 * @param hList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] listToArray(List<T> hList, Class<T> componentType) {
		T[] temp = (T[]) Array.newInstance(componentType, hList.size());
		for (int i = 0; i < hList.size(); i++) {
			temp[i] = hList.get(i);
		}
		return temp;
	}

	/**
	 * 随机指定范围内N个不重复的数 利用HashSet的特征，只能存放不同的值
	 * 
	 * @param min
	 *            指定范围最小值
	 * @param max
	 *            指定范围最大值
	 * @param n
	 *            随机数个数
	 * @param HashSet<Integer>
	 *            set 随机数结果集
	 */
	public static Set<Integer> randomSet(int min, int max, int n, Set<Integer> set) {
		if (max < min || (set.size() + (max - min) < n))
			return Collections.emptySet();
		while (set.size() < n) {
			// 调用Math.random()方法
			int num = new Random().nextInt(max - min) + min;
			set.add(num);// 将不同的数存入HashSet中
		}
		return set;
	}

	/**
	 * 胆拖号所有组合的和
	 * 
	 * @param type:1-双色球,2-七彩乐
	 */
	public static List<Integer> getSumList(List<Integer> danNumList, List<Integer> tuoNumList, List<NumLastAppear> redNumLastList, int type) {
		int danNumSize = danNumList.size();
		int tuoNumSize = tuoNumList.size();
		if (danNumSize > 5 || tuoNumSize < 2 || danNumSize + tuoNumSize < 7)
			return Collections.emptyList();
		// 所需拖码个数
		int aidNum = type == 1 ? 6 - danNumSize : 7 - danNumSize;
		// 所有拖码可组成的集合
		List<List<Integer>> allTuoNumList = getAllCombination(tuoNumList, aidNum);
		// 所有红球号码组合
		List<List<Integer>> allNumList = getAllNumList(danNumList, allTuoNumList);
		List<Integer> sumList = new ArrayList<>();
		for (List<Integer> redNumList : allNumList) {
			int sum = 0;
			for (Integer redNum : redNumList) {
				Integer rank = getRankingByNum(redNumLastList, redNum);
				sum += (redNum + rank);
			}
			sumList.add(sum);
		}
		Collections.sort(sumList);
		// logger.info("胆拖所有组合如下：【" + StringUtils.join(allNumList, ",") + "】,对应双和为【" + StringUtils.join(sumList, ",") + "】。")
		return sumList;
	}

	public static Integer getRankingByNum(List<NumLastAppear> redNumLastList, Integer redNum) {
		for (NumLastAppear n : redNumLastList) {
			if (redNum.equals(n.getNum()))
				return n.getRanking();
		}
		return null;
	}

	/**
	 * 获取某个数组的指定个数的所有组合
	 * 
	 * @param tuoNumList
	 *            数组集合
	 * @param size
	 *            组合的数目
	 * @return
	 */
	public static List<List<Integer>> getAllCombination(List<Integer> numList, int size) {
		if (CollectionUtils.isEmpty(numList) || size > numList.size())
			return Collections.emptyList();
		List<List<Integer>> resultList = new ArrayList<>();
		if (numList.size() == size) {
			resultList.add(numList);
		} else if (size == 1) {
			List<Integer> result = null;
			for (Integer i : numList) {
				result = new ArrayList<>();
				result.add(i);
				resultList.add(result);
			}
		} else {
			for (int i = 0; i < numList.size(); i++) {
				Integer first = numList.get(i);
				List<Integer> partList = getPartList(numList, i + 1, numList.size());
				List<List<Integer>> tempList = getAllCombination(partList, size - 1);
				if (CollectionUtils.isNotEmpty(tempList)) {
					for (List<Integer> t : tempList) {
						t.add(first);
						Collections.sort(t);
						resultList.add(t);
					}
				}
			}
		}
		return resultList;
	}

	public static List<Integer> getPartList(List<Integer> numList, int start, int end) {
		List<Integer> resultList = new ArrayList<>();
		for (int i = start; i < end; i++) {
			resultList.add(numList.get(i));
		}
		return resultList;
	}

	public static List<List<Integer>> getAllNumList(List<Integer> danNumList, List<List<Integer>> allTuoNumList) {
		List<List<Integer>> allNumList = new ArrayList<>();
		for (List<Integer> t : allTuoNumList) {
			t.addAll(danNumList);
			Collections.sort(t);
			allNumList.add(t);
		}
		return allNumList;
	}
}
