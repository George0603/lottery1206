package com.lottery;

/**
 * 双色球中奖纪录
 * @author gexl
 */
public enum HistoryRecord{
	
	day_2016145(6,"1,3,7,12,19,20"),
	day_2016144(5,"4,10,12,27,32,33"),
	day_2016143(13,"6,9,23,24,25,33"),
	day_2016142(12,"1,10,17,21,23,30"),
	day_2016141(15,"4,13,15,17,21,24"),	
	day_2016140(10,"1,2,5,17,26,32"),
	day_2016139(3,"1,6,19,26,28,30"),
	day_2016138(7,"7,16,20,24,25,30"),
	day_2016137(14,"1,6,9,10,15,32"),
	day_2016136(3,"2,7,10,20,27,29"),
	day_2016135(12,"2,8,10,18,20,33"),
	day_2016134(13,"11,12,13,14,18,33"),
	day_2016133(15,"15,16,21,22,27,33"),
	day_2016132(7,"5,8,13,19,27,28"),
	day_2016131(2,"4,10,18,19,25,27"),
	day_2016130(1,"3,17,21,23,27,28"),
	day_2016129(14,"5,6,8,21,31,33"),
	day_2016128(13,"4,9,11,17,26,27"),
	day_2016127(16,"7,12,17,26,29,31"),
	day_2016126(10,"2,6,12,17,18,19"),
	day_2016125(3,"1,6,8,20,27,30"),
	day_2016124(10,"9,15,21,24,27,32"),
	day_2016123(16,"7,9,12,14,20,27"),
	day_2016122(8,"15,22,23,24,28,29"),
	day_2016121(9,"2,3,10,23,25,28"),
	day_2016120(9,"2,5,6,21,25,28"),
	day_2016119(4,"9,19,21,30,31,32"),
	day_2016118(14,"9,14,22,23,31,33"),
	day_2016117(2,"3,10,14,17,28,33"),
	day_2016116(13,"7,18,20,23,27,31"),
	day_2016115(9,"6,8,20,22,26,27"),
	day_2016114(9,"5,16,20,22,27,29"),
	day_2016113(14,"1,11,16,17,20,26"),
	day_2016112(12,"6,12,14,15,18,25"),
	day_2016111(4,"2,4,7,14,15,32"),
	day_2016110(8,"5,7,28,31,32,33"),
	day_2016109(5,"9,11,15,16,27,33"),
	day_2016108(16,"2,3,07,08,19,26"),
	day_2016107(1,"6,11,18,26,27,32"),
	day_2016106(4,"4,5,13,22,25,30"),
	day_2016105(16,"8,10,19,27,28,31"),
	day_2016104(4,"5,9,11,18,30,31"),
	day_2016103(11,"1,5,13,19,24,27"),
	day_2016102(13,"5,8,10,14,17,30"),
	day_2016101(1,"1,3,19,24,32,33"),
	day_2016100(4,"3,10,22,23,27,29"),
	day_2016099(6,"1,11,21,23,27,33"),
	day_2016098(6,"2,8,25,29,31,32"),
	day_2016097(1,"6,13,25,26,28,31"),
	day_2016096(16,"6,13,14,21,22,24"),
	day_2016095(12,"1,5,9,12,18,32"),
	day_2016094(10,"6,7,10,12,18,31"),
	day_2016093(9,"6,9,15,17,25,27"),
	day_2016092(6,"2,13,15,23,24,29");
	
	private int blueNum ;
	private String redNum ;
	
	private HistoryRecord(int blueNum , String redNum){
		this.blueNum = blueNum ;
		this.redNum = redNum;
	}

	public int getBlueNum() {
		return blueNum;
	}

	public void setBlueNum(int blueNum) {
		this.blueNum = blueNum;
	}

	public String getRedNum() {
		return redNum;
	}

	public void setRedNum(String redNum) {
		this.redNum = redNum;
	}

}
