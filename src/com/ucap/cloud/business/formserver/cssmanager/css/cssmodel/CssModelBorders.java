/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelBorders.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelBorders
 * @Description TODO 边界模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelBorders implements ModelRoot {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelBorders() {

	}
	/**
	 * 底部
	 */
	private String bottom = "";
	/**
	 * 左边距
	 */
	private String left = "";
	/**
	 * 边框长度
	 */
	private String borderSize = "";
	/**
	 * 边框类型
	 */
	private String borderStyle = "";
	/**
	 * 边框颜色
	 */
	private String borderColor = "";
	/**
	 * 上边距
	 */
	private String top = "";
	/**
	 * 右边距
	 */
	private String right = "";

	/**
	 * 启动加入配置文件文件格式： <styles> <style-border> <boder key="floa|sunken|rised|none"
	 * value="border-style:solid;|.."/> </style-border> </styles>
	 */
	static Map<String, String> stylemap = new HashMap<String, String>();
	static {
		stylemap.put("flat", "border-style:solid;");
		stylemap.put("sunken", "border-style:inset;");
		stylemap.put("rised", "border-style:outset;");
		stylemap.put("none", "border-style:none;");
	}
	public String getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(String borderSize) {
		this.borderSize = borderSize;
	}
	
	public String getBorderStyle() {

		return this.borderStyle;
	}

	public void setBorderStyle(String borderStyle) {
		this.borderStyle = borderStyle;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getBottom() {
		return bottom;
	}

	public void setBottom(String bottom) {
		this.bottom = bottom;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "CssModelBorders [borderColor=" + borderColor + ", borderSize="
				+ borderSize + ", borderStyle=" + borderStyle + ", bottom="
				+ bottom + ", left=" + left + ", logger=" + logger + ", right="
				+ right + ", top=" + top + "]";
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
				+ ((borderStyle == null) ? 0 : borderStyle.hashCode());
		result = prime * result + ((bottom == null) ? 0 : bottom.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
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
		CssModelBorders other = (CssModelBorders) obj;
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
		if (borderStyle == null) {
			if (other.borderStyle != null)
				return false;
		} else if (!borderStyle.equals(other.borderStyle))
			return false;
		if (bottom == null) {
			if (other.bottom != null)
				return false;
		} else if (!bottom.equals(other.bottom))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		return true;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
