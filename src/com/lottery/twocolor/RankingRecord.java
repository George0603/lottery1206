package com.lottery.twocolor;

/**
 * 排名情况
 * 
 * @author gexl
 */
public enum RankingRecord {

	DAY_20211107(7, "7,15,16,20,27,29", 12, "10,13,19,24,29,31", 114, 126), // 240,12
	DAY_20211104(1, "19,20,23,27,28,31", 6, "5,19,29,30,31,33", 148, 147), // 295,1
	DAY_20211102(9, "14,19,20,23,24,31", 7, "1,4,10,24,26,27", 131, 92), // 223,39
	DAY_20211031(2, "1,3,18,22,29,32", 9, "1,12,16,2 1,26,32", 105, 108), // 213,3
	DAY_20211028(5, "6,14,15,19,29,31", 14, "1,12,13,15,20,31", 114, 92), // 206,22
	DAY_20211026(7, "4,5,12,15,18,28", 9, "6,21,27,28,29,30", 82, 141), // 223,59
	DAY_20211024(15, "4,5,12,16,22,30", 5, "1,8,10,12,18,33", 89, 68), // 157,21
	DAY_20211021(5, "1,7,8,12,13,18", 5, "2,4,9,13,14,25", 59, 67), // 126,8
	DAY_20211019(13, "3,9,10,11,28,29", 16, "2,3,6,12,18,22", 90, 63), // 153,27
	DAY_20211017(13, "2,6,14,18,20,31", 3, "9,19,24,25,26,27", 91, 130), // 221,39
	DAY_20211014(4, "3,5,17,21,27,33", 3, "7,13,14,27,30,33", 106, 124), // 230,18
	DAY_20211012(6, "6,14,17,18,31,33", 13, "7,10,12,20,25,27", 119, 101), // 220,18
	DAY_20211010(8, "2,10,12,15,24,27", 4, "2,9,12,25,32,33", 90, 113), // 203,23
	DAY_20211007(2, "4,6,8,14,24,27", 16, "2,7,15,23,28,32", 83, 107), // 190,24
	DAY_20211005(2, "4,7,10,22,27,30", 14, "6,8,9,12,17,25", 100, 77), // 177,23
	DAY_20210930(7, "5,6,21,25,28,33", 2, "1,2,4,7,16,33", 118, 63), // 181,55
	DAY_20210928(6, "17,20,22,23,26,28", 5, "4,11,12,25,26,27", 136, 105), // 241,31
	DAY_20210926(2, "10,13,15,24,31,32", 4, "10,19,24,26,27,30", 125, 136), // 261,11
	DAY_20210923(16, "2,3,10,17,20,26", 12, "12,14,22,23,24,32", 78, 127), // 205,49
	DAY_20210921(9, "11,15,18,24,26,32", 14, "7,8,9,13,19,22", 126, 78), // 204,48
	DAY_20210919(1, "2,3,17,19,25,30", 13, "2,8,12,18,20,32", 96, 92), // 188,4
	DAY_20210916(3, "1,4,7,14,30,31", 8, "13,15,22,23,24,29", 87, 126), // 213,39
	DAY_20210914(9, "10,14,15,22,27,32", 15, "10,13,21,22,24,32", 120, 122), // 242,2
	DAY_20210912(15, "1,7,17,20,22,28", 16, "9,10,14,16,17,22", 95, 88), // 183,7
	DAY_20210909(15, "10,13,15,25,29,30", 13, "9,12,20,26,30,33", 122, 130), // 252,8
	DAY_20210907(9, "5,9,15,24,27,30", 4, "1,6,10,11,23,25", 110, 76), // 186,34
	DAY_20210905(1, "2,4,12,22,29,31", 6, "2,5,8,9,30,33", 100, 87), // 187,13
	DAY_20210902(16, "7,9,12,13,14,29", 10, "4,16,17,20,25,28", 84, 110), // 194,26
	DAY_20210831(15, "9,11,17,18,20,27", 12, "4,14,17,19,24,31", 102, 109), // 211,7
	DAY_20210829(5, "1,10,13,18,26,32", 5, "2,4,13,23,27,31", 100, 100), // 200,0
	DAY_20210826(12, "3,11,12,13,25,28", 10, "4,10,20,23,27,30", 92, 114), // 206,22
	DAY_20210824(11, "1,7,11,14,15,26", 1, "10,12,16,18,22,25", 74, 103), // 177,29
	DAY_20210822(13, "8,12,17,24,27,28", 5, "1,14,21,23,30,32", 116, 121)// 237,5

	;

	private int blueNum;
	private String redNum;
	private int blueRank;
	private String redRank;
	private int sum;
	private int sumRank;

	private RankingRecord(int blueNum, String redNum, int blueRank, String redRank, int sum, int sumRank) {
		this.blueNum = blueNum;
		this.redNum = redNum;
		this.blueRank = blueRank;
		this.redRank = redRank;
		this.sum = sum;
		this.sumRank = sumRank;
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

	public int getSum() {
		return sum;
	}

	public int getSumRank() {
		return sumRank;
	}

}
