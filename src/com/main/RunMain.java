package com.main;

import java.util.Collections;
import java.util.List;

import com.lottery.Algorithm;
import com.lottery.ChoiceNum;
import com.lottery.ChoiceResult;
import com.lottery.HistoryRecord;
import com.lottery.NumLastAppear;

public class RunMain {

	public static void main(String[] args) {
		HistoryRecord[] hs = HistoryRecord.values();
		/**
		 * 打印蓝、红统计结果
		 */
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(hs);
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(hs);
		//篮球
//		printBlueAndRedList("蓝球", blueNumLastList);
		//红球
		printBlueAndRedList("红球", redNumLastList);
		
		/**
		 * 打印最新一期红球中奖号码的排名分布情况（根据未出现的次数排名）
		 */
		List<NumLastAppear> rankList = ChoiceNum.redBallDistributionMap(hs);
		printRandingList(rankList);
		/**
		 * 打印购买号码预测结果
		 */
//		Algorithm.algorithm1213(hs);
	}
	
	/**
	 * 打印最新一期红球结果，在上一期统计的排名情况集合
	 * @param rankList
	 */
	public static void printRandingList(List<NumLastAppear> rankList){
		Collections.sort(rankList);
		StringBuffer printResult = new StringBuffer("排名：");
		for(NumLastAppear rank : rankList){
			printResult.append(rank.getRanking()+"【号码："+rank.getNum()+",次数："+rank.getNotAppearTimes()+"】 ");
//			printResult.append(rank.getRanking()+" ");
		}
		System.out.println(printResult);
	}
	/**
	 * 打印红球、蓝球的未出现次数情况
	 * @param ballType
	 * @param ballList
	 */
	public static void printBlueAndRedList(String ballType,List<NumLastAppear> ballList){
		StringBuffer printResult = new StringBuffer(ballType+"：\n");
		for(int i=0;i<ballList.size();i++){
			printResult.append("序号:"+(i+1)+",号码："+ballList.get(i).getNum()
					+",未出现次数："+ballList.get(i).getNotAppearTimes()+"\n");
		}
		System.out.println(printResult);
	}
	
}
