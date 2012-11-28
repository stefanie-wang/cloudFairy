/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: OptionModel.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import org.dom4j.Element;

import com.ucap.cloud.builder.model.ModelRoot;
/**
 * @ClassName OptionModel
 * @Description TODO
 * <p>
 * 保存下拉框的选项信息的模型
 * </p>
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class OptionModel implements ModelRoot{

	/**
	 * 
	 */
	public OptionModel() {
		// TODO Auto-generated constructor stub
	}
	public OptionModel(Element et){
		// 显示值
		String text = et.attributeValue("text");
		this.text = text;
		// value值
		String value1 = et.attributeValue("value");
		this.value = value1;
		// 是否选中
		String selected1 = et.attributeValue("selected");
		this.selected = selected1;
	}

	/** 
	* @Fields text : TODO
	* 表示下拉框选项的显示值
	*/
	private String text = "" ;
	/** 
	* @Fields value : TODO
	* 表示下拉框的选项的真实值
	*/
	private String value = "";
	/** 
	* @Fields selected : TODO
	* 表示选项是否被选中
	*/
	private String selected ="";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
