package com.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChoiceNum {
	
	/**
	 * 红色球从1到33中选6个
	 * 蓝色球从1到16中选1个
	 * @return
	 */
	
	/**
	 * 获取选择结果
	 */
	public static ChoiceResult choiceNum(HistoryRecord[] recordList){
		ChoiceResult result = new ChoiceResult();
		List<NumLastAppear> blueNumLastList = getBlueNumDetail(recordList);
		List<NumLastAppear> redNumLastList = getRedNumDetail(recordList);
		result.setBlueNum(blueNumLastList.get(0).getNum());
		List<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			temp.add(redNumLastList.get(i).getNum());
		}
		result.setRedNumList(temp);
		return result ;
	}
	
	/**
	 * 红球奖分布图(获取某期所有红球的未出现次数排名分布情况)
	 */
	public static void redBallDistributionMap(HistoryRecord[] hrs){
		
		List<HistoryRecord> historyList = new ArrayList<HistoryRecord>();
		for(HistoryRecord hr :hrs){
			historyList.add(hr);
		}
		//复制为最新记录数据
		List<HistoryRecord> newHrList =  new ArrayList<HistoryRecord>();
		newHrList.addAll(historyList);
		//获取最新一期数据中的红球数据
		String redNumStr = historyList.get(0).getRedNum();
		//减去最近一期数据，成为历史数据
		historyList.remove(0);
		//使用上期数据，算出上期红球分布结果
		List<NumLastAppear> redNumLastList = getRedNumDetail(listToArray(historyList));
		
////		ChoiceResult preResult = choiceNum();
//		System.out.println(preResult.toPrintString());
		
	}
	
	/**
	 * 获取蓝球号码获奖情况
	 */
	public static List<NumLastAppear> getBlueNumDetail(HistoryRecord[] recordList){
		//算出蓝球
		List<NumLastAppear> blueNumLastList = new ArrayList<NumLastAppear>();
		for(int i=1 ;i<17;i++){
			NumLastAppear appear = new NumLastAppear();
			appear.setNum(i);
			int j = 0 ;
			for(HistoryRecord record :recordList){
				if(record.getBlueNum()==i){
					break ;
				}
				j++ ;
			}
			appear.setNotAppearTimes(j);
			blueNumLastList.add(appear);
		}
		Collections.sort(blueNumLastList);
//		for(NumLastAppear appear : blueNumLastList){
//			System.out.println("Num:"+ appear.getNum()+"; 没出现的次数："+appear.getNotAppearTimes());
//		}
		System.out.println("************************************************************************************************************");
		return blueNumLastList ;
	}
	
	/**
	 * 获取红球号码获奖情况
	 */
	public static List<NumLastAppear> getRedNumDetail(HistoryRecord[] recordList){
		//算出红球
		List<NumLastAppear> redNumLastList = new ArrayList<NumLastAppear>();
		for(int i=1 ;i<34;i++){
			NumLastAppear appear = new NumLastAppear();
			appear.setNum(i);
			int j = 0 ;
			for(HistoryRecord record :recordList){
				List<String> temp = Arrays.asList(record.getRedNum().split(","));
				if(temp.contains(String.valueOf(i))){
					break ;
				}
				j++ ;
			}
			appear.setNotAppearTimes(j);
			redNumLastList.add(appear);
		}
		Collections.sort(redNumLastList);
		for(NumLastAppear appear : redNumLastList){
			System.out.println("Num:"+ appear.getNum()+"; 没出现的次数："+appear.getNotAppearTimes());
		}
		return redNumLastList ;
	}
	
	public static HistoryRecord[] listToArray(List<HistoryRecord> hList){
		HistoryRecord[] temp = new HistoryRecord[hList.size()];
		for(int i=0;i<hList.size();i++){
			temp[i] = hList.get(i);
		}
		return temp ;
	}

}
