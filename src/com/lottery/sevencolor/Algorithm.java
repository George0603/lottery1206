package com.lottery.sevencolor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.lottery.utils.NumLastAppear;
import com.lottery.utils.Utils;

public class Algorithm {

	public static final int TOTAL_NUM = 30;

	public static final int MID_SUM = 200;

	public static final int MIN_SUM = 179;
	// 红球允许的最小值
	public static final int MIN_NUM = 8;
	// 红球最大值的最小值
	public static final int MAX_NUM = 25;

	public static final int SUM_DIFF = 30;

	public static final List<Integer> EXCEPTLIST = Arrays.asList(3, 23);

	private Algorithm() {
		throw new IllegalStateException("Algorithm class");
	}

	public static ChoiceResult get7Num() {
		ChoiceResult result = new ChoiceResult();
		result.setNumList(getNum7());
		return result;
	}

	/**
	 * 胆码5个：1-8 1个；9-25,3个；26-30,1个 <br>
	 * 拖码4个：1-5 1个；6-12,1个；13-20,1个；21-30,1个
	 * 
	 * @return
	 */
	public static ChoiceDanTuoResult danTuoWay7() {
		ChoiceDanTuoResult choiceResult = new ChoiceDanTuoResult();
		List<Integer> redNumList = new ArrayList<>();
		// 胆码集合
		List<Integer> danNumList = new ArrayList<>();
		HistoryRecord[] hs = HistoryRecord.values();
		// 获取排名结果
		List<NumLastAppear> numLastList = getNumDetail(hs);
		// 记录已经选中序号
		Set<Integer> redIndex = new HashSet<>();
		// 1-6 1个；
		redIndex = Utils.randomSet(0, 6, 1, redIndex);
		// 7-15 1个；
		redIndex = Utils.randomSet(6, 15, 2, redIndex);
		// 9-25,2个
		redIndex = Utils.randomSet(8, 25, 4, redIndex);
		// 23-30,1个
		redIndex = Utils.randomSet(22, 30, 5, redIndex);
		// 5个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			danNumList.add(numLastList.get(i).getNum());
		}
		// 拖码集合
		List<Integer> tuoNumList = new ArrayList<>();
		// 1-10 1个；
		redIndex = Utils.randomSet(0, 10, 6, redIndex);
		// 11-20,1个；
		redIndex = Utils.randomSet(10, 20, 7, redIndex);
		// 21-30,1个
		redIndex = Utils.randomSet(20, 30, 8, redIndex);
		List<Integer> rankList = new ArrayList<>();
		for (Integer i : redIndex) {
			redNumList.add(numLastList.get(i).getNum());
			rankList.add(numLastList.get(i).getRanking());
		}
		// 新增的为拖码
		for (Integer n : redNumList) {
			if (!danNumList.contains(n))
				tuoNumList.add(n);
		}
		Collections.sort(redNumList);
		Collections.sort(rankList);
		if (checkConstains(redNumList) || !checkSort(redNumList) || !checkMinMax(redNumList) || checkLastRedNum(redNumList) || !checkSumList(danNumList, tuoNumList, numLastList, redNumList))
			return danTuoWay7();
		// 校验是否满足情况
		choiceResult.setDanNumList(danNumList);
		choiceResult.setTuoNumList(tuoNumList);
		return choiceResult;
	}

	private static boolean checkConstains(List<Integer> redNumList) {
		for (Integer num : redNumList) {
			if (EXCEPTLIST.contains(num))
				return true;
		}
		return false;
	}

	public static boolean checkSort(List<Integer> redNumList) {
		int sortNum = 0;
		int intervalNum = 0;
		for (int i = 1; i < redNumList.size(); i++) {
			int last = redNumList.get(i - 1);
			int now = redNumList.get(i);
			if (now - last == 1)
				sortNum++;
			else if (now - last == 2)
				intervalNum++;
		}
		// 是否存在两个连续
		return sortNum < 2 && intervalNum < 4;
	}

	/**
	 * 胆码5个：1-8 1个；9-25,3个；26-30,1个 <br>
	 * 拖码4个：1-5 1个；6-12,1个；13-20,1个；21-30,1个
	 * 
	 * @return
	 */
	public static ChoiceDanTuoResult danTuoWay8() {
		ChoiceDanTuoResult choiceResult = new ChoiceDanTuoResult();
		List<Integer> redNumList = new ArrayList<>();
		// 胆码集合
		List<Integer> danNumList = new ArrayList<>();
		HistoryRecord[] hs = HistoryRecord.values();
		// 获取排名结果
		List<NumLastAppear> numLastList = getNumDetail(hs);
		// 记录已经选中序号
		Set<Integer> redIndex = new HashSet<>();
		// 1-6 1个；
		redIndex = Utils.randomSet(0, 6, 1, redIndex);
		// 7-15 1个；
		redIndex = Utils.randomSet(6, 15, 2, redIndex);
		// 9-25,2个
		redIndex = Utils.randomSet(8, 25, 4, redIndex);
		// 23-30,1个
		redIndex = Utils.randomSet(22, 30, 5, redIndex);
		// 5个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			danNumList.add(numLastList.get(i).getNum());
		}
		// 拖码集合
		List<Integer> tuoNumList = new ArrayList<>();
		// 1-5 1个；
		redIndex = Utils.randomSet(0, 5, 6, redIndex);
		// 6-12,1个；
		redIndex = Utils.randomSet(5, 12, 7, redIndex);
		// 13-20,1个；
		redIndex = Utils.randomSet(12, 20, 8, redIndex);
		// 21-30,1个
		redIndex = Utils.randomSet(20, 30, 9, redIndex);
		List<Integer> rankList = new ArrayList<>();
		for (Integer i : redIndex) {
			redNumList.add(numLastList.get(i).getNum());
			rankList.add(numLastList.get(i).getRanking());
		}
		// 新增的为拖码
		for (Integer n : redNumList) {
			if (!danNumList.contains(n))
				tuoNumList.add(n);
		}
		Collections.sort(redNumList);
		Collections.sort(rankList);
		if (!checkMinMax(redNumList) || checkLastRedNum(redNumList) || !checkSumList(danNumList, tuoNumList, numLastList, redNumList))
			return danTuoWay8();
		// 校验是否满足情况
		choiceResult.setDanNumList(danNumList);
		choiceResult.setTuoNumList(tuoNumList);
		return choiceResult;
	}

	public static boolean checkSumList(List<Integer> danNumList, List<Integer> tuoNumList, List<NumLastAppear> numLastList, List<Integer> redNumList) {
		List<Integer> sumList = Utils.getSumList(danNumList, tuoNumList, numLastList, 2);
		for (Integer sum : sumList) {
			if (sum < MIN_SUM)
				return false;
		}
		// 必须有一个小于200
		// if (sumList.get(0) >= MID_SUM)
		// return false;
		// 后面都是大于200的
		if (sumList.get(1) <= MID_SUM)
			return false;
		// 最小和最大的和要相差20以上
		if (sumList.get(sumList.size() - 1) - sumList.get(0) <= SUM_DIFF)
			return false;

		PrintUtils.RESULT_INFO_LIST.add("胆拖所有组合双和为【" + StringUtils.join(sumList, ",") + "】，红色号码为【" + StringUtils.join(redNumList, ",") + "】。");
		return true;
	}

	/**
	 * 获取7个号码<br>
	 * 1-4 选1个<br>
	 * 5-10选1个<br>
	 * 26-30选1个 <br>
	 * 11-25选3个 <br>
	 * 1-9或23-30 选1个<br>
	 */
	public static List<Integer> getNum7() {
		List<Integer> redNumList = new ArrayList<>();
		HistoryRecord[] hs = HistoryRecord.values();
		// 获取排名结果
		List<NumLastAppear> numLastList = getNumDetail(hs);
		// 记录已经选中序号
		Set<Integer> redIndex = getFixedNum();
		// 11-25选3个
		redIndex = Utils.randomSet(10, 25, 6, redIndex);
		// 1-10或23-30 选1个
		redIndex = getSpecialNum(7, redIndex);
		// 7个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			redNumList.add(numLastList.get(i).getNum());
		}
		Collections.sort(redNumList);
		if (!checkOtherCondition(redNumList, redIndex, numLastList))
			return getNum7();
		return redNumList;
	}

	// 校验额外的条件
	public static boolean checkOtherCondition(List<Integer> redNumList, Set<Integer> redIndex, List<NumLastAppear> redNumLastList) {
		if (!checkMinMax(redNumList))
			return false;
		List<Integer> indexList = new ArrayList<>();
		int sum = 0;
		// 红球之和和排名之和，大于180
		for (Integer i : redIndex) {
			// 红球号码
			int n = redNumLastList.get(i).getNum();
			int r = redNumLastList.get(i).getRanking();
			sum += (n + r);
			indexList.add(r);
		}
		if (sum < MIN_SUM)
			return false;
		if (checkLastRedNum(redNumList))
			return false;
		// Comparator.reverseOrder()
		// List<Integer> collect = redIndex.stream().sorted().collect(Collectors.toList())
		Collections.sort(indexList);
		// NORMALINFOLIST.add("红球之和和排名之和:" + sum + "，红球排序：【" + StringUtils.join(indexList, ",") + "】")
		PrintUtils.RESULT_INFO_LIST.add("号码之和和排名之和【" + sum + "】.");
		return true;
	}

	// 校验如果最后一个红球号码，和最新一期的红球号码相同，则重新选择
	public static boolean checkLastRedNum(List<Integer> redNumList) {
		HistoryRecord[] recordList = HistoryRecord.values();
		// 获取本次选择号码的最后一个号码
		Integer newestNum = redNumList.get(redNumList.size() - 1);
		// 历史记录最新的
		String[] redNumStr = recordList[0].getRedNum().split(",");
		Integer lastesNum = Integer.valueOf(redNumStr[redNumStr.length - 1]);
		// 判断是否相等
		return newestNum.equals(lastesNum);
	}

	public static boolean checkMinMax(List<Integer> redNumList) {
		Integer minNum = redNumList.get(0);
		Integer maxNum = redNumList.get(redNumList.size() - 1);
		// 如果最小的号码大于10或最大的号码小于27，则重新获取
		return minNum <= MIN_NUM && maxNum >= MAX_NUM;
	}

	public static Set<Integer> getSpecialNum(int total, Set<Integer> redIndex) {
		if (total <= redIndex.size())
			return redIndex;
		// 1-10或23-30 选1个
		if (new Random().nextBoolean()) {
			// 1-9选一个
			int c1 = new Random().nextInt(9);
			redIndex.add(c1);
		} else {
			// 23-30 选1个
			int c1 = new Random().nextInt(8) + 22;
			redIndex.add(c1);
		}
		return total == redIndex.size() ? redIndex : getSpecialNum(total, redIndex);
	}

	/**
	 * 先选择4个固定的红球：<br>
	 * 1-4 选1个<br>
	 * 5-10选1个<br>
	 * 26-30选1个 <br>
	 */
	public static Set<Integer> getFixedNum() {
		// 记录已经选中序号
		Set<Integer> redIndex = new HashSet<>();
		// 1-4 选1个
		int c1 = new Random().nextInt(4);
		redIndex.add(c1);
		// 5-10选1个
		int c2 = new Random().nextInt(6) + 4;
		redIndex.add(c2);
		// 26-30选1个
		int c3 = new Random().nextInt(5) + 25;
		redIndex.add(c3);
		return redIndex;
	}

	/**
	 * 获取最新一期数据的排名情况
	 */
	public static List<NumLastAppear> numRankingDistributionMap() {
		HistoryRecord[] hs = HistoryRecord.values();
		List<HistoryRecord> historyList = new ArrayList<>();
		Collections.addAll(historyList, hs);
		// 复制为最新记录数据
		List<HistoryRecord> newHrList = new ArrayList<>();
		newHrList.addAll(historyList);
		// 获取最新一期数据中的红球数据
		String numStr = historyList.get(0).getRedNum();
		// 减去最近一期数据，成为历史数据
		historyList.remove(0);
		// 使用上期数据，算出上期红球分布结果
		List<NumLastAppear> numLastList = getNumDetail(Utils.listToArray(historyList, HistoryRecord.class));
		// 将红色球结果字符串转换为数组
		String[] numStrs = numStr.trim().split(",");
		// 查看中奖结果的排名分布情况
		List<NumLastAppear> rankingList = new ArrayList<>();
		for (String redNum : numStrs) {
			// 红球
			int rnum = Integer.parseInt(redNum);
			for (int i = 0; i < numLastList.size(); i++) {
				// 如果和最新期中的红球结果相同
				if (rnum == numLastList.get(i).getNum()) {
					NumLastAppear temp = new NumLastAppear(rnum, numLastList.get(i).getNotAppearTimes(), i + 1);
					rankingList.add(temp);
				}
			}
		}
		Collections.sort(rankingList);
		return rankingList;
	}

	/**
	 * 获取号码未出现次数及排名情况
	 */
	public static List<NumLastAppear> getNumDetail(HistoryRecord[] hs) {
		List<NumLastAppear> numLastList = new ArrayList<>();
		for (int i = 1; i <= TOTAL_NUM; i++) {
			NumLastAppear appear = new NumLastAppear();
			appear.setNum(i);
			int j = 0;
			for (HistoryRecord his : hs) {
				List<String> temp = Arrays.asList(his.getRedNum().split(","));
				if (temp.contains(String.valueOf(i)))
					break;
				j++;
			}
			appear.setNotAppearTimes(j);
			numLastList.add(appear);
		}
		Collections.sort(numLastList);
		List<NumLastAppear> newList = new ArrayList<>();
		for (int i = 0; i < numLastList.size(); i++) {
			NumLastAppear n = numLastList.get(i);
			n.setRanking(i + 1);
			newList.add(n);
		}
		return newList;
	}
}
