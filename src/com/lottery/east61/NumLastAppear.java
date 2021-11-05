package com.lottery.east61;

import lombok.Data;

@Data
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

	@Override
	public int compareTo(NumLastAppear arg0) {
		int nat = arg0.getNotAppearTimes();
		return nat - this.notAppearTimes;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		NumLastAppear arg0 = (NumLastAppear) obj;
		return num == (arg0.getNum());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
