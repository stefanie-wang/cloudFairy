/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelBackGround.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelBackGround
 * @Description TODO  背景色模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelBackGround implements ModelRoot{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelBackGround() {

	}

	/**
	 * 图片文件
	 */
	private String imageFile = "";
	/**
	 * 透明度
	 */
	private String transparent = "";
	/**
	 * 填充方式
	 */
	private String fillStyle = "";
	/**
	 * 填充颜色
	 */
	private String fillColor = "";

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getTransparent() {
		return transparent;
	}

	public void setTransparent(String transparent) {
		this.transparent = transparent;
	}

	public String getFillStyle() {
		return fillStyle;
	}

	public void setFillStyle(String fillStyle) {
		this.fillStyle = fillStyle;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	private String lineColor = "";
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fillColor == null) ? 0 : fillColor.hashCode());
		result = prime * result
				+ ((fillStyle == null) ? 0 : fillStyle.hashCode());
		result = prime * result
				+ ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result
				+ ((lineColor == null) ? 0 : lineColor.hashCode());
		result = prime * result
				+ ((transparent == null) ? 0 : transparent.hashCode());
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
		CssModelBackGround other = (CssModelBackGround) obj;
		if (fillColor == null) {
			if (other.fillColor != null)
				return false;
		} else if (!fillColor.equals(other.fillColor))
			return false;
		if (fillStyle == null) {
			if (other.fillStyle != null)
				return false;
		} else if (!fillStyle.equals(other.fillStyle))
			return false;
		if (imageFile == null) {
			if (other.imageFile != null)
				return false;
		} else if (!imageFile.equals(other.imageFile))
			return false;
		if (lineColor == null) {
			if (other.lineColor != null)
				return false;
		} else if (!lineColor.equals(other.lineColor))
			return false;
		if (transparent == null) {
			if (other.transparent != null)
				return false;
		} else if (!transparent.equals(other.transparent))
			return false;
		return true;
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "CssModelBackGround [fillColor=" + fillColor + ", fillStyle="
				+ fillStyle + ", imageFile=" + imageFile + ", lineColor="
				+ lineColor + ", logger=" + logger + ", transparent="
				+ transparent + "]";
	}
}
