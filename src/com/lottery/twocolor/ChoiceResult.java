package com.lottery.twocolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import lombok.Data;

/**
 * 建议选择结果
 * 
 * @author gexl
 *
 */
@Data
public class ChoiceResult {

	private int blueNum;

	private List<Integer> redNumList = new ArrayList<>();

	public ChoiceResult(int blueNum, List<Integer> redNumList) {
		this.blueNum = blueNum;
		this.redNumList = redNumList;
	}

	public ChoiceResult() {
	}

	public String toPrintString() {
		Collections.sort(redNumList);
		return "建议您买的双色球号码为：蓝球【" + blueNum + "】，红球【" + StringUtils.join(redNumList, ",") + "】 .";
	}
}
