package com.lottery.sevencolor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lottery.utils.NumLastAppear;

public class PrintUtils {

	public static final List<String> RESULT_INFO_LIST = new ArrayList<>();

	private PrintUtils() {
		throw new IllegalStateException("PrintUtils class");
	}

	public static void pringDantuo() {
		ChoiceDanTuoResult reuslt = Algorithm.danTuoWay();
		RESULT_INFO_LIST.add(reuslt.toPrintString());
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
