package com.lottery;

/**
 * 双色球中奖纪录
 * 
 * @author gexl
 */
public enum HistoryRecord {
	DAY_20211010(8, "2,10,12,15,24,27"),
	DAY_20211007(2, "4,6,8,14,24,27"),
	DAY_20211005(2, "4,7,10,22,27,30"),
	DAY_20210930(7, "5,6,21,25,28,33"),
	DAY_20210928(6, "17,20,22,23,26,28"),
	DAY_20210926(2, "10,13,15,24,31,32"),
	DAY_20210923(16, "2,3,10,17,20,26"),
	DAY_20210921(9, "11,15,18,24,26,32"),
	DAY_20210919(1, "2,3,17,19,25,30"),
	DAY_20210916(3, "1,4,7,14,30,31"),
	DAY_20210914(9, "10,14,15,22,27,32"),
	DAY_20210912(15, "1,7,17,20,22,28"),
	DAY_20210909(15, "10,13,15,25,29,30"),
	DAY_20210907(9, "5,9,15,24,27,30"),
	DAY_20210905(1, "2,4,12,22,29,31"),
	DAY_20210902(16, "7,9,12,13,14,29"),
	DAY_20210831(15, "9,11,17,18,20,27"),
	DAY_20210829(5, "1,10,13,18,26,32"),
	DAY_20210826(12, "3,11,12,13,25,28"),
	DAY_20210824(11, "1,7,11,14,15,26"),
	DAY_20210822(13, "8,12,17,24,27,28"),
	DAY_20210819(15, "9,11,24,25,28,33"),
	DAY_20210817(3, "5,11,15,23,28,33"),
	DAY_20210815(3, "2,7,8,10,12,31"),
	DAY_20210812(16, "4,6,16,24,26,33"),
	DAY_20210810(8, "5,6,12,14,27,28"),
	DAY_20210808(12, "1,2,7,13,23,24"),
	DAY_20210805(6, "4,12,15,16,19,26"),
	DAY_20210803(4, "2,13,16,19,23,24"),
	DAY_20210801(1, "6,8,10,14,28,29"),
	DAY_20210729(2, "5,6,7,11,14,20"),
	DAY_20210727(1, "5,7,9,11,21,28"),
	DAY_20210725(4, "4,9,11,25,28,33"),
	DAY_20210722(5, "3,6,11,13,26,32"),
	DAY_20210720(1, "1,3,5,18,22,23"),
	DAY_20210718(9, "5,8,22,23,24,29"),
	DAY_20210715(13, "1,3,10,24,28,29"),
	DAY_20210713(12, "4,6,15,26,27,31"),
	DAY_20210711(10, "8,15,17,25,27,30"),
	DAY_20210708(6, "3,9,21,23,30,32"),
	DAY_20210706(1, "12,15,16,21,22,29"),
	DAY_20210704(7, "4,5,9,14,25,27"),
	DAY_20210701(8, "1,6,18,22,24,25"),
	DAY_20210629(15, "1,9,15,16,19,21"),
	DAY_20210627(8, "1,7,24,31,32,33"),
	DAY_20210624(15, "1,5,11,15,16,29"),
	DAY_20210622(5, "6,11,18,20,23,26"),
	DAY_20210620(15, "4,14,18,24,31,32"),
	DAY_20210617(9, "1,11,19,23,25,29"),
	DAY_20210615(15, "2,6,19,26,30,33"),
	DAY_20210613(16, "1,4,8,19,29,33"),
	DAY_20210610(16, "4,6,8,15,16,18"),
	DAY_20210608(9, "4,5,6,9,23,24"),
	DAY_20210606(10, "12,13,15,20,22,25"),
	DAY_20210603(1, "4,9,12,18,20,23"),
	DAY_20210601(15, "10,11,1,7,20,29,30"),
	DAY_20210530(14, "1,9,11,18,32,33"),
	DAY_20210527(14, "9,11,13,18,19,28"),
	DAY_20210525(16, "5,6,9,17,25,33"),
	DAY_20210523(1, "8,21,22,23,29,32"),
	DAY_20210520(10, "3,11,12,16,22,28"),
	DAY_20210518(2, "7,13,21,22,24,31"),
	DAY_20210516(16, "7,10,14,16,24,33"),
	DAY_20210513(14, "3,4,6,19,21,30"),
	DAY_20210511(15, "8,9,10,19,27,29"),
	DAY_20210509(8, "2,9,10,16,25,28"),
	DAY_20210506(1, "4,11,13,22,25,32"),
	DAY_20210504(3, "4,15,17,22,29,32"),
	DAY_20210502(1, "3,7,13,16,24,29"),
	DAY_20210429(6, "5,9,13,21,28,33");

	private int blueNum;
	private String redNum;

	private HistoryRecord(int blueNum, String redNum) {
		this.blueNum = blueNum;
		this.redNum = redNum;
	}

	public int getBlueNum() {
		return blueNum;
	}

	public String getRedNum() {
		return redNum;
	}

}
