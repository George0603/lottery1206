package com.lottery.twocolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lottery.utils.NumLastAppear;
import com.lottery.utils.Utils;

public class TwoColorBallUtils {

	public static List<String> RESULTINFOLIST = new ArrayList<>();

	// 是否允许包含顺序出现的数字
	public static final boolean CONTAINSORDER = false;

	private TwoColorBallUtils() {
		throw new IllegalStateException("TwoColorBallUtils class");
	}

	private static Logger logger = Logger.getLogger(TwoColorBallUtils.class);

	/**
	 * 胆拖方式买红球
	 */
	public static ChoiceDanTuoResult printDanTuoResult(int tuoNum, boolean isAsc, int buleNum) {
		RankingRecord[] hs = RankingRecord.values();
		ChoiceDanTuoResult result = Algorithm.danTuoWay(hs, tuoNum, isAsc, buleNum);
		// logRed.info()
		RESULTINFOLIST.add("胆拖玩法，" + result.toPrintString());
		return result;
	}

	/**
	 * 打印复投预测结果
	 */
	public static void printDoubleMulResult() {
		/**
		 * 打印购买号码预测结果
		 */
		RankingRecord[] hs = RankingRecord.values();
		ChoiceMultiResult desc = Algorithm.algorithmDesc(hs);
		ChoiceMultiResult asc = Algorithm.algorithmAsc(hs);
		RESULTINFOLIST.add(desc.toPrintString());
		RESULTINFOLIST.add(asc.toPrintString());
	}

	/**
	 * 打印复投预测结果
	 */
	public static void printMulResult() {
		/**
		 * 打印购买号码预测结果
		 */
		RankingRecord[] hs = RankingRecord.values();
		ChoiceMultiResult desc = Algorithm.algorithmDesc(hs);
		RESULTINFOLIST.add("普通玩法，" + desc.toPrintString());
	}

	/**
	 * 打印预测结果
	 */
	public static void printResult() {
		/**
		 * 打印购买号码预测结果
		 */
		RankingRecord[] hs = RankingRecord.values();
		ChoiceResult result = Algorithm.algorithm1213(hs);
		logger.info(result.toPrintString());
	}

	/**
	 * 打印红球、蓝球各个号码未出现的次数及排名
	 */
	public static void printreNotPresentTimes() {
		RankingRecord[] hs = RankingRecord.values();
		/**
		 * 打印蓝、红统计结果
		 */
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(hs);
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(hs);
		// 篮球
		printBlueAndRedList("蓝球", blueNumLastList);
		// 红球
		printBlueAndRedList("红球", redNumLastList);

	}

	/**
	 * 打印本次各个中奖号码的排名情况
	 */
	public static void printRankingDetail() {
		RankingRecord[] hs = RankingRecord.values();
		/** 中奖蓝球号码在上一期中的排名和未出现次数 **/
		NumLastAppear blueAppear = ChoiceNum.blueBallDistributionMap(hs);
		// logger.info("蓝球中奖号码:" + blueAppear.getNum() + ",未出现次数:" + blueAppear.getNotAppearTimes() + ",排名:" + blueAppear.getRanking())
		RESULTINFOLIST.add("蓝球中奖号码:" + blueAppear.getNum() + ",未出现次数:" + blueAppear.getNotAppearTimes() + ",排名:" + blueAppear.getRanking());
		/**
		 * 打印最新一期红球中奖号码的排名分布情况（根据未出现的次数排名）
		 */
		List<NumLastAppear> rankList = ChoiceNum.redBallDistributionMap(hs);
		printRandingList(rankList);
		// 红球总和
		int sum = 0;
		int sumRank = 0;
		for (NumLastAppear n : rankList) {
			sum += n.getNum();
			sumRank += n.getRanking();
		}
		// logger.info("红球号码总和：" + sum)
		// 红球号码排名总和
		// logger.info("红球号码排名总和：" + sumRank)
		// 和与差
		// logger.info("两数之和与差：" + (sum + sumRank) + "," + Math.abs(sum - sumRank))
		RESULTINFOLIST.add("红球号码总和：" + sum + ",排名总和:" + sumRank);
		RESULTINFOLIST.add("两数之和与差：" + (sum + sumRank) + "," + Math.abs(sum - sumRank));

	}

