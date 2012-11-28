/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelCircleModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelCircleModel
 * @Description TODO 圆模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelCircleModel implements ModelRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelCircleModel() {

	}

	/**
	 * 是否打印
	 */
	private String printable = "";
	/**
	 * 是否显示边距
	 */
	private String isShowBorder = "";

	public String getPrintable() {
		return printable;
	}

	public void setPrintable(String printable) {
		this.printable = printable;
	}

	public String getIsShowBorder() {
		return isShowBorder;
	}

	public void setIsShowBorder(String isShowBorder) {
		this.isShowBorder = isShowBorder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((isShowBorder == null) ? 0 : isShowBorder.hashCode());
		result = prime * result
				+ ((printable == null) ? 0 : printable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CssModelCircleModel other = (CssModelCircleModel) obj;
		if (isShowBorder == null) {
			if (other.isShowBorder != null)
				return false;
		} else if (!isShowBorder.equals(other.isShowBorder))
			return false;
		if (printable == null) {
			if (other.printable != null)
				return false;
		} else if (!printable.equals(other.printable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CssModelCircleModel [isShowBorder=" + isShowBorder
				+ ", printable=" + printable + "]";
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
