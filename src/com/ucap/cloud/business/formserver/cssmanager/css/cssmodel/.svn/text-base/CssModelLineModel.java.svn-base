/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelLineModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

/**
 * @ClassName CssModelLineModel
 * @Description TODO 直线模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelLineModel {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelLineModel() {

	}

	/**
	 * 是否打印
	 */
	private String printable = "";
	/**
	 * 直线类型
	 */
	private String lineStyle = "";
	/**
	 * 直线方向 如斜向上
	 */
	/**
	 * 层数
	 */
	private String thickness = "";
	/**
	 * 背景颜色
	 */
	private String foreColor = "";

	public String getPrintable() {
		return printable;
	}

	public void setPrintable(String printable) {
		this.printable = printable;
	}

	public String getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(String lineStyle) {
		this.lineStyle = lineStyle;
	}

	public String getLineDirection() {
		return LineDirection;
	}

	public void setLineDirection(String lineDirection) {
		LineDirection = lineDirection;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public String getForeColor() {
		return foreColor;
	}

	public void setForeColor(String foreColor) {
		this.foreColor = foreColor;
	}

	private String LineDirection = "";

	@Override
	public String toString() {
		return "CssModelLineModel [LineDirection=" + LineDirection
				+ ", foreColor=" + foreColor + ", lineStyle=" + lineStyle
				+ ", printable=" + printable + ", thickness=" + thickness + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((LineDirection == null) ? 0 : LineDirection.hashCode());
		result = prime * result
				+ ((foreColor == null) ? 0 : foreColor.hashCode());
		result = prime * result
				+ ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result
				+ ((printable == null) ? 0 : printable.hashCode());
		result = prime * result
				+ ((thickness == null) ? 0 : thickness.hashCode());
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
		CssModelLineModel other = (CssModelLineModel) obj;
		if (LineDirection == null) {
			if (other.LineDirection != null)
				return false;
		} else if (!LineDirection.equals(other.LineDirection))
			return false;
		if (foreColor == null) {
			if (other.foreColor != null)
				return false;
		} else if (!foreColor.equals(other.foreColor))
			return false;
		if (lineStyle == null) {
			if (other.lineStyle != null)
				return false;
		} else if (!lineStyle.equals(other.lineStyle))
			return false;
		if (printable == null) {
			if (other.printable != null)
				return false;
		} else if (!printable.equals(other.printable))
			return false;
		if (thickness == null) {
			if (other.thickness != null)
				return false;
		} else if (!thickness.equals(other.thickness))
			return false;
		return true;
	}

}
