package com.lottery.twocolor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lottery.utils.NumLastAppear;

public class TwoColorBallUtils {

	public static final List<String> RESULTINFOLIST = new ArrayList<>();

	private TwoColorBallUtils() {
		throw new IllegalStateException("TwoColorBallUtils class");
	}

	private static Logger logger = Logger.getLogger(TwoColorBallUtils.class);

	// private static org.slf4j.Logger logRed = LoggerFactory.getLogger(TwoColorBallUtils.class)

	public static void printDanTuoResult(int tuoNum) {
		HistoryRecord[] hs = HistoryRecord.values();
		ChoiceDanTuoResult result = Algorithm.danTuoWay(hs, tuoNum);
		// logRed.info()
		RESULTINFOLIST.add("胆拖玩法，" + result.toPrintString());
	}

	/**
	 * 打印复投预测结果
	 */
	public static void printDoubleMulResult() {
		/**
		 * 打印购买号码预测结果
		 */
		HistoryRecord[] hs = HistoryRecord.values();
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
		HistoryRecord[] hs = HistoryRecord.values();
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
		HistoryRecord[] hs = HistoryRecord.values();
		ChoiceResult result = Algorithm.algorithm1213(hs);
		logger.info(result.toPrintString());
	}

	/**
	 * 打印红球、蓝球各个号码未出现的次数及排名
	 */
	public static void printreNotPresentTimes() {
		HistoryRecord[] hs = HistoryRecord.values();
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
		HistoryRecord[] hs = HistoryRecord.values();
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

}
