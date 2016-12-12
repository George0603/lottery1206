package com.lottery;

import java.util.Collections;
import java.util.List;

/**
 * 建议选择结果
 * @author gexl
 *
 */
public class ChoiceResult {
	
	private int blueNum ;
	
	private List<Integer> redNumList ;
	
	public ChoiceResult(int blueNum,List<Integer> redNumList) {
		this.blueNum = blueNum ;
		this.redNumList = redNumList ;
	}

	public ChoiceResult() {	}

	public String toPrintString(){
		Collections.sort(redNumList);
		return "建议您买的双色球号码为：蓝球【 "+ blueNum +" 】，红球【 " + listToString(redNumList)+" 】 ." ; 
	}
	
	public static String listToString(List<Integer> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (Integer string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }
	
	public int getBlueNum() {
		return blueNum;
	}

	public void setBlueNum(int blueNum) {
		this.blueNum = blueNum;
	}

	public List<Integer> getRedNumList() {
		return redNumList;
	}

	public void setRedNumList(List<Integer> redNumList) {
		this.redNumList = redNumList;
	}
	
}
