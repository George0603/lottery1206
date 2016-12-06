package com.lottery;

public class NumLastAppear implements Comparable<NumLastAppear>{
	
	/**
	 * 号码
	 */
	private int num ;
	/**
	 * 已经多少次没有出现了
	 */
	private int notAppearTimes ;
	
	public NumLastAppear() {
	}

	public NumLastAppear(int num ,int notAppearTimes) {
		this.num = num ;
		this.notAppearTimes = notAppearTimes ;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNotAppearTimes() {
		return notAppearTimes;
	}

	public void setNotAppearTimes(int notAppearTimes) {
		this.notAppearTimes = notAppearTimes;
	}

	@Override
	public int compareTo(NumLastAppear arg0) {
		int notAppearTimes = arg0.getNotAppearTimes();
		return notAppearTimes - this.notAppearTimes;
	}
	
}
