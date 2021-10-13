package com.lottery;

/**
 * 排名情况
 * 
 * @author gexl
 */
public enum RankingRecord {
	DAY_20211012(6, "6,14,17,18,31,33", 13, "7 10 12 20 25 27"),
	DAY_20211010(8, "2,10,12,15,24,27", 4, "2 9 12 25 32 33"),
	DAY_20211007(2, "4,6,8,14,24,27", 16, "2 7 15 23 28 32");

	private int blueNum;
	private String redNum;
	private int blueRank;
	private String redRank;

	// private RankingRecord(int blueNum, String redNum) {
	// this.blueNum = blueNum;
	// this.redNum = redNum;
	// }

	private RankingRecord(int blueNum, String redNum, int blueRank, String redRank) {
		this.blueNum = blueNum;
		this.redNum = redNum;
		this.blueRank = blueRank;
		this.redRank = redRank;
	}

	public int getBlueNum() {
		return blueNum;
	}

	public String getRedNum() {
		return redNum;
	}

	public int getBlueRank() {
		return blueRank;
	}

	public String getRedRank() {
		return redRank;
	}

}
