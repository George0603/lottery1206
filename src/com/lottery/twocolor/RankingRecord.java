package com.lottery.twocolor;

/**
 * 排名情况
 */
public enum RankingRecord {

	DAY_20220505(8, "3,5,8,14,27,33", 11, "7,19,20,21,22,24"), // 203,23 4,2
	DAY_20220503(10, "2,4,7,18,25,26", 6, "1,16,19,22,29,32"), // 201,37 2,4
	DAY_20220501(14, "5,7,17,20,26,31", 15, "2,9,11,14,20,29"), // 191,21 4,2
	DAY_20220428(9, "3,7,8,14,27,30", 5, "8,17,18,22,32,33"), // 219,41 3,3
	DAY_20220426(14, "2,11,24,25,27,30", 12, "12,15,17,18,20,21"), // 222,16 3,3
	DAY_20220424(4, "3,12,17,18,19,28", 10, "1,2,4,11,12,24"), // 151,43 3,3
	DAY_20220421(6, "1,7,8,21,23,29", 5, "4,7,19,21,25,31"), // 196,18 5,1
	DAY_20220419(8, "2,17,20,23,25,27", 7, "3,5,8,9,15,18"), // 217,19 4,2
	DAY_20220417(13, "5,10,11,21,22,30", 3, "4,6,19,28,30,31"), // 217,19 3,3
	DAY_20220414(14, "5,7,21,22,24,29", 13, "1,4,9,17,20,24"), // 183,33 4,2
	DAY_20220412(12, "3,12,14,16,31,33", 2, "11,16,17,19,23,25"), // 140,20 2,4
	DAY_20220410(5, "2,6,7,10,15,20", 11, "2,3,5,19,25,26"), // 140,20 2,4
	DAY_20220407(4, "9,12,13,16,24,32", 8, "3,9,18,25,30,33"), // 224,12 2,4
	DAY_20220405(14, "1,10,13,20,22,32", 7, "8,13,15,18,20,24"), // 196,0 2,4
	DAY_20220403(2, "2,3,14,16,26,31", 10, "1,2,12,22,24,25"), // 178,6 2,4
	DAY_20220331(15, "8,12,13,19,23,25", 9, "13,14,22,24,25,27"), // 225,25 4,2
	DAY_20220329(10, "14,17,26,31,32,33", 3, "1,5,6,25,27,33"), // 250,56 3,3
	DAY_20220327(5, "5,12,19,22,25,26", 15, "10,14,15,21,26,27"), // 222,4 3,3
	DAY_20220324(7, "4,10,11,14,23,32", 16, "12,13,24,29,30,33"), // 235,47 2,4
	DAY_20220322(7, "1,10,11,22,26,32", 7, "6,19,21,25,27,31"), // 231,27 2,4
	DAY_20220320(5, "12,23,24,26,27,30", 4, "4,6,9,17,26,32"), // 236,48 2,4
	DAY_20220317(8, "3,8,10,13,26,32", 9, "2,4,18,20,26,27"), // 189,5 2,4
	DAY_20220315(9, "5,11,20,22,23,29", 16, "1,8,9,10,15,26"), // 179,41 4,2
	DAY_20220313(9, "14,15,18,19,26,32", 14, "5,14,22,24,27,31"), // 247,1 2,4
	DAY_20220310(2, "3,4,10,15,22,24", 14, "5,15,16,21,26,30"), // 191,35 2,4
	DAY_20220309(4, "6,19,24,25,28,32", 9, "10,13,17,27,32,33"), // 266,2 2,4
	DAY_20220306(15, "7,9,10,14,19,24", 9, "11,17,18,28,31,32"), // 220,54 3,3
	DAY_20220303(2, "7,12,17,19,24,25", 7, "1,18,25,29,32,33"), // 242,34 4,2
	DAY_20220301(6, "1,7,11,15,17,19", 7, "1,2,11,16,24,29"), // 153,13 6,0
	DAY_20220227(14, "3,7,22,24,26,31", 13, "1,9,12,20,21,31"), // 207,19 3,3
	DAY_20220224(16, "9,11,14,22,30,32", 10, "1,4,23,26,27,30"), // 229,7 3,3
	DAY_20220222(8, "5,6,14,20,21,25", 7, "7,9,19,23,26,28"), // 203,21 3,3
	DAY_20220217(7, "6,9,24,29,30,32", 15, "5,9,11,15,23,32"), // 225,35 2,4
	DAY_20220215(14, "5,10,19,20,29,31", 9, "3,9,10,18,23,33"), // 210,18 4,2
	DAY_20220213(7, "6,14,16,27,28,31", 4, "4,9,22,28,31,33"), // 249,5 2,4
	DAY_20220210(4, "6,7,13,14,15,27", 7, "2,3,5,18,19,31"), // 160,4 4,2
	DAY_20220208(15, "2,3,4,7,10,18", 15, "7,11,12,17,28,29"), // 148,60 2,4
	DAY_20220127(1, "4,7,8,29,30,31", 3, "1,2,9,12,17,19"), // 169,49 3,3
	DAY_20220125(15, "6,15,23,24,25,33", 16, "2,10,14,18,24,26"), // 220,32 2,4
	DAY_20220123(15, "12,18,19,20,21,32", 3, "9,13,15,26,27,31"), // 243,1 2,4
	DAY_20220120(16, "4,15,17,19,25,28", 15, "4,10,19,21,26,27"), // 215,1 4,2
	DAY_20220118(13, "2,3,7,9,20,21", 3, "10,11,18,23,25,29"), // 178,54 4,2
	DAY_20220116(16, "1,20,22,23,25,28", 15, "3,11,13,14,20,32"), // 212,26 3,3
	DAY_20220113(2, "3,6,9,15,22,31", 5, "2,7,10,13,15,33"), // 166,6 4,2
	DAY_20220111(16, "7,10,12,16,19,31", 8, "7,11,19,23,25,29"), // 209,19 3,3
	DAY_20220109(14, "5,19,24,28,30,32", 1, "11,13,14,17,29,33"), // 255,21 2,4
	DAY_20220106(6, "2,5,16,17,18,30", 7, "4,8,14,16,26,28"), // 184,8 2,4
	DAY_20220104(8, "2,12,21,23,25,31", 13, "2,3,9,10,18,33"), // 189,39 4,2
	DAY_20220102(3, "6,13,15,17,20,21", 12, "4,17,21,24,30,31"), // 219,35 2,4
	DAY_20211230(4, "9,14,20,21,24,26", 8, "2,22,23,28,30,32"), // 218,10 2,4
	DAY_20211228(5, "5,10,15,18,19,32", 6, "2,22,23,28,30,32"), // 236,38 3,3
	DAY_20211226(8, "10,12,15,17,19,20", 9, "7,10,11,14,17,29"), // 181,5 3,3
	DAY_20211223(9, "5,10,11,13,27,28", 15, "6,9,16,20,21,25"), // 191,3 4,2
	DAY_20211221(3, "7,9,21,22,26,32", 4, "1,9,10,19,29,33"), // 218,16 3,3
	DAY_20211219(9, "4,7,10,14,16,26", 15, "12,13,16,18,19,33"), // 188,34 1,5
	DAY_20211216(7, "2,5,13,15,23,26", 9, "6,11,14,20,21,31"), // 187,19 4,2
	DAY_20211214(9, "1,9,11,13,20,29", 13, "1,3,10,14,23,32"), // 166,0 4,2
	DAY_20211212(16, "4,7,17,19,20,24", 13, "6,7,9,16,22,30"), // 181,1 3,3
	DAY_20211209(10, "1,14,19,23,26,30", 11, "4,9,24,25,26,31"), // 232,6 3,3
	DAY_20211207(1, "5,10,16,26,27,33", 16, "3,4,6,22,26,33"), // 211,23 3,3
	DAY_20211205(1, "12,14,19,23,24,27", 15, "4,13,21,27,29,32"), // 245,7 3,3
	DAY_20211202(9, "11,14,15,16,27,32", 9, "3,11,16,18,25,31"), // 219,11 3,3
	DAY_20211130(1, "3,7,10,14,21,24", 12, "4,14,16,23,24,26"), // 186,28 3,3
	DAY_20211128(16, "2,6,9,15,19,28", 5, "9,10,18,21,25,31"), // 193,35 3,3
	DAY_20211125(4, "3,10,17,19,21,31", 12, "1,7,10,25,31,33"), // 208,6 5,1
	DAY_20211123(8, "1,2,16,19,25,31", 15, "1,2,8,28,31,33"), // 197,9 4,2
	DAY_20211121(10, "1,3,12,19,27,31", 13, "5,6,9,17,26,28"), // 184,2
	DAY_20211118(8, "1,4,6,14,20,28", 6, "6,7,11,19,22,32"), // 170,24
	DAY_20211116(1, "8,11,18,19,20,24", 12, "4,10,14,20,28,31"), // 207,7
	DAY_20211114(6, "8,9,15,24,26,30", 7, "1,4,7,9,18,29"), // 180,44
	DAY_20211111(10, "4,15,21,27,28,29", 2, "10,21,24,26,27,31"), // 263,15
	DAY_20211109(4, "5,17,20,21,23,33", 9, "3,4,5,14,25,31"), // 201,37
	DAY_20211107(7, "7,15,16,20,27,29", 12, "10,13,19,24,29,31"), // 240,12
	DAY_20211104(1, "19,20,23,27,28,31", 6, "5,19,29,30,31,33"), // 295,1
	DAY_20211102(9, "14,19,20,23,24,31", 7, "1,4,10,24,26,27"), // 223,39
	DAY_20211031(2, "1,3,18,22,29,32", 9, "1,12,16,21,26,32"), // 213,3
	DAY_20211028(5, "6,14,15,19,29,31", 14, "1,12,13,15,20,31"), // 206,22
	DAY_20211026(7, "4,5,12,15,18,28", 9, "6,21,27,28,29,30"), // 223,59
	DAY_20211024(15, "4,5,12,16,22,30", 5, "1,8,10,12,18,33"), // 157,21
	DAY_20211021(5, "1,7,8,12,13,18", 5, "2,4,9,13,14,25"), // 126,8
	DAY_20211019(13, "3,9,10,11,28,29", 16, "2,3,6,12,18,22"), // 153,27
	DAY_20211017(13, "2,6,14,18,20,31", 3, "9,19,24,25,26,27"), // 221,39
	DAY_20211014(4, "3,5,17,21,27,33", 3, "7,13,14,27,30,33"), // 230,18
	DAY_20211012(6, "6,14,17,18,31,33", 13, "7,10,12,20,25,27"), // 220,18
	DAY_20211010(8, "2,10,12,15,24,27", 4, "2,9,12,25,32,33"), // 203,23
	DAY_20211007(2, "4,6,8,14,24,27", 16, "2,7,15,23,28,32"), // 190,24
	DAY_20211005(2, "4,7,10,22,27,30", 14, "6,8,9,12,17,25"), // 177,23
	DAY_20210930(7, "5,6,21,25,28,33", 2, "1,2,4,7,16,33"), // 181,55
	DAY_20210928(6, "17,20,22,23,26,28", 5, "4,11,12,25,26,27"), // 241,31
	DAY_20210926(2, "10,13,15,24,31,32", 4, "10,19,24,26,27,30"), // 261,11
	DAY_20210923(16, "2,3,10,17,20,26", 12, "12,14,22,23,24,32"), // 205,49
	DAY_20210921(9, "11,15,18,24,26,32", 14, "7,8,9,13,19,22"), // 204,48
	DAY_20210919(1, "2,3,17,19,25,30", 13, "2,8,12,18,20,32"), // 188,4
	DAY_20210916(3, "1,4,7,14,30,31", 8, "13,15,22,23,24,29"), // 213,39
	DAY_20210914(9, "10,14,15,22,27,32", 15, "10,13,21,22,24,32"), // 242,2
	DAY_20210912(15, "1,7,17,20,22,28", 16, "9,10,14,16,17,22"), // 183,7
	DAY_20210909(15, "10,13,15,25,29,30", 13, "9,12,20,26,30,33"), // 252,8
	DAY_20210907(9, "5,9,15,24,27,30", 4, "1,6,10,11,23,25"), // 186,34
	DAY_20210905(1, "2,4,12,22,29,31", 6, "2,5,8,9,30,33"), // 187,13
	DAY_20210902(16, "7,9,12,13,14,29", 10, "4,16,17,20,25,28"), // 194,26
	DAY_20210831(15, "9,11,17,18,20,27", 12, "4,14,17,19,24,31"), // 211,7
	DAY_20210829(5, "1,10,13,18,26,32", 5, "2,4,13,23,27,31"), // 200,0
	DAY_20210826(12, "3,11,12,13,25,28", 10, "4,10,20,23,27,30"), // 206,22
	DAY_20210824(11, "1,7,11,14,15,26", 1, "10,12,16,18,22,25"), // 177,29
	DAY_20210822(13, "8,12,17,24,27,28", 5, "1,14,21,23,30,32")// 237,5

	;

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
