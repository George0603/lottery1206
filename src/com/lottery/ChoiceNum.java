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
	public static ChoiceResult choiceNum(){
		ChoiceResult result = new ChoiceResult();
		List<NumLastAppear> blueNumLastList = getBlueNumDetail();
		List<NumLastAppear> redNumLastList = getRedNumDetail();
		result.setBlueNum(blueNumLastList.get(0).getNum());
		String redNumStr = "" ;
		for(int i=0;i<6;i++){
			redNumStr += redNumLastList.get(i).getNum()+" ";
		}
		result.setRedNumList(redNumStr);
		System.out.println(result.toPrintString());
		return result ;
	}
	
	/**
	 * 红球奖分布图
	 */
	public static void redBallDistributionMap(){
		List<NumLastAppear> redNumLastList = getRedNumDetail();
		HistoryRecord2 lastRecord = HistoryRecord2.values()[0];
		String[] numListStr = lastRecord.getRedNum().split(",");
		String result = "" ;
		for(String numstr :numListStr){
			int num = Integer.parseInt(numstr.trim());
			for(int i=0;i<redNumLastList.size();i++){
				if(num == redNumLastList.get(i).getNum()){
					result += num+ "【排名"+(i+1)+",次数"+redNumLastList.get(i).getNotAppearTimes()+"】  " ;
				}
			}
		}
		System.out.println("本次中奖及分布情况:"+ result);
	}
	
	/**
	 * 获取蓝球号码获奖情况
	 */
	public static List<NumLastAppear> getBlueNumDetail(){
		HistoryRecord[] recordList = HistoryRecord.values();
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
		for(NumLastAppear appear : blueNumLastList){
			System.out.println("Num:"+ appear.getNum()+"; 没出现的次数："+appear.getNotAppearTimes());
		}
		System.out.println("************************************************************************************************************");
		return blueNumLastList ;
	}
	
	/**
	 * 获取红球号码获奖情况
	 */
	public static List<NumLastAppear> getRedNumDetail(){
		HistoryRecord[] recordList = HistoryRecord.values();
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
	

}
