package com.main;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.lottery.Algorithm;
import com.lottery.ChoiceMultiResult;
import com.lottery.ChoiceNum;
import com.lottery.ChoiceResult;
import com.lottery.HistoryRecord;
import com.lottery.NumLastAppear;

public class RunMain {

	private static Logger logger = Logger.getLogger(RunMain.class);

	public static void main(String[] args) {
		printDoubleMulResult();
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
		logger.info(desc.toPrintString());
		logger.info(asc.toPrintString());
	}

	/**
	 * 打印复投预测结果
	 */
	public static void printMulResult() {
		/**
		 * 打印购买号码预测结果
		 */
		HistoryRecord[] hs = HistoryRecord.values();
		ChoiceMultiResult result = Algorithm.algorithm1014(hs);
		logger.info(result.toPrintString());
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

	// 3,9,10,11,28,29

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
		/**
		 * 打印最新一期红球中奖号码的排名分布情况（根据未出现的次数排名）
		 */
		List<NumLastAppear> rankList = ChoiceNum.redBallDistributionMap(hs);
		printRandingList(rankList);
		/** 中奖蓝球号码在上一期中的排名和未出现次数 **/
		NumLastAppear blueAppear = ChoiceNum.blueBallDistributionMap(hs);
		logger.info("蓝球中奖号码:" + blueAppear.getNum() + ",未出现次数:" + blueAppear.getNotAppearTimes() + ",排名:" + blueAppear.getRanking());
	}

	/**
	 * 打印最新一期红球结果，在上一期统计的排名情况集合
	 * 
	 * @param rankList
	 */
	public static void printRandingList(List<NumLastAppear> rankList) {
		Collections.sort(rankList);
		StringBuilder printResult = new StringBuilder("红球中奖号码排名：");
		for (NumLastAppear rank : rankList) {
			printResult.append(rank.getRanking() + " ");
		}
		logger.info(printResult);
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
		logger.info(printResult);
	}

}
