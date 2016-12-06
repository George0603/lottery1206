package com.lottery;

/**
 * 建议选择结果
 * @author gexl
 *
 */
public class ChoiceResult {
	
	private int blueNum ;
	
	private String redNumList ;
	
	public ChoiceResult(int blueNum,String redNumList) {
		this.blueNum = blueNum ;
		this.redNumList = redNumList ;
	}

	public ChoiceResult() {	}

	public String toPrintString(){
		return "建议您买的双色球号码为：蓝球【 "+ blueNum +" 】，红球【 " +redNumList+" 】 ." ; 
	}
	
	public int getBlueNum() {
		return blueNum;
	}

	public void setBlueNum(int blueNum) {
		this.blueNum = blueNum;
	}

	public String getRedNumList() {
		return redNumList;
	}

	public void setRedNumList(String redNumList) {
		this.redNumList = redNumList;
	}

	
}
