package com.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 预测结果算法
 * @author gexl
 *
 */
public class ChoiceNum {
	
	
	/**
	 * 红球奖分布图(获取某期所有红球的未出现次数排名分布情况)
	 */
	public static List<NumLastAppear> redBallDistributionMap(HistoryRecord[] hrs){
		
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
		
		//将红色球结果字符串转换为数组
		String[] redNumStrs = redNumStr.trim().split(",");
		//查看中奖结果的排名分布情况
		List<NumLastAppear> rankingList = new ArrayList<NumLastAppear>();
		
		for(String redNum : redNumStrs){
			//红球
			int rnum = Integer.parseInt(redNum);
			for(int i=0;i<redNumLastList.size();i++){
				//如果和最新期中的红球结果相同
				if(rnum==redNumLastList.get(i).getNum()){
					NumLastAppear temp = new NumLastAppear(rnum,
							redNumLastList.get(i).getNotAppearTimes(),i+1);
					rankingList.add(temp);
				}
			}
		}
		return rankingList ;
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
		return redNumLastList ;
	}
	
	/**
	 * 将集合转换为数组
	 * @param hList
	 * @return
	 */
	public static HistoryRecord[] listToArray(List<HistoryRecord> hList){
		HistoryRecord[] temp = new HistoryRecord[hList.size()];
		for(int i=0;i<hList.size();i++){
			temp[i] = hList.get(i);
		}
		return temp ;
	}

}
