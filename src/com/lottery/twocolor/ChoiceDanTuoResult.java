package com.lottery.twocolor;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import lombok.Data;

/**
 * 胆拖玩法结果
 */
@Data
public class ChoiceDanTuoResult {

	private List<Integer> blueNum;

	/** 胆码集合 */
	private List<Integer> danNumList;
	/** 拖码集合 */
	private List<Integer> tuoNumList;

	public ChoiceDanTuoResult() {

	}

	public ChoiceDanTuoResult(List<Integer> blueNum, List<Integer> redNumList, List<Integer> tuoNumList) {
		this.blueNum = blueNum;
		this.danNumList = redNumList;
		this.tuoNumList = tuoNumList;
	}

	public String toPrintString() {
		Collections.sort(blueNum);
		Collections.sort(danNumList);
		Collections.sort(tuoNumList);
		return "建议您买的号码为：蓝球【" + StringUtils.join(blueNum, ",") + "】，红球胆码【" + StringUtils.join(danNumList, ",") + "】，拖码【" + StringUtils.join(tuoNumList, ",") + "】.";
	}

}
