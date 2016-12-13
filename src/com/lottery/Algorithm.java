package com.lottery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 预测结果算法
 * 蓝色球从1到16中选1个
 * 红色球从1到33中选6个
 * @author gexl
 */
public class Algorithm {
	
	public static void main(String[] args) {
//		System.out.println(new Random().nextInt(4)+29);
		HashSet<Integer> t = new HashSet<Integer>();
		t = randomSet(9, 29, 2, t);
		for (Integer i : t) {
			System.out.println(i);
		}
	}
	
	/**
	 * 从红球排名结果中选取结果：
	 * 1-3名选1个； 4-9名选1个； 10-29名选2个； 30-33名选1个；
	 * 1-33里选剩的随机选1个；
	 */
	public static ChoiceResult algorithm1213(HistoryRecord[] recordList){
		ChoiceResult choiceResult = new ChoiceResult();
		//获取蓝球统计结果
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		//选中蓝球中出现次数最多的那个号码
		choiceResult.setBlueNum(blueNumLastList.get(0).getNum());
		//获取红球统计结果
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		//记录已经选中序号
		List<Integer> redIndex = new ArrayList<Integer>();
		//从1-3名选1个
		int c1 = new Random().nextInt(3);
		redIndex.add(c1);
		//从4-9名选1个
		int c2 = new Random().nextInt(6)+3 ;
		redIndex.add(c2);
		//从30-33名选1个
		int c3 = new Random().nextInt(4)+29 ;
		redIndex.add(c3);
		//从10-29名选2个
		HashSet<Integer> t = new HashSet<Integer>();
		t = randomSet(9, 29, 2, t);
		for(Integer temp :t){
			redIndex.add(temp);
		}
		//从1-33里随机1个；
		int c6 = randomFromOutSideList(redIndex);
		redIndex.add(c6);
		//6个序号得到后，获取对应的号码
		for(Integer i:redIndex){
			choiceResult.getRedNumList().add(redNumLastList.get(i).getNum());
		}
		System.out.println(choiceResult.toPrintString());
		return choiceResult ;
	}
	/**
	 * 预测基本算法1
	 */
	public static ChoiceResult choiceNum(HistoryRecord[] recordList){
		ChoiceResult result = new ChoiceResult();
		List<NumLastAppear> blueNumLastList = ChoiceNum.getBlueNumDetail(recordList);
		List<NumLastAppear> redNumLastList = ChoiceNum.getRedNumDetail(recordList);
		result.setBlueNum(blueNumLastList.get(0).getNum());
		List<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			temp.add(redNumLastList.get(i).getNum());
		}
		result.setRedNumList(temp);
		return result ;
	}

	/** 
	 * 随机指定范围内N个不重复的数 
	 * 利用HashSet的特征，只能存放不同的值 
	 * @param min 指定范围最小值 
	 * @param max 指定范围最大值 
	 * @param n 随机数个数 
	 * @param HashSet<Integer> set 随机数结果集 
	 */  
	public static HashSet<Integer> randomSet(int min, int max, int n, HashSet<Integer> set) {  
		if (n > (max - min + 1) || max < min) {
			return null;  
		}  
		for (int i = 0; i < n; i++) {  
			// 调用Math.random()方法  
			int num = (int) (Math.random() * (max - min)) + min;  
			set.add(num);// 将不同的数存入HashSet中  
		}  
		int setSize = set.size();  
		// 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小  
		if (setSize < n) {  
			set = randomSet(min, max, n - setSize, set);// 递归  
		}  
		
		return set ;
	}  
	
	public static Integer randomFromOutSideList(List<Integer> list){
		//从0到32里随机选择一个数
		Integer result = new Random().nextInt(33);
		//如果List里面已经有这个数了，则随机选
		if(list.contains(result)){
			result = randomFromOutSideList(list);
		}
		return result ;
	}
}
