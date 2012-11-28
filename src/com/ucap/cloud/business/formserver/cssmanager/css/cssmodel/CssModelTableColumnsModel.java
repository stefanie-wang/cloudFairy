/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelTableColumnsModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelTableColumnsModel
 * @Description TODO 重复表模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelTableColumnsModel implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelTableColumnsModel() {

	}

	/**
	 * 左列
	 */
	private String columnleft = "";
	/**
	 * 列名
	 */
	private String colName = "";
	/**
	 * title
	 */
	private String title = "";
	/**
	 * 列宽
	 */
	private String colWidth = "";
	/**
	 * 颜色
	 */
	private String bgcolor = "";
	/**
	 * 内颜色
	 */
	private String lncolor = "";
	/**
	 * 排列类型
	 */
	private String align = "";
	/**
	 * 垂直模式
	 */
	private String valign = "";
	/**
	 * 是否履行
	 */
	private String fullFill = "";
	/**
	 * 模型
	 */
	private CssModelFone fone = new CssModelFone();

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getColumnleft() {
		return columnleft;
	}

	public void setColumnleft(String columnleft) {
		this.columnleft = columnleft;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColWidth() {
		return colWidth;
	}

	public void setColWidth(String colWidth) {
		this.colWidth = colWidth;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getLncolor() {
		return lncolor;
	}

	public void setLncolor(String lncolor) {
		this.lncolor = lncolor;
	}

	public String getValign() {
		return valign;
	}

	public void setValign(String valign) {
		this.valign = valign;
	}

	public String getFullFill() {
		return fullFill;
	}

	public void setFullFill(String fullFill) {
		this.fullFill = fullFill;
	}

	public CssModelFone getFone() {
		return fone;
	}

	public void setFone(CssModelFone fone) {
		this.fone = fone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((align == null) ? 0 : align.hashCode());
		result = prime * result + ((bgcolor == null) ? 0 : bgcolor.hashCode());
		result = prime * result + ((colName == null) ? 0 : colName.hashCode());
		result = prime * result
				+ ((colWidth == null) ? 0 : colWidth.hashCode());
		result = prime * result
				+ ((columnleft == null) ? 0 : columnleft.hashCode());
		result = prime * result + ((fone == null) ? 0 : fone.hashCode());
		result = prime * result
				+ ((fullFill == null) ? 0 : fullFill.hashCode());
		result = prime * result + ((lncolor == null) ? 0 : lncolor.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((valign == null) ? 0 : valign.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "CssModelTableColumnsModel [align=" + align + ", bgcolor="
				+ bgcolor + ", colName=" + colName + ", colWidth=" + colWidth
				+ ", columnleft=" + columnleft + ", fone=" + fone
				+ ", fullFill=" + fullFill + ", lncolor=" + lncolor
				+ ", title=" + title + ", valign=" + valign + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CssModelTableColumnsModel other = (CssModelTableColumnsModel) obj;
		if (align == null) {
			if (other.align != null)
				return false;
		} else if (!align.equals(other.align))
			return false;
		if (bgcolor == null) {
			if (other.bgcolor != null)
				return false;
		} else if (!bgcolor.equals(other.bgcolor))
			return false;
		if (colName == null) {
			if (other.colName != null)
				return false;
		} else if (!colName.equals(other.colName))
			return false;
		if (colWidth == null) {
			if (other.colWidth != null)
				return false;
		} else if (!colWidth.equals(other.colWidth))
			return false;
		if (columnleft == null) {
			if (other.columnleft != null)
				return false;
		} else if (!columnleft.equals(other.columnleft))
			return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (fullFill == null) {
			if (other.fullFill != null)
				return false;
		} else if (!fullFill.equals(other.fullFill))
			return false;
		if (lncolor == null) {
			if (other.lncolor != null)
				return false;
		} else if (!lncolor.equals(other.lncolor))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (valign == null) {
			if (other.valign != null)
				return false;
		} else if (!valign.equals(other.valign))
			return false;
		return true;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
