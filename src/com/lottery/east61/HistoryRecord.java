package com.lottery.east61;

/**
 * 双色球中奖纪录
 * 
 * @author gexl
 */
public enum HistoryRecord {
	DAY_20211103("狗", "9,4,8,4,9,6"),
	DAY_20211101("蛇", "9,0,6,8,0,2"),
	DAY_20211030("猪", "9,0,9,0,8,2"),
	DAY_20211027("兔", "9,5,7,0,6,9"),
	DAY_20211025("牛", "8,8,7,3,2,5"),
	DAY_20211023("兔", "0,7,7,7,2,0"),
	DAY_20211020("鼠", "9,4,7,9,8,5"),
	DAY_20211018("猴", "6,3,5,7,7,2"),
	DAY_20211016("虎", "4,9,9,9,6,6"),
	DAY_20211013("狗", "9,3,4,0,4,4"),
	DAY_20211011("兔", "5,6,3,6,8,2"),
	DAY_20211009("牛", "8,7,5,2,8,4"),
	DAY_20211006("鸡", "2,9,8,4,0,1"),
	DAY_20210929("蛇", "5,9,7,5,1,9"),
	DAY_20210927("马", "9,5,8,5,9,8"),
	DAY_20210925("牛", "8,2,9,1,5,7"),
	DAY_20210922("猪", "7,6,0,1,9,4"),
	DAY_20210920("鸡", "3,0,0,9,0,7"),
	DAY_20210918("狗", "7,7,4,2,9,1"),
	DAY_20210915("兔", "3,8,9,1,1,8"),
	DAY_20210913("猴", "4,6,7,8,2,7"),
	DAY_20210911("狗", "6,0,6,2,7,9"),
	DAY_20210908("猪", "2,8,1,5,5,4"),
	DAY_20210906("鼠", "0,3,7,8,4,3"),
	DAY_20210904("龙", "6,9,2,3,9,8"),
	DAY_20210901("鸡", "3,6,1,7,1,6"),
	DAY_20210830("龙", "3,4,8,2,8,3"),
	DAY_20210828("鸡", "0,2,2,2,7,1"),
	DAY_20210825("猴", "1,6,0,8,7,0"),
	DAY_20210823("蛇", "2,0,7,6,7,8"),
	DAY_20210821("猴", "8,8,5,2,3,2"),
	DAY_20210818("鼠", "0,5,2,1,1,6"),
	DAY_20210816("牛", "2,3,0,6,7,3"),
	DAY_20210814("兔", "0,4,4,1,5,8,"),
	DAY_20210811("鼠", "6,2,2,3,1,3"),
	DAY_20210809("狗", "5,1,4,4,2,1"),
	DAY_20210807("龙", "4,9,0,7,8,2"),
	DAY_20210804("鸡", "6,8,9,4,5,7"),
	DAY_20210802("猴", "1,4,8,9,1,7"),
	DAY_20210731("龙", "1,3,8,9,6,3"),
	DAY_20210728("蛇", "4,9,7,9,9,8"),
	DAY_20210726("虎", "5,1,1,3,4,7"),
	DAY_20210724("虎", "1,6,3,4,8,7"),
	DAY_20210721("兔", "5,4,0,8,5,9"),
	DAY_20210719("鸡", "3,1,9,0,9,3"),
	DAY_20210717("蛇", "3,4,0,5,0,4"),
	DAY_20210714("鸡", "9,4,2,5,4,0"),
	DAY_20210712("牛", "3,9,3,8,2,1"),
	DAY_20210710("马", "3,5,3,1,8,7"),
	DAY_20210707("蛇", "7,1,5,6,1,4"),
	DAY_20210705("羊", "5,2,8,7,6,7"),
	DAY_20210703("虎", "7,0,5,4,5,3"),
	DAY_20210630("虎", "3,2,5,2,2,6"),
	DAY_20210628("马", "1,6,6,4,9,6"),
	DAY_20210626("羊", "7,9,4,0,9,1"),
	DAY_20210623("兔", "7,3,0,6,1,2"),
	DAY_20210621("蛇", "4,8,4,9,7,0"),
	DAY_20210619("虎", "0,5,1,8,1,8"),
	DAY_20210616("猪", "5,2,8,7,9,5"),
	DAY_20210614("鸡", "6,0,5,9,2,2");

	private String zodiac;
	private String redNum;

	private HistoryRecord(String zodiac, String redNum) {
		this.zodiac = zodiac;
		this.redNum = redNum;
	}

	public String getZodiac() {
		return zodiac;
	}

	public String getRedNum() {
		return redNum;
	}

}