	/**
	 * 打印最新一期红球结果，在上一期统计的排名情况集合
	 * 
	 * @param rankList
	 */
	public static void printRandingList(List<NumLastAppear> rankList) {
		StringBuilder printResult = new StringBuilder("");
		for (NumLastAppear rank : rankList) {
			if (StringUtils.isNotBlank(printResult.toString()))
				printResult.append(",");
			printResult.append(rank.getRanking());
		}
		RESULTINFOLIST.add(printResult.insert(0, "红球中奖号码排名：").toString());
	}

	/**
	 * 打印红球、蓝球的未出现次数情况
	 * 
	 * @param ballType
	 * @param ballList
	 */
	public static void printBlueAndRedList(String ballType, List<NumLastAppear> ballList) {
		StringBuilder printResult = new StringBuilder("\n");
		for (int i = 0; i < ballList.size(); i++) {
			printResult.append(ballType + "序号:" + (i + 1) + ",号码：" + ballList.get(i).getNum() + ",未出现次数：" + ballList.get(i).getNotAppearTimes() + "\n");
		}
		RESULTINFOLIST.add(printResult.toString());
	}

	// 11.21之前购买
	public static void wayBefore1121() {
		// 胆拖方式,3个拖码,蓝球有1-5选3个
		ChoiceDanTuoResult r1 = printDanTuoResult(3, false, 4);
		// 胆拖方式,3个拖码,蓝球有11-15选3个
		ChoiceDanTuoResult r2 = printDanTuoResult(3, true, 4);

		if (!passAllCheck(r1, r2)) {
			RESULTINFOLIST = new ArrayList<>();
			Algorithm.NORMALINFOLIST = new ArrayList<>();
			wayBefore1121();
		}
	}

	public static void wayAfter1121() {
		// 普通方式，6个红球，4个蓝球
		ChoiceMultiResult r2 = Algorithm.algorithmAsc(RankingRecord.values());
		// 胆拖方式,3个拖码,蓝球有1-5选3个
		ChoiceDanTuoResult r1 = printDanTuoResult(3, false, 4);
		if (!passAllCheck(r1, r2)) {
			RESULTINFOLIST = new ArrayList<>();
			Algorithm.NORMALINFOLIST = new ArrayList<>();
			wayAfter1121();
		} else {
			RESULTINFOLIST.add(r2.toPrintString());
		}
	}

	public static boolean passAllCheck(ChoiceDanTuoResult r1, ChoiceMultiResult r2) {
		List<Integer> rlist1 = getListByResult(r1);
		List<Integer> rlist2 = r2.getRedNumList();
		Collections.sort(rlist1);
		Collections.sort(rlist2);
		// 判断是否包含相同的数字
		if (isContainsSameNum(rlist1, rlist2))
			return false;
		// 不能包含超过1次的顺序数字
		if (checkSortNum(rlist1, rlist2))
			return false;
		// 只允许包含3个或4个小于10个数字
		if (checkLower(rlist1, rlist2))
			return false;
		if (checkSum(r1, r2))
			return false;
		return true;
	}

	public static boolean checkSum(ChoiceDanTuoResult r1, ChoiceMultiResult r2) {
		// 获取排名结果
		List<NumLastAppear> numLastList = ChoiceNum.getRedNumDetail(RankingRecord.values());
		List<Integer> sumList1 = Utils.getSumList(r1.getDanNumList(), r1.getTuoNumList(), numLastList, 1);
		int sum2 = getMultiSum(r2, numLastList);
		int allNum = 0;
		for (Integer sum : sumList1) {
			if (sum < Algorithm.MID_SUM)
				allNum++;
		}
		if (sum2 < Algorithm.MID_SUM)
			allNum++;
		return allNum != 1;
	}

	public static int getMultiSum(ChoiceMultiResult r, List<NumLastAppear> numLastList) {
		int allSum = 0;
		for (Integer redNum : r.getRedNumList()) {
			Integer rank = Utils.getRankingByNum(numLastList, redNum);
			allSum += (redNum + rank);
		}
		return allSum;
	}

