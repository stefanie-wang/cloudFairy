package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelTopGridCell
 * @Description TODO  表格顶部模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelTopGridCell implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelTopGridCell() {

	}

	/**
	 * 边界长度
	 */
	private String borderSize = "";
	/**
	 * 边界颜色
	 */
	private String borderColor = "";
	/**
	 * 边界属性
	 */
	private String borderwidth = "";

	public String getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(String borderSize) {
		this.borderSize = borderSize;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getBorderwidth() {
		return borderwidth;
	}

	public void setBorderwidth(String borderwidth) {
		this.borderwidth = borderwidth;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((borderColor == null) ? 0 : borderColor.hashCode());
		result = prime * result
				+ ((borderSize == null) ? 0 : borderSize.hashCode());
		result = prime * result
				+ ((borderwidth == null) ? 0 : borderwidth.hashCode());
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
		CssModelTopGridCell other = (CssModelTopGridCell) obj;
		if (borderColor == null) {
			if (other.borderColor != null)
				return false;
		} else if (!borderColor.equals(other.borderColor))
			return false;
		if (borderSize == null) {
			if (other.borderSize != null)
				return false;
		} else if (!borderSize.equals(other.borderSize))
			return false;
		if (borderwidth == null) {
			if (other.borderwidth != null)
				return false;
		} else if (!borderwidth.equals(other.borderwidth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CssModelTopGridCell [borderColor=" + borderColor
				+ ", borderSize=" + borderSize + ", borderwidth=" + borderwidth
				+ "]";
	}
}
