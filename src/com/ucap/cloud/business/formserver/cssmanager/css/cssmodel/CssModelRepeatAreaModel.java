/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelPageModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelRepeatAreaModel
 * @Description TODO 重复表模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelRepeatAreaModel implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelRepeatAreaModel() {

	}

	/**
	 * 背景modle
	 */
	private CssModelBackGround bcakg = new CssModelBackGround();
	/**
	 * 布局model
	 */
	private CssModelSizeAndPosition size = new CssModelSizeAndPosition();
	/**
	 * 边框modle
	 */
	private CssModelBorders bor = new CssModelBorders();

	public CssModelBackGround getBcakg() {
		return bcakg;
	}

	public void setBcakg(CssModelBackGround bcakg) {
		this.bcakg = bcakg;
	}
	public CssModelSizeAndPosition getSize() {
		return size;
	}

	public void setSize(CssModelSizeAndPosition size) {
		this.size = size;
	}

	public CssModelBorders getBor() {
		return bor;
	}

	public void setBor(CssModelBorders bor) {
		this.bor = bor;
	}

	@Override
	public String toString() {
		return "CssModelRepeatAreaModel [bcakg=" + bcakg + ", bor=" + bor
				+ ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bcakg == null) ? 0 : bcakg.hashCode());
		result = prime * result + ((bor == null) ? 0 : bor.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		CssModelRepeatAreaModel other = (CssModelRepeatAreaModel) obj;
		if (bcakg == null) {
			if (other.bcakg != null)
				return false;
		} else if (!bcakg.equals(other.bcakg))
			return false;
		if (bor == null) {
			if (other.bor != null)
				return false;
		} else if (!bor.equals(other.bor))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
