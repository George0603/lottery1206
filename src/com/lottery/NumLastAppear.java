package com.lottery;

public class NumLastAppear implements Comparable<NumLastAppear> {

	/**
	 * 号码
	 */
	private int num;
	/**
	 * 已经多少次没有出现了
	 */
	private int notAppearTimes;
	/**
	 * 没出现次数的排名（没出现次数越多，排名越靠前）
	 */
	private int ranking;

	public NumLastAppear() {
	}

	public NumLastAppear(int num, int notAppearTimes, int ranking) {
		this.num = num;
		this.notAppearTimes = notAppearTimes;
		this.ranking = ranking;
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
		int nat = arg0.getNotAppearTimes();
		return nat - this.notAppearTimes;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
