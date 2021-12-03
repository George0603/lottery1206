package com.lottery.twocolor;

import java.util.ArrayList;
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

	public static final List<String> NORMALINFOLIST = new ArrayList<>();

	// private static Logger logger = Logger.getLogger(Algorithm.class)

	private static final int MIN_SUM = 180;
	// 红球允许的最小值
	private static final int MIN_NUM = 10;
	// 红球最大值的最小值
	private static final int MAX_NUM = 27;

	private Algorithm() {
		throw new IllegalStateException("Algorithm class");
	}

	/**
	 * 胆拖玩法：4个胆码，3个拖码
	 * 
	 * @param recordList
	 *            中奖历史记录
	 */
	public static ChoiceDanTuoResult danTuoWay(HistoryRecord[] recordList, int tuoNum) {
		ChoiceDanTuoResult choiceResult = new ChoiceDanTuoResult();
		choiceResult.setBlueNum(getTwoBlueNum(recordList, 1, 5, 4));
		choiceResult = getDanTuoRedList(recordList, choiceResult, tuoNum);
		return choiceResult;
	}

	/**
	 * 胆码： 1-4名选1个； 5-10名选1个； 27-33名选1个；6-33里选剩的随机选1个；<br>
	 * 拖码：11-27名选3个；
	 */
	public static ChoiceDanTuoResult getDanTuoRedList(HistoryRecord[] recordList, ChoiceDanTuoResult choiceResult, int tuoNum) {
		List<Integer> redNumList = new ArrayList<>();
		// 胆码集合
		List<Integer> danNumList = new ArrayList<>();
		// 获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		// 记录已经选中序号
		Set<Integer> redIndex = getFixedThreeNum();
		// 从4-33里随机1个；
		redIndex = Utils.randomSet(3, 33, 4, redIndex);
		// 个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			danNumList.add(redNumLastList.get(i).getNum());
		}
		// 拖码集合
		List<Integer> tuoNumList = new ArrayList<>();
		// 11-27名选TUO_NUM个；
		redIndex = Utils.randomSet(10, 27, 4 + tuoNum, redIndex);
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
		if (!checkMinMax(redNumList) || checkLastRedNum(redNumList, recordList) || !checkSumList(danNumList, tuoNumList, redNumLastList, redNumList))
			return getDanTuoRedList(recordList, choiceResult, tuoNum);
		// 校验是否满足情况
		choiceResult.setDanNumList(danNumList);
		choiceResult.setTuoNumList(tuoNumList);
		return choiceResult;
	}

	// 校验如果最后一个红球号码，和最新一期的红球号码相同，则重新选择
	public static boolean checkLastRedNum(List<Integer> redNumList, HistoryRecord[] recordList) {
		// 获取本次选择号码的最后一个号码
		Integer newestNum = redNumList.get(redNumList.size() - 1);
		// 历史记录最新的
		String[] redNumStr = recordList[0].getRedNum().split(",");
		Integer lastesNum = Integer.valueOf(redNumStr[redNumStr.length - 1]);
		// 判断是否相等
		return newestNum.equals(lastesNum);
	}

	public static boolean checkSumList(List<Integer> danNumList, List<Integer> tuoNumList, List<NumLastAppear> redNumLastList, List<Integer> redNumList) {
		List<Integer> sumList = Utils.getSumList(danNumList, tuoNumList, redNumLastList, 1);
		for (Integer sum : sumList) {
			if (sum < MIN_SUM)
				return false;
		}
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
	public static ChoiceMultiResult algorithmDesc(HistoryRecord[] recordList) {
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
	public static ChoiceMultiResult algorithmAsc(HistoryRecord[] recordList) {
		ChoiceMultiResult choiceResult = new ChoiceMultiResult();
		choiceResult.setBlueNum(getTwoBlueNum(recordList, 0, 5, 3));
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
	public static ChoiceMultiResult algorithm1014(HistoryRecord[] recordList) {
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
	public static ChoiceResult algorithm1213(HistoryRecord[] recordList) {
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
	public static List<Integer> get7RedNumList(HistoryRecord[] recordList) {
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
	public static List<Integer> getRedNumList(HistoryRecord[] recordList) {
		List<Integer> redNumList = new ArrayList<>();
		// 获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		// 记录已经选中序号
		Set<Integer> redIndex = getFixedThreeNum();
		// 从11-27名选2个
		redIndex = Utils.randomSet(10, 27, 5, redIndex);
		// 从4-33里随机1个；
		redIndex = Utils.randomSet(3, 33, 6, redIndex);
		// 6个序号得到后，获取对应的号码
		for (Integer i : redIndex) {
			redNumList.add(redNumLastList.get(i).getNum());
		}
		Collections.sort(redNumList);
		boolean checkResult = checkOtherCondition(redNumList, redIndex, redNumLastList);
		if (checkLastRedNum(redNumList, recordList) || !checkResult)
			return getRedNumList(recordList);
		return redNumList;
	}

	public static boolean checkMinMax(List<Integer> redNumList) {
		Integer minNum = redNumList.get(0);
		Integer maxNum = redNumList.get(redNumList.size() - 1);
		// 如果最小的号码大于10或最大的号码小于27，则重新获取
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
	public static List<Integer> getTwoBlueNum(HistoryRecord[] recordList, int start, int end, int size) {
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
