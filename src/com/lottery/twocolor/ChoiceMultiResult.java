package com.lottery.twocolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import lombok.Data;

/**
 * 多个结果
 * 
 * @author gexl
 *
 */
@Data
public class ChoiceMultiResult {

	private List<Integer> blueNum;

	private List<Integer> redNumList = new ArrayList<>();

	public ChoiceMultiResult(List<Integer> blueNum, List<Integer> redNumList) {
		this.blueNum = blueNum;
		this.redNumList = redNumList;
	}

	public ChoiceMultiResult() {
	}

	public String toPrintString() {
		Collections.sort(blueNum);
		Collections.sort(redNumList);
		return "建议您买的双色球号码为：蓝球【" + StringUtils.join(blueNum, ",") + "】，红球【" + StringUtils.join(redNumList, ",") + "】.";
	}

}
