package com.lottery.twocolor;

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
import com.lottery.utils.WeightUtils;

/**
 * 预测结果算法 蓝色球从1到16中选1个 红色球从1到33中选6个
 */

public class Algorithm {

	public static List<String> NORMALINFOLIST = new ArrayList<>();

	// private static Logger logger = Logger.getLogger(Algorithm.class)

	public static final int MIN_SUM = 180;

	public static final int MID_SUM = 200;

	public static final int MAX_SUM = 260;

	public static final int SUM_DIFF = 25;
	// 红球允许的最小值
	public static final int MIN_NUM = 9;
	// 红球最大值的最小值
	public static final int MAX_NUM = 27;

	public static final List<Integer> EXCEPTLIST = Arrays.asList(5, 30);

	private Algorithm() {
		throw new IllegalStateException("Algorithm class");
	}

	/**
	 * @param tuoNum
	 *            拖码个数
	 * @param isAsc
	 *            蓝球是否是正序选择
	 * @return
	 */
	public static ChoiceDanTuoResult danTuoWay(RankingRecord[] recordList, int tuoNum, boolean isAsc, int buleNum) {
		ChoiceDanTuoResult choiceResult = new ChoiceDanTuoResult();
		buleNum = buleNum > 4 ? 4 : buleNum;
		if (isAsc) {
			choiceResult.setBlueNum(getTwoBlueNum(recordList, 1, 5, buleNum));
		} else {
			choiceResult.setBlueNum(getTwoBlueNum(recordList, 11, 15, buleNum));
		}
		choiceResult = getDanTuoRedList(recordList, choiceResult, tuoNum);
		return choiceResult;
	}

