package com.lottery.sevencolor;

/**
 * 双色球中奖纪录
 */
public enum HistoryRecord {

	DAY_20220415("3,10,11,12,25,28,30", "5,8,13,17,22,24,30"), // 238, 3:4
	DAY_20220413("12,13,14,18,24,27,30", "2,3,7,18,22,24,27"), // 241, 4:3
	DAY_20220411("12,16,17,18,19,25,29", "5,11,19,20,22,28,29"), // 270, 4:3
	DAY_20220408("6,9,11,13,18,19,22", "3,7,11,16,22,23,27"), // 207, 4:3
	DAY_20220406("3,16,17,18,23,25,30", "4,11,15,16,21,23,29"), // 194, 4:3
	DAY_20220404("2,4,7,8,13,16,19", "3,9,17,21,24,25,26"), // 194, 3:4
	DAY_20220401("2,7,13,22,23,28,30", "6,10,15,18,23,26,30"), // 253, 3:4
	DAY_20220330("3,5,7,8,12,26,30", "2,5,10,13,16,24,27"), // 188, 3:4
	DAY_20220328("5,9,10,12,16,18,23", "3,5,11,19,21,22,23"), // 197, 3:4
	DAY_20220325("6,15,21,22,25,27,28", "1,9,10,11,14,16,21"), // 226, 4:3
	DAY_20220323("2,4,5,7,10,12,16", "6,9,10,13,25,26,27"), // 172, 3:4
	DAY_20220321("1,2,7,10,21,29,30", "3,10,11,12,19,24,30"), // 221, 3:4, 1,5,13,14,15,16,24
	DAY_20220318("1,13,22,23,24,26,30", "1,3,6,13,22,28,29"), // 221, 3:4, 3,5,9,13,19,20,29
	DAY_20220316("2,6,11,17,22,23,25", "1,2,8,13,14,15,19"), // 221, 4:3 1,3,11,16,17,19,23
	DAY_20220314("4,5,8,15,16,26,28", "2,7,10,18,25,28,29"), // 221, 2:5 2,7,9,14,16,20,25
	DAY_20220311("1,5,7,10,15,28,29", "3,7,12,13,15,16,20"), // 181, 4:3 4,10,16,17,19,20,25
	DAY_20220309("6,8,11,12,18,19,22", "2,6,8,12,22,26,29"), // 201, 2:5 2,8,10,14,15,18,29
	DAY_20220307("3,5,8,9,14,22,23", "3,4,15,16,17,18,19"), // 176, 4:3 4,5,22,23,24,25,26
	DAY_20220304("1,4,10,15,17,19,24", "1,10,12,14,15,18,19"), // 179, 4:3
	DAY_20220302("5,8,14,16,20,21,29", "1,6,8,12,19,20,27"), // 206, 3:4
	DAY_20220228("1,4,13,16,18,22,23", "3,13,14,17,24,25,26"), // 219, 4:3
	DAY_20220225("1,4,13,14,15,27,28", "8,10,13,16,26,27,29"), // 231,4:3
	DAY_20220223("10,11,13,15,17,27,29", "11,14,18,21,23,25,27"), // 261,6:1
	DAY_20220221("8,11,12,13,22,24,30", "5,7,13,16,21,22,23"), // 227,2:5
	DAY_20220218("2,10,14,16,17,18,29", "3,7,10,15,16,28,30"), // 215,2:5
	DAY_20220216("4,7,8,12,18,24,29", "2,8,13,14,16,17,28"), // 200
	DAY_20220214("11,15,20,22,24,26,27", "2,3,11,12,23,27,29"), // 252
	DAY_20220211("1,3,10,11,17,20,28", "6,7,8,9,14,22,24"), // 180
	DAY_20220209("1,7,9,12,18,21,27", "1,4,8,9,13,23,28"), // 181
	DAY_20220128("2,6,13,14,18,28,29", "5,13,14,19,22,24,26"), // 233
	DAY_20220126("2,3,6,8,15,26,27", "3,4,6,16,18,19,21"), // 174
	DAY_20220124("10,16,18,23,25,28,30", "7,8,13,16,17,21,26"), // 258
	DAY_20220121("3,6,10,14,15,17,21", "4,6,7,16,19,21,24"), // 183
	DAY_20220119("6,9,11,20,25,26,29", "1,4,11,17,20,24,29"), // 232
	DAY_20220117("6,10,12,15,16,29,30", "3,8,14,19,20,27,30"), // 239
	DAY_20220114("4,9,14,16,18,19,29", "14,20,22,23,24,27,28"), // 267
	DAY_20220112("4,10,13,18,19,20,22", "2,10,13,15,21,24,28"), // 219
	DAY_20220110("4,7,9,12,13,14,16", "12,13,14,20,21,25,27"), // 207
	DAY_20220107("6,7,8,16,20,23,28", "3,5,15,18,26,27,29"), // 231
	DAY_20220105("12,14,20,23,25,28,29", "4,7,11,13,16,18,25"), // 245
	DAY_20220103("8,12,17,18,21,22,24", "16,17,19,21,26,28,30"), // 279
	DAY_20211231("4,6,8,9,12,13,24", "1,5,8,16,17,24,25"), // 172
	DAY_20211229("6,12,17,19,22,23,27", "3,10,18,20,21,26,29"), // 253
	DAY_20211227("3,15,17,18,21,23,29", "1,2,10,11,15,19,22"), // 206
	DAY_20211224("2,6,13,19,22,24,28", "6,8,18,20,22,28,29"), // 245
	DAY_20211222("3,5,11,18,22,24,25", "5,8,12,17,20,21,28"), // 219
	DAY_20211220("2,7,19,20,25,28,30", "1,4,5,7,11,14,27"), // 200
	DAY_20211217("1,9,18,20,22,27,29", "2,8,9,15,22,23,30"), // 235
	DAY_20211215("3,4,14,17,23,24,27", "6,9,13,18,20,23,27"), // 228
	DAY_20211213("2,10,13,14,16,18,20", "2,5,13,20,24,28,29"), // 214
	DAY_20211210("2,4,6,11,14,16,17", "3,7,11,19,20,21,26"), // 177
	DAY_20211208("5,12,17,18,19,27,29", "2,3,4,12,21,25,30"), // 224
	DAY_20211206("11,12,14,16,24,26,27", "3,11,14,16,23,25,27"), // 249
	DAY_20211203("1,12,13,16,19,22,25", "6,11,15,18,21,22,28"), // 229
	DAY_20211201("3,6,7,8,13,23,24", "1,3,8,16,19,22,26"), // 179
	DAY_20211129("1,5,8,14,19,25,30", "5,7,9,18,21,23,25"), // 210
	DAY_20211126("4,5,7,16,21,24,27", "3,4,15,18,21,22,27"), // 214
	DAY_20211124("8,10,13,21,25,26,30", "8,14,23,26,27,28,30"), // 289
	DAY_20211122("4,5,10,13,21,22,25", "10,14,16,19,23,25,28"), // 235
	DAY_20211119("2,5,7,9,10,15,30", "6,8,12,17,20,21,26"), // 188
	DAY_20211117("3,4,9,12,16,20,21", "3,8,19,20,21,27,28"), // 211
	DAY_20211115("2,10,16,21,25,26", "5,8,12,23,24,28"), // 200
	DAY_20211112("2,4,9,15,21,22,29", "2,4,6,16,19,20,23"), // 192
	DAY_20211110("7,13,14,18,19,20,26", "15,20,22,23,27,29,30"), // 283
	DAY_20211108("4,8,11,14,15,18,26", "2,5,8,13,15,28,30"), // 197
	DAY_20211105("1,7,9,13,14,20,26", "1,3,4,6,15,21,23"), // 163
	DAY_20211103("5,12,17,19,25,29,30", "2,10,12,13,19,23,30"), // 246
	DAY_20211101("4,6,11,13,16,26,30", "2,4,6,8,21,24,29"), // 200
	DAY_20211029("4,5,7,10,24,26,29", "4,9,15,17,18,19,26"), // 213
	DAY_20211027("2,3,5,8,16,22,27", "2,6,7,13,17,18,19"), // 165
	DAY_20211025("4,7,12,15,17,19", "1,5,6,10,13,20"), // 129
	DAY_20211022("3,5,9,21,24,28,29", "1,2,3,9,18,24,30"), // 206
	DAY_20211020("5,6,12,14,18,27,28", "10,16,22,25,26,28,30"), // 267
	DAY_20211018("1,5,6,10,12,16,27", "1,7,10,11,14,20,24"), // 164
	DAY_20211015("12,13,17,21,23,28,30", "1,4,5,13,19,28,30"), // 244
	DAY_20211013("8,10,15,18,21,22,28", "10,15,16,17,22,24,27"), // 253
	DAY_20211011("8,13,14,18,19,25,26", "1,5,7,11,12,16,30"), // 205
	DAY_20211008("1,5,7,9,10,16,18", "4,5,10,11,17,19,25"), // 157
	DAY_20211006("2,5,11,12,15,21,28", "4,6,8,15,20,23,27"), // 197
	DAY_20210929("4,10,20,21,22,26,27", "1,4,5,7,17,25,29"), // 218
	DAY_20210927("8,10,11,14,18,22,28", ""),
	DAY_20210924("1,7,12,17,18,24,29", ""),
	DAY_20210922("7,8,12,23,24,25,27", ""),
	DAY_20210920("1,2,3,10,13,18,22", ""),
	DAY_20210917("10,15,16,17,22,24,27", ""),
	DAY_20210915("1,5,8,9,13,15,18", ""),
	DAY_20210913("5,8,12,13,16,23,24", ""),
	DAY_20210910("5,6,8,11,13,24,26", ""),
	DAY_20210908("1,5,12,13,18,24,28", ""),
	DAY_20210906("4,5,6,10,14,25,26", ""),
	DAY_20210903("2,10,12,16,17,22,23", ""),
	DAY_20210901("4,5,6,10,14,25,26", ""),
	DAY_20210830("2,4,7,8,10,18,20", ""),
	DAY_20210827("4,6,9,15,22,23,27", ""),
	DAY_20210825("1,12,15,16,17,20,22", ""),
	DAY_20210823("3,4,6,8,9,11,13", ""),
	DAY_20210820("8,17,22,23,25,27,29", ""),
	DAY_20210818("1,4,5,6,16,24,30", ""),
	DAY_20210816("4,5,11,14,20,22,23", ""),
	DAY_20210813("3,8,13,23,26,27,30", ""),
	DAY_20210811("5,8,10,23,27,28,29", ""),
	DAY_20210809("2,4,5,8,13,25,27", ""),
	DAY_20210806("5,15,18,19,22,23,28", ""),
	DAY_20210804("8,12,17,18,21,24,30", ""),
	DAY_20210802("2,12,17,20,25,26,27", ""),
	DAY_20210730("1,10,13,16,17,28,30", ""),
	DAY_20210728("2,8,11,12,16,17,18", ""),
	DAY_20210726("4,5,7,9,18,21,28", ""),
	DAY_20210723("2,6,10,13,18,22,25", ""),
	DAY_20210721("1,2,4,16,19,20,22", "")

	;

	private String redNum;

	private String ranking;

	private HistoryRecord(String redNum, String ranking) {
		this.redNum = redNum;
		this.ranking = ranking;
	}

	public String getRedNum() {
		return redNum;
	}

	public String getRanking() {
		return ranking;
	}

}
