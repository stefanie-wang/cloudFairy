/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelSameCssModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelSameCssModel
 * @Description TODO 控件样式模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelSameCssModel implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelSameCssModel() {

	}

	/**
	 * css样式内容
	 */
	private String value = "";
	/**
	 * css样式名称
	 */
	private String CssID = "";

	public String getCssID() {
		return CssID;
	}

	public void setCssID(String cssID) {
		CssID = cssID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if(obj!=null){
			CssModelSameCssModel other = (CssModelSameCssModel) obj;
			if (this.value.equals(other.getValue())) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