	/**
	 * 胆码： 1-4名选1个； 5-10名选1个； 27-33名选1个；6-33里选剩的随机选1个；<br>
	 * 拖码：11-27名选3个；
	 */
	public static ChoiceDanTuoResult getDanTuoRedList(RankingRecord[] recordList, ChoiceDanTuoResult choiceResult, int tuoNum) {
		List<Integer> redNumList = new ArrayList<>();
		// 胆码集合
		List<Integer> danNumList = new ArrayList<>();
		// 获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		// 记录已经选中序号
		Set<Integer> redIndex = getFixedThreeNum();
		// 11-27名选1个；
		redIndex = Utils.randomSet(10, 27, 4, redIndex);
		// 个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			danNumList.add(redNumLastList.get(i).getNum());
		}
		// 拖码集合
		List<Integer> tuoNumList = new ArrayList<>();
		// 11-27名选TUO_NUM-1个；
		redIndex = Utils.randomSet(10, 27, 4 + tuoNum - 1, redIndex);
		// 1-10或者24-33选择一个
		if (new Random().nextBoolean()) {
			redIndex = Utils.randomSet(0, 10, 4 + tuoNum, redIndex);
		} else {
			redIndex = Utils.randomSet(23, 33, 4 + tuoNum, redIndex);
		}
		List<Integer> rankList = new ArrayList<>();
		for (Integer i : redIndex) {
			redNumList.add(redNumLastList.get(i).getNum());
			rankList.add(redNumLastList.get(i).getRanking());
		}
		// 新增的为拖码
		for (Integer n : redNumList) {
			if (!danNumList.contains(n))
				tuoNumList.add(n);
		}
		Collections.sort(redNumList);
		Collections.sort(rankList);
		// 数字符合大小限制，切各自组合的和也符合
		if (!passAllCheck(redNumList, recordList, true) || !checkSumList(danNumList, tuoNumList, redNumLastList, redNumList))
			return getDanTuoRedList(recordList, choiceResult, tuoNum);
		// 校验是否满足情况
		choiceResult.setDanNumList(danNumList);
		choiceResult.setTuoNumList(tuoNumList);
		return choiceResult;
	}

	// 能否通过所有校验
	private static boolean passAllCheck(List<Integer> redNumList, RankingRecord[] recordList, boolean isDantuo) {
		// 判断奇数偶数个数，奇数和偶数的个数都要大于1
		if (checkEvenNum(redNumList))
			return false;
		// 只允许有1或2个小于10的，否则不通过
		if (checkLower(redNumList))
			return false;
		// 是否包含不能包含的数字，包含则不通过
		if (checkConstains(redNumList))
			return false;
		// 是否同时存在两个连续数字
		if (!checkSort(redNumList))
			return false;
		// 校验最大值和最小值，是否在范围内
		if (!checkMinMax(redNumList))
			return false;
		if (checkLastRedNum(redNumList, recordList))
			return false;
		if (!isDantuo && checkSum(redNumList))
			return false;
		return true;
	}

	// 红球和排名之和要在范围内
	public static boolean checkSum(List<Integer> redNumList) {
		List<NumLastAppear> numLastList = ChoiceNum.getRedNumDetail(RankingRecord.values());
		List<Integer> rankList = new ArrayList<>();
		int allSum = 0;
		for (Integer redNum : redNumList) {
			Integer rank = Utils.getRankingByNum(numLastList, redNum);
			allSum += (redNum + rank);
			rankList.add(rank);
		}
		boolean result = allSum > MAX_SUM || allSum < MIN_SUM;
		if (!result) {
			Collections.sort(rankList);
			NORMALINFOLIST.add("普通玩法红球：总和=" + allSum + ",红球【" + StringUtils.join(redNumList.toArray(), ",") + "】,排名【" + StringUtils.join(rankList.toArray(), ",") + "】");
		}
		return result;
	}

	// 判断偶数个数
	private static boolean checkEvenNum(List<Integer> redNumList) {
		int evenNum = 0;
		int oddNum = 0;
		for (Integer n : redNumList) {
			if (n % 2 == 0)
				evenNum++;
			else
				oddNum++;
		}
		return evenNum < 2 || oddNum < 2;
	}

	// 只允许有1或2个小于10的
	private static boolean checkLower(List<Integer> redNumList) {
		Integer thirdNum = redNumList.get(2);
		return thirdNum < 10;
	}

	// 是否包含不能包含的数字
	private static boolean checkConstains(List<Integer> redNumList) {
		for (Integer num : redNumList) {
			if (EXCEPTLIST.contains(num))
				return true;
		}
		return false;
	}

	// 校验如果最后一个红球号码，和最新一期的红球号码相同，则重新选择
	public static boolean checkLastRedNum(List<Integer> redNumList, RankingRecord[] recordList) {
		// 历史记录最新的
		String[] redNumStr = recordList[0].getRedNum().split(",");
		// 获取本次选择号码的最后一个号码
		Integer newestNum = redNumList.get(redNumList.size() - 1);
		Integer lastesNum = Integer.valueOf(redNumStr[redNumStr.length - 1]);
		Integer firstNmu = Integer.valueOf(redNumStr[0]);
		// 判断是否相等
		return newestNum.equals(lastesNum) || (redNumList.contains(firstNmu) && redNumList.contains(lastesNum));
	}

	public static boolean checkSumList(List<Integer> danNumList, List<Integer> tuoNumList, List<NumLastAppear> redNumLastList, List<Integer> redNumList) {
		List<Integer> sumList = Utils.getSumList(danNumList, tuoNumList, redNumLastList, 1);
		Integer minNum = sumList.get(0);
		Integer maxNum = sumList.get(sumList.size() - 1);
		// 最小的，要大于MIN_SUM
		if (minNum <= MIN_SUM)
			return false;
		// 最大的不能大于MAX_SUM
		if (maxNum > MAX_SUM)
			return false;
		// 要保证存在大于MID_SUM的
		if (sumList.get(1) < MID_SUM)
			return false;
		// 最小和最大的和要相差20以上
		if (sumList.get(sumList.size() - 1) - sumList.get(0) <= SUM_DIFF)
			return false;

		NORMALINFOLIST.add("胆拖所有组合双和为【" + StringUtils.join(sumList, ",") + "】，红色号码为【" + StringUtils.join(redNumList, ",") + "】。");
		return true;
	}

	/**
	 * 蓝球：从排名11-15中选两个 <br/>
	 * 红球： 从红球排名结果中选取结果： 1-4名选1个； 5-10名选1个； 11-27名选2个； 27-33名选1个； 6-33里选剩的随机选1个；
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceMultiResult algorithmDesc(RankingRecord[] recordList) {
		ChoiceMultiResult choiceResult = new ChoiceMultiResult();
		choiceResult.setBlueNum(getTwoBlueNum(recordList, 11, 15, 3));
		choiceResult.setRedNumList(getRedNumList(recordList));
		return choiceResult;
	}

	/**
	 * 蓝球：从排名1-5中选两个 <br/>
	 * 红球： 从红球排名结果中选取结果： 1-4名选1个； 5-10名选1个； 11-27名选2个； 27-33名选1个； 6-33里选剩的随机选1个；
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceMultiResult algorithmAsc(RankingRecord[] recordList) {
		ChoiceMultiResult choiceResult = new ChoiceMultiResult();
		choiceResult.setBlueNum(getTwoBlueNum(recordList, 1, 5, 4));
		choiceResult.setRedNumList(getRedNumList(recordList));
		return choiceResult;
	}

	/**
	 * 蓝球：从排名2-5中选两个<br/>
	 * 红球： 从红球排名结果中选取结果： 1-4名选1个； 5-10名选1个； 11-27名选2个； 27-33名选1个； 6-33里选剩的随机选2个；
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceMultiResult algorithm1014(RankingRecord[] recordList) {
		ChoiceMultiResult choiceResult = new ChoiceMultiResult();
		choiceResult.setBlueNum(getTwoBlueNum(recordList, 0, 5, 2));
		choiceResult.setRedNumList(get7RedNumList(recordList));
		return choiceResult;
	}

	/**
	 * 红球： 从红球排名结果中选取结果： 1-3名选1个； 4-9名选1个； 10-29名选2个； 30-33名选1个； 1-33里选剩的随机选1个；<br/>
	 * 蓝球：直接取最久未出现的那一个
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceResult algorithm1213(RankingRecord[] recordList) {
		ChoiceResult choiceResult = new ChoiceResult();
		// 获取蓝球统计结果
		// 选中蓝球中出现次数最多的那个号码
		choiceResult.setBlueNum(getBlueNum(recordList));
		choiceResult.setRedNumList(getRedNumList(recordList));
		return choiceResult;
	}

	/**
	 * 红球： 从红球排名结果中选取结果： 1-4名选1个； 5-10名选1个； 11-27名选2个； 27-33名选1个； 6-33里选剩的随机选1个；
	 */
	public static List<Integer> get7RedNumList(RankingRecord[] recordList) {
		List<Integer> redNumList = new ArrayList<>();
		// 获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		// 记录已经选中序号
		Set<Integer> redIndex = getFixedThreeNum();
		// 从11-27名选2个
		redIndex = Utils.randomSet(10, 27, 5, redIndex);
		// 从6-33里随机2个；
		redIndex = Utils.randomSet(5, 33, 7, redIndex);
		// 6个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			redNumList.add(redNumLastList.get(i).getNum());
		}
		Collections.sort(redNumList);
		boolean checkResult = checkOtherCondition(redNumList, redIndex, redNumLastList);
		if (!checkResult)
			return getRedNumList(recordList);
		return redNumList;
	}

	/**
	 * 先选择3个固定的红球： 1-7名选1个； 8-19名选1个；27-33名选1个；
	 */
	public static Set<Integer> getFixedThreeNum() {
		// 记录已经选中序号
		Set<Integer> redIndex = new HashSet<>();
		// 从1-7名选1个
		// int c1 = new Random().nextInt(7)
		int c1 = WeightUtils.getNumByWeight();
		redIndex.add(c1);
		// 从8-19名选1个
		int c2 = new Random().nextInt(12) + 7;
		redIndex.add(c2);
		// 从27-33名选1个
		int c3 = new Random().nextInt(7) + 26;
		redIndex.add(c3);
		return redIndex;
	}

	/**
	 * 红球： 从红球排名结果中选取结果： 1-4名选1个； 5-10名选1个； 11-27名选2个； 27-33名选1个； 6-33里选剩的随机选1个；
	 */
	public static List<Integer> getRedNumList(RankingRecord[] recordList) {
		List<Integer> redNumList = new ArrayList<>();
		// 获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		// 记录已经选中序号
		Set<Integer> redIndex = getFixedThreeNum();
		// 从11-27名选2个
		redIndex = Utils.randomSet(10, 27, 5, redIndex);
		// 1-10或者24-33中选一个
		if (new Random().nextBoolean()) {
			redIndex = Utils.randomSet(0, 10, 6, redIndex);
		} else {
			redIndex = Utils.randomSet(23, 33, 6, redIndex);
		}
		// 6个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			redNumList.add(redNumLastList.get(i).getNum());
		}
		Collections.sort(redNumList);
		if (!passAllCheck(redNumList, recordList, false))
			return getRedNumList(recordList);
		return redNumList;
	}

	// 是否同时存在两个连续数字
	public static boolean checkSort(List<Integer> redNumList) {
		int sortNum = 0;
		for (int i = 1; i < redNumList.size(); i++) {
			int last = redNumList.get(i - 1);
			int now = redNumList.get(i);
			if (now - last == 1)
				sortNum++;
		}
		// 是否存在两个连续
		return sortNum < 2;
	}

	// 校验最大值和最小值，是否在范围内
	public static boolean checkMinMax(List<Integer> redNumList) {
		Integer minNum = redNumList.get(0);
		Integer maxNum = redNumList.get(redNumList.size() - 1);
		Integer mayNum = redNumList.get(redNumList.size() - 2);
		// 不能有两个大于30的
		if (maxNum >= 30 && mayNum >= 30)
			return false;
		return minNum <= MIN_NUM && maxNum >= MAX_NUM;
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
		// Comparator.reverseOrder()
		// List<Integer> collect = redIndex.stream().sorted().collect(Collectors.toList())
		Collections.sort(indexList);
		// NORMALINFOLIST.add("红球之和和排名之和:" + sum + "，红球排序：【" + StringUtils.join(indexList, ",") + "】")
		NORMALINFOLIST.add("红球之和和排名之和【" + sum + "】.");
		return true;
	}

	/**
	 * 获取蓝球算法：从排名前4中选两个
	 */
	public static List<Integer> getTwoBlueNum(RankingRecord[] recordList, int start, int end, int size) {
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		// 记录已经选中序号
		List<Integer> blueIndex = new ArrayList<>();
		// 从10-29名选2个
		Set<Integer> t = new HashSet<>();
		t = Utils.randomSet(start, end, size, t);
		for (Integer temp : t) {
			blueIndex.add(blueNumLastList.get(temp).getNum());
		}
		return blueIndex;
	}

	/**
	 * 获取蓝球算法
	 */
	public static int getBlueNum(RankingRecord[] recordList) {
		// 获取蓝球统计结果
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		// 直接获取最久未出现的号码
		return blueNumLastList.get(0).getNum();
	}

	public static Integer randomFromOutSideList(Set<Integer> list) {
		// 从0到32里随机选择一个数
		Integer result = new Random().nextInt(28) + 5;
		// 如果List里面已经有这个数了，则随机选
		if (list.contains(result)) {
			result = randomFromOutSideList(list);
		}
		return result;
	}
}
