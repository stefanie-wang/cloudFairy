/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelHints.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelHints
 * @Description TODO 是否显示和帮助模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelHints implements ModelRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelHints() {

	}

	/**
	 *  是否显示
	 */
	private String display = "";
	/**
	 * 帮助信息
	 */
	private String helpMessage = "";
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getReadonley() {
		return readonley;
	}

	public void setReadonley(String readonley) {
		this.readonley = readonley;
	}

	/**
	 * 顶部
	 */
	private String tips = "";
    /**
     *  @since 隐藏
     */
	private String hidden = "";
	/**
	 *  只读
	 */
	private String readonley = "";
	/**
	 * 
	 * @return  是否是顶部
	 */
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getHelpMessage() {
		return helpMessage;
	}

	/**
	 * 
	 * @param helpMessage 帮助信息
	 */
	public void setHelpMessage(String helpMessage) {
		this.helpMessage = helpMessage;
	}

	@Override
	public String toString() {
		return "CssModelHints [display=" + display + ", helpMessage="
				+ helpMessage + ", tips=" + tips + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result
				+ ((helpMessage == null) ? 0 : helpMessage.hashCode());
		result = prime * result + ((tips == null) ? 0 : tips.hashCode());
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
		CssModelHints other = (CssModelHints) obj;
		if (display == null) {
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (helpMessage == null) {
			if (other.helpMessage != null)
				return false;
		} else if (!helpMessage.equals(other.helpMessage))
			return false;
		if (tips == null) {
			if (other.tips != null)
				return false;
		} else if (!tips.equals(other.tips))
			return false;
		return true;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
