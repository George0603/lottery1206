package com.lottery.east61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class East61Utils {

	private East61Utils() {
		throw new IllegalStateException("East61Utils class");
	}

	// 鼠、牛、虎、兔、龙、蛇、马、羊、猴、鸡、狗、猪
	private static final String[] ZODIAC = { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" };

	private static Logger logger = LoggerFactory.getLogger(East61Utils.class);

	public static void printZodiacRankingDetail() {
		List<ZodiacLastAppear> zodiaList = getZodiacLastAppearList(HistoryRecord.values());
		for (ZodiacLastAppear z : zodiaList) {
			logger.info("排名：{}，生肖：{}，未出现次数：{}", z.getRanking(), z.getZodiac(), z.getNotAppearTimes());
		}
	}

	/**
	 * 获取每个生肖未出现的次数
	 */
	public static List<ZodiacLastAppear> getZodiacLastAppearList(HistoryRecord[] hrs) {
		List<ZodiacLastAppear> zodiaList = new ArrayList<>();
		ZodiacLastAppear zodiac = null;
		for (String z : ZODIAC) {
			zodiac = new ZodiacLastAppear();
			zodiac.setZodiac(z);
			int i = 0;
			for (HistoryRecord r : hrs) {
				if (z.equals(r.getZodiac()))
					break;
				i++;
			}
			zodiac.setNotAppearTimes(i);
			zodiaList.add(zodiac);
		}
		Collections.sort(zodiaList);
		List<ZodiacLastAppear> newList = new ArrayList<>();
		ZodiacLastAppear z = null;
		for (int i = 0; i < zodiaList.size(); i++) {
			z = zodiaList.get(i);
			z.setRanking(i + 1);
			newList.add(z);
		}
		return newList;
	}
}
