/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelFone.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelFone
 * @Description TODO 字体模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelFone implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelFone() {

	}
	/**
	 * 字体名称
	 */
	private String fontFamily = "";
	/**
	 * 字体长度
	 */
	private String fontSize = "";
	/**
	 * 是否黑体
	 */
	private String bold = "";
	/**
	 * 是否斜体
	 */
	private String italic = "";
	/**
	 * 下划线
	 */
	private String underline = "";
	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getBold() {
		return bold;
	}

	public void setBold(String bold) {
		this.bold = bold;
	}

	public String getItalic() {
		return italic;
	}

	public void setItalic(String italic) {
		this.italic = italic;
	}

	public String getUnderline() {
		return underline;
	}

	public void setUnderline(String underline) {
		this.underline = underline;
	}

	public String getStrikeout() {
		return strikeout;
	}

	public void setStrikeout(String strikeout) {
		this.strikeout = strikeout;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bold == null) ? 0 : bold.hashCode());
		result = prime * result
				+ ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result
				+ ((fontFamily == null) ? 0 : fontFamily.hashCode());
		result = prime * result
				+ ((fontSize == null) ? 0 : fontSize.hashCode());
		result = prime * result + ((italic == null) ? 0 : italic.hashCode());
		result = prime * result
				+ ((strikeout == null) ? 0 : strikeout.hashCode());
		result = prime * result
				+ ((underline == null) ? 0 : underline.hashCode());
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
		CssModelFone other = (CssModelFone) obj;
		if (bold == null) {
			if (other.bold != null)
				return false;
		} else if (!bold.equals(other.bold))
			return false;
		if (fontColor == null) {
			if (other.fontColor != null)
				return false;
		} else if (!fontColor.equals(other.fontColor))
			return false;
		if (fontFamily == null) {
			if (other.fontFamily != null)
				return false;
		} else if (!fontFamily.equals(other.fontFamily))
			return false;
		if (fontSize == null) {
			if (other.fontSize != null)
				return false;
		} else if (!fontSize.equals(other.fontSize))
			return false;
		if (italic == null) {
			if (other.italic != null)
				return false;
		} else if (!italic.equals(other.italic))
			return false;
		if (strikeout == null) {
			if (other.strikeout != null)
				return false;
		} else if (!strikeout.equals(other.strikeout))
			return false;
		if (underline == null) {
			if (other.underline != null)
				return false;
		} else if (!underline.equals(other.underline))
			return false;
		return true;
	}

	/**
	 * 是否加下划线
	 */
	private String strikeout = "";
	/**
	 * 文字颜色
	 */
	private String fontColor = "";

	@Override
	public String toString() {
		return "CssModelFone [bold=" + bold + ", fontColor=" + fontColor
				+ ", fontFamily=" + fontFamily + ", fontSize=" + fontSize
				+ ", italic=" + italic + ", strikeout=" + strikeout
				+ ", underline=" + underline + "]";
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
