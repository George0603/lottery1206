package com.lottery.sevencolor;

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

	private List<Integer> numList = new ArrayList<>();

	public ChoiceResult() {
	}

	public ChoiceResult(List<Integer> redNumList) {
		this.numList = redNumList;
	}

	public String toPrintString() {
		Collections.sort(numList);
		return "建议您买的七乐彩号码为：【" + StringUtils.join(numList, ",") + "】 .";
	}
}
