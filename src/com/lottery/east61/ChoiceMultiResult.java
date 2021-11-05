package com.lottery.east61;

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

	private List<String> zodiacList;

	private List<Integer> redNumList = new ArrayList<>();

	public ChoiceMultiResult() {

	}

	public ChoiceMultiResult(List<String> zodiacList, List<Integer> redNumList) {
		this.zodiacList = zodiacList;
		this.redNumList = redNumList;
	}

	public String toPrintString() {
		Collections.sort(redNumList);
		return "建议您买的双色球号码为：蓝球【" + StringUtils.join(zodiacList, ",") + "】，红球【" + StringUtils.join(redNumList, ",") + "】.";
	}

}
