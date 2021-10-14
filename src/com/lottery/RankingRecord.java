package com.lottery;

/**
 * 排名情况
 * 
 * @author gexl
 */
public enum RankingRecord {
	DAY_20211012(6, "6,14,17,18,31,33", 13, "7 10 12 20 25 27"),
	DAY_20211010(8, "2,10,12,15,24,27", 4, "2 9 12 25 32 33"),
	DAY_20211007(2, "4,6,8,14,24,27", 16, "2 7 15 23 28 32"),
	DAY_20211005(2, "4,7,10,22,27,30", 14, "6 8 9 12 17 25"),
	DAY_20210930(7, "5,6,21,25,28,33", 2, "1 2 4 7 16 33"),
	DAY_20210928(6, "17,20,22,23,26,28", 5, "4 11 12 25 26 27"),
	DAY_20210926(2, "10,13,15,24,31,32", 4, "10 19 24 26 27 30"),
	DAY_20210923(16, "2,3,10,17,20,26", 12, "12 14 22 23 24 32"),
	DAY_20210921(9, "11,15,18,24,26,32", 14, "7 8 9 13 19 22"),

	DAY_20210429(6, "17,20,22,23,26,28", 5, "4 11 12 25 26 27");

	private int blueNum;
	private String redNum;
	private int blueRank;
	private String redRank;

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
