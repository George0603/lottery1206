package com.lottery.twocolor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.lottery.utils.NumLastAppear;
import com.lottery.utils.Utils;

/**
 * 号码选择参考
 * 
 */
public class ChoiceNum {

	private ChoiceNum() {
		throw new IllegalStateException("ChoiceNum class");
	}

	/**
	 * 蓝球分布图
	 * 
	 * @param hrs
	 * @return
	 */
	public static NumLastAppear blueBallDistributionMap(HistoryRecord[] hrs) {
		NumLastAppear result = new NumLastAppear();
		// 最新一期中奖的蓝球号码
		int blueNum = hrs[0].getBlueNum();
		result.setNum(blueNum);
		List<HistoryRecord> historyList = new ArrayList<>();
		Collections.addAll(historyList, hrs);
		// 复制为最新记录数据
		List<HistoryRecord> newHrList = new ArrayList<>();
		newHrList.addAll(historyList);
		// 减去最近一期数据，成为历史数据
		historyList.remove(0);
		// 使用上期数据，算出上期红球分布结果
		List<NumLastAppear> blueNumLastList = getBlueNumDetail(Utils.listToArray(historyList, HistoryRecord.class));
		for (int i = 0; i < blueNumLastList.size(); i++) {
			if (blueNum == blueNumLastList.get(i).getNum()) {
				result.setRanking(i + 1);
				result.setNotAppearTimes(blueNumLastList.get(i).getNotAppearTimes());
				break;
			}
		}
		return result;
	}

	/**
	 * 红球奖分布图(获取某期所有红球的未出现次数排名分布情况)
	 */
	public static List<NumLastAppear> redBallDistributionMap(HistoryRecord[] hrs) {

		List<HistoryRecord> historyList = new ArrayList<>();
		Collections.addAll(historyList, hrs);
		// 复制为最新记录数据
		List<HistoryRecord> newHrList = new ArrayList<>();
		newHrList.addAll(historyList);
		// 获取最新一期数据中的红球数据
		String redNumStr = historyList.get(0).getRedNum();
		// 减去最近一期数据，成为历史数据
		historyList.remove(0);
		// 使用上期数据，算出上期红球分布结果
		List<NumLastAppear> redNumLastList = getRedNumDetail(Utils.listToArray(historyList, HistoryRecord.class));

		// 将红色球结果字符串转换为数组
		String[] redNumStrs = redNumStr.trim().split(",");
		// 查看中奖结果的排名分布情况
		List<NumLastAppear> rankingList = new ArrayList<>();

		for (String redNum : redNumStrs) {
			// 红球
			int rnum = Integer.parseInt(redNum);
			for (int i = 0; i < redNumLastList.size(); i++) {
				// 如果和最新期中的红球结果相同
				if (rnum == redNumLastList.get(i).getNum()) {
					NumLastAppear temp = new NumLastAppear(rnum, redNumLastList.get(i).getNotAppearTimes(), i + 1);
					rankingList.add(temp);
				}
			}
		}
		Collections.sort(rankingList);
		return rankingList;
	}

	/**
	 * 获取蓝球号码获奖情况
	 */
	public static List<NumLastAppear> getBlueNumDetail(HistoryRecord[] recordList) {
		// 算出蓝球
		List<NumLastAppear> blueNumLastList = new ArrayList<>();
		for (int i = 1; i < 17; i++) {
			NumLastAppear appear = new NumLastAppear();
			appear.setNum(i);
			int j = 0;
			for (HistoryRecord his : recordList) {
				if (his.getBlueNum() == i) {
					break;
				}
				j++;
			}
			appear.setNotAppearTimes(j);
			blueNumLastList.add(appear);
		}
		Collections.sort(blueNumLastList);
		return blueNumLastList;
	}

	/**
	 * 获取红球号码获奖情况
	 */
	public static List<NumLastAppear> getRedNumDetail(HistoryRecord[] recordList) {
		// 算出红球
		List<NumLastAppear> redNumLastList = new ArrayList<>();
		for (int i = 1; i < 34; i++) {
			NumLastAppear appear = new NumLastAppear();
			appear.setNum(i);
			int j = 0;
			for (HistoryRecord his : recordList) {
				List<String> temp = Arrays.asList(his.getRedNum().split(","));
				if (temp.contains(String.valueOf(i))) {
					break;
				}
				j++;
			}
			appear.setNotAppearTimes(j);
			redNumLastList.add(appear);
		}
		Collections.sort(redNumLastList);
		List<NumLastAppear> newList = new ArrayList<>();
		for (int i = 0; i < redNumLastList.size(); i++) {
			NumLastAppear n = redNumLastList.get(i);
			n.setRanking(i + 1);
			newList.add(n);
		}
		return newList;
	}

}
