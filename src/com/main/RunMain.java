package com.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.lottery.twocolor.Algorithm;
import com.lottery.twocolor.TwoColorBallUtils;

public class RunMain {

	private static Logger logger = Logger.getLogger(RunMain.class);

	public static void main(String[] args) {

		wayBefore1121();
		// TwoColorBallUtils.printreNotPresentTimes();
		TwoColorBallUtils.printRankingDetail();

		printInfo();
	}

	// 常规购买
	public static void routineWay() {
		// 胆拖方式,3个拖码,蓝球有1-5选3个
		TwoColorBallUtils.printDanTuoResult(3);
		// 普通选择，蓝球16-11选2个
		TwoColorBallUtils.printMulResult();
	}

	// 11.21之前购买
	public static void wayBefore1121() {
		// 胆拖方式,3个拖码,蓝球有1-5选3个
		TwoColorBallUtils.printDanTuoResult(4);
		// 普通选择，蓝球16-11选2个
		TwoColorBallUtils.printMulResult();
	}

	public static void printInfo() {
		String separator = System.getProperty("line.separator");
		StringBuilder print = new StringBuilder(separator);
		List<String> normalInfoList = Algorithm.NORMALINFOLIST;
		for (String s : normalInfoList) {
			print.append(s).append(separator);
		}
		List<String> resultList = TwoColorBallUtils.RESULTINFOLIST;
		for (String s : resultList) {
			print.append(s).append(separator);
		}
		logger.info(print);
	}

}
