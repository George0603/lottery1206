package com.main;

import com.lottery.ChoiceNum;
import com.lottery.ChoiceResult;
import com.lottery.HistoryRecord;

public class RunMain {

	public static void main(String[] args) {
		HistoryRecord[] hs = HistoryRecord.values();
		ChoiceResult preResult = ChoiceNum.choiceNum(hs) ;
		System.out.println(preResult.toPrintString());
//		ChoiceNum.redBallDistributionMap(hs);
	}
	
}
