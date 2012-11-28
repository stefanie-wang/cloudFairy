/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelTextAlign.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelTextAlign
 * @Description TODO 布局模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelTextAlign implements ModelRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelTextAlign() {

	}

	/**
	 * 排列类型
	 */
	private String align = "";
	/**
	 * 垂直类型
	 */
	private String valign = "";

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getValign() {
		return valign;
	}

	public void setValign(String valign) {
		this.valign = valign;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "CssModelTextAlign [align=" + align + ", valign=" + valign + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((align == null) ? 0 : align.hashCode());
		result = prime * result + ((valign == null) ? 0 : valign.hashCode());
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
		CssModelTextAlign other = (CssModelTextAlign) obj;
		if (align == null) {
			if (other.align != null)
				return false;
		} else if (!align.equals(other.align))
			return false;
		if (valign == null) {
			if (other.valign != null)
				return false;
		} else if (!valign.equals(other.valign))
			return false;
		return true;
	}

}
