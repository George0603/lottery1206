package com.lottery.east61;

import lombok.Data;

@Data
public class ZodiacLastAppear implements Comparable<ZodiacLastAppear> {

	/**
	 * 号码
	 */
	private String zodiac;
	/**
	 * 已经多少次没有出现了
	 */
	private int notAppearTimes;
	/**
	 * 没出现次数的排名（没出现次数越多，排名越靠前）
	 */
	private int ranking;

	public ZodiacLastAppear() {
	}

	public ZodiacLastAppear(String zodiac, int notAppearTimes, int ranking) {
		this.zodiac = zodiac;
		this.notAppearTimes = notAppearTimes;
		this.ranking = ranking;
	}

	@Override
	public int compareTo(ZodiacLastAppear arg0) {
		int nat = arg0.getNotAppearTimes();
		return nat - this.notAppearTimes;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		ZodiacLastAppear arg0 = (ZodiacLastAppear) obj;
		return zodiac == (arg0.getZodiac());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