	public static boolean checkSum(ChoiceDanTuoResult r1, ChoiceDanTuoResult r2) {
		// 获取排名结果
		List<NumLastAppear> numLastList = ChoiceNum.getRedNumDetail(RankingRecord.values());
		List<Integer> sumList1 = Utils.getSumList(r1.getDanNumList(), r1.getTuoNumList(), numLastList, 1);
		List<Integer> sumList2 = Utils.getSumList(r2.getDanNumList(), r2.getTuoNumList(), numLastList, 1);
		int allNum = 0;
		for (Integer sum : sumList1) {
			if (sum < Algorithm.MID_SUM)
				allNum++;
		}
		for (Integer sum : sumList2) {
			if (sum < Algorithm.MID_SUM)
				allNum++;
		}
		return allNum != 1;
	}

	public static boolean passAllCheck(ChoiceDanTuoResult r1, ChoiceDanTuoResult r2) {
		List<Integer> rlist1 = getListByResult(r1);
		List<Integer> rlist2 = getListByResult(r2);
		Collections.sort(rlist1);
		Collections.sort(rlist2);
		// 判断是否包含相同的数字
		if (isContainsSameNum(rlist1, rlist2))
			return false;
		// 不能包含超过1次的顺序数字
		if (checkSortNum(rlist1, rlist2))
			return false;
		// 只允许包含3个或4个小于10个数字
		if (checkLower(rlist1, rlist2))
			return false;
		// 只允许出现1个小于200的数字
		if (checkLowerSum(r1, r2))
			return false;
		return true;
	}

	public static boolean checkLowerSum(ChoiceDanTuoResult r1, ChoiceDanTuoResult r2) {
		// 获取红球统计结果
		RankingRecord[] recordList = RankingRecord.values();
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		List<Integer> sumList1 = Utils.getSumList(r1.getDanNumList(), r1.getTuoNumList(), redNumLastList, 1);
		List<Integer> sumList2 = Utils.getSumList(r2.getDanNumList(), r2.getTuoNumList(), redNumLastList, 1);
		Collections.sort(sumList1);
		Collections.sort(sumList2);
		// 只允许有1个小于Algorithm.MID_SUM的
		int lowerNum = 0;
		if (sumList1.get(0) < Algorithm.MID_SUM)
			lowerNum++;
		if (sumList2.get(0) < Algorithm.MID_SUM)
			lowerNum++;
		return lowerNum != 1;
	}

	// 只允许包含3个或4个小于10个数字
	public static boolean checkLower(List<Integer> rlist1, List<Integer> rlist2) {
		int lowerNum = 0;
		for (Integer n : rlist1) {
			if (n < 10)
				lowerNum++;
		}
		for (Integer n : rlist2) {
			if (n < 10)
				lowerNum++;
		}
		return lowerNum != 3 && lowerNum != 4;
	}

	// 不能包含超过1次的顺序数字
	public static boolean checkSortNum(List<Integer> rlist1, List<Integer> rlist2) {
		int sortNum = 0;
		for (int i = 1; i < rlist1.size(); i++) {
			int last = rlist1.get(i - 1);
			int now = rlist1.get(i);
			if (now - last == 1)
				sortNum++;
		}
		for (int i = 1; i < rlist2.size(); i++) {
			int last = rlist2.get(i - 1);
			int now = rlist2.get(i);
			if (now - last == 1)
				sortNum++;
		}
		return CONTAINSORDER ? sortNum > 1 : sortNum > 0;
	}

	// 判断是否包含相同的数字
	public static boolean isContainsSameNum(List<Integer> rlist1, List<Integer> rlist2) {
		for (Integer num : rlist1) {
			if (rlist2.contains(num))
				return true;
		}
		return false;
	}

	// 判断结果中是否有相同的数值

	public static List<Integer> getListByResult(ChoiceDanTuoResult r) {
		List<Integer> danNumList = new ArrayList<>();
		danNumList.addAll(r.getDanNumList());
		danNumList.addAll(r.getTuoNumList());
		return danNumList;
	}
}
