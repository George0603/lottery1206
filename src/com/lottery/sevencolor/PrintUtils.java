package com.lottery.sevencolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lottery.utils.NumLastAppear;

public class PrintUtils {

	public static List<String> RESULT_INFO_LIST = new ArrayList<>();

	private PrintUtils() {
		throw new IllegalStateException("PrintUtils class");
	}

	public static void pringDantuo() {
		ChoiceDanTuoResult r1 = Algorithm.danTuoWay7();
		ChoiceDanTuoResult r2 = Algorithm.danTuoWay7();
		List<Integer> rlist1 = getListByResult(r1);
		List<Integer> rlist2 = getListByResult(r2);
		Collections.sort(rlist1);
		Collections.sort(rlist2);
		if (isContainsSameNum(rlist1, rlist2) || checkSortNum(rlist1, rlist2)) {
			RESULT_INFO_LIST = new ArrayList<>();
			pringDantuo();
		} else {
			RESULT_INFO_LIST.add(r1.toPrintString());
			RESULT_INFO_LIST.add(r2.toPrintString());
		}
	}

	public static boolean checkMinNum(List<Integer> rlist1, List<Integer> rlist2) {
		rlist2.addAll(rlist1);
		Collections.sort(rlist2);
		int sortNum = 0;
		for (int i = 1; i < rlist2.size(); i++) {
			int now = rlist2.get(i);
			if (now < Algorithm.MID_SUM)
				sortNum++;
		}
		return sortNum != 1;
	}

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
		return sortNum > 1;
	}

	public static boolean isContainsSameNum(List<Integer> rlist1, List<Integer> rlist2) {
		for (Integer num : rlist1) {
			if (rlist2.contains(num))
				return true;
		}
		return false;
	}

	public static List<Integer> getListByResult(ChoiceDanTuoResult r) {
		List<Integer> danNumList = new ArrayList<>();
		danNumList.addAll(r.getDanNumList());
		danNumList.addAll(r.getTuoNumList());
		return danNumList;
	}

	public static void printResult7() {
		ChoiceResult result = Algorithm.get7Num();
		RESULT_INFO_LIST.add(result.toPrintString());
	}

	public static void printSum() {
		HistoryRecord[] hs = HistoryRecord.values();
		for (HistoryRecord h : hs) {
			RESULT_INFO_LIST.add("号码和排序之和为：" + getRecordSum(h) + "");
		}
	}

	public static int getRecordSum(HistoryRecord h) {
		int sum = 0;
		if (StringUtils.isNotBlank(h.getRedNum())) {
			String[] redNum = h.getRedNum().split(",");
			for (String r : redNum) {
				sum += Integer.valueOf(r);
			}
		}
		if (StringUtils.isNotBlank(h.getRanking())) {
			String[] ranking = h.getRanking().split(",");
			for (String r : ranking) {
				sum += Integer.valueOf(r);
			}
		}
		return sum;
	}

	/**
	 * 打印红球、蓝球的未出现次数情况
	 * 
	 * @param ballType
	 * @param ballList
	 */
	public static void printList() {
		HistoryRecord[] hs = HistoryRecord.values();
		List<NumLastAppear> lastList = Algorithm.getNumDetail(hs);
		StringBuilder printResult = new StringBuilder("\n");
		for (int i = 0; i < lastList.size(); i++) {
			printResult.append("序号:" + (i + 1) + ",号码：" + lastList.get(i).getNum() + ",未出现次数：" + lastList.get(i).getNotAppearTimes() + "\n");
		}
		RESULT_INFO_LIST.add(printResult.toString());
	}

	/**
	 * 打印号码的排名状况
	 */
	public static void printRanking() {
		List<NumLastAppear> lastList = Algorithm.numRankingDistributionMap();
		Integer allNum = 0;
		StringBuilder printResult = new StringBuilder("");
		for (NumLastAppear rank : lastList) {
			if (StringUtils.isNotBlank(printResult.toString()))
				printResult.append(",");
			printResult.append(rank.getRanking());
			allNum += rank.getNum() + rank.getRanking();
		}
		RESULT_INFO_LIST.add(printResult.insert(0, "中奖号码排名：").toString());
		RESULT_INFO_LIST.add("中奖号码和排名之和：" + allNum);
	}

}
