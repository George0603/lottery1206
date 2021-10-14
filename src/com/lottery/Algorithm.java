package com.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 预测结果算法 蓝色球从1到16中选1个 红色球从1到33中选6个
 */

public class Algorithm {

	private Algorithm() {
		throw new IllegalStateException("Algorithm class");
	}

	/**
	 * 红球： 从红球排名结果中选取结果： 1-3名选1个； 4-9名选1个； 10-29名选2个； 30-33名选1个； 1-33里选剩的随机选1个；<br/>
	 * 蓝球：从排名前4中选两个
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceMultiResult algorithm1014(HistoryRecord[] recordList) {
		ChoiceMultiResult choiceResult = new ChoiceMultiResult();
		choiceResult.setBlueNum(getTwoBlueNum(recordList));
		choiceResult.setRedNumList(getRedNumList(recordList));
		return choiceResult;
	}

	/**
	 * 红球： 从红球排名结果中选取结果： 1-3名选1个； 4-9名选1个； 10-29名选2个； 30-33名选1个； 1-33里选剩的随机选1个；<br/>
	 * 蓝球：直接取最久未出现的那一个
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceResult algorithm1213(HistoryRecord[] recordList) {
		ChoiceResult choiceResult = new ChoiceResult();
		// 获取蓝球统计结果
		// 选中蓝球中出现次数最多的那个号码
		choiceResult.setBlueNum(getBlueNum(recordList));
		choiceResult.setRedNumList(getRedNumList(recordList));
		return choiceResult;
	}

	/**
	 * 红球： 从红球排名结果中选取结果： 1-3名选1个； 4-9名选1个； 10-29名选2个； 30-33名选1个； 1-33里选剩的随机选1个；
	 */
	public static List<Integer> getRedNumList(HistoryRecord[] recordList) {
		List<Integer> redNumList = new ArrayList<>();
		// 获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		// 记录已经选中序号
		List<Integer> redIndex = new ArrayList<>();
		// 从1-3名选1个
		int c1 = new Random().nextInt(3);
		redIndex.add(c1);
		// 从4-9名选1个
		int c2 = new Random().nextInt(6) + 3;
		redIndex.add(c2);
		// 从30-33名选1个
		int c3 = new Random().nextInt(4) + 29;
		redIndex.add(c3);
		// 从10-29名选2个
		Set<Integer> t = new HashSet<>();
		t = randomSet(9, 29, 2, t);
		for (Integer temp : t) {
			redIndex.add(temp);
		}
		// 从1-33里随机1个；
		int c6 = randomFromOutSideList(redIndex);
		redIndex.add(c6);
		// 6个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			redNumList.add(redNumLastList.get(i).getNum());
		}
		return redNumList;
	}

	/**
	 * 获取蓝球算法：从排名前4中选两个
	 */
	public static List<Integer> getTwoBlueNum(HistoryRecord[] recordList) {
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		// 记录已经选中序号
		List<Integer> blueIndex = new ArrayList<>();
		// 从10-29名选2个
		Set<Integer> t = new HashSet<>();
		t = randomSet(0, 4, 2, t);
		for (Integer temp : t) {
			blueIndex.add(blueNumLastList.get(temp).getNum());
		}
		return blueIndex;
	}

	/**
	 * 获取蓝球算法
	 */
	public static int getBlueNum(HistoryRecord[] recordList) {
		// 获取蓝球统计结果
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		// 直接获取最久未出现的号码
		return blueNumLastList.get(0).getNum();
	}

	/**
	 * 预测基本算法1
	 */
	public static ChoiceResult choiceNum(HistoryRecord[] recordList) {
		ChoiceResult result = new ChoiceResult();
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		result.setBlueNum(blueNumLastList.get(0).getNum());
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			temp.add(redNumLastList.get(i).getNum());
		}
		result.setRedNumList(temp);
		return result;
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
		if (n > (max - min + 1) || max < min)
			return Collections.emptySet();
		for (int i = 0; i < n; i++) {
			int setSize = set.size();
			if (setSize < n) {
				// 调用Math.random()方法
				int num = (int) (Math.random() * (max - min)) + min;
				set.add(num);// 将不同的数存入HashSet中
			}
		}
		int setSize = set.size();
		// 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
		if (setSize < n) {
			set = randomSet(min, max, n, set);// 递归
		}
		return set;
	}

	public static void main(String[] args) {
		Set<Integer> t = new HashSet<>();
		t = randomSet(0, 3, 2, t);
		for (Integer i : t) {
			System.out.println(i);
		}
	}

	public static Integer randomFromOutSideList(List<Integer> list) {
		// 从0到32里随机选择一个数
		Integer result = new Random().nextInt(33);
		// 如果List里面已经有这个数了，则随机选
		if (list.contains(result)) {
			result = randomFromOutSideList(list);
		}
		return result;
	}
}
