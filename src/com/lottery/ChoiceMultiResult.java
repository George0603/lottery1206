package com.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
		return "建议您买的双色球号码为：蓝球【" + listToString(blueNum) + "】，红球【" + listToString(redNumList) + "】 .";
	}

	public static String listToString(List<Integer> stringList) {
		if (CollectionUtils.isEmpty(stringList))
			return null;
		StringBuilder result = new StringBuilder();
		for (Integer string : stringList) {
			if (StringUtils.isNotBlank(result.toString()))
				result.append(",");
			result.append(string);
		}
		return result.toString();
	}

}
