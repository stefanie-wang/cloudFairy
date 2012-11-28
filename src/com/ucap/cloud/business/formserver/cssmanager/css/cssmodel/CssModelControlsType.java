/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelControlsType.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @ClassName CssModelControlsType
 * @Description TODO 控件模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelControlsType {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelControlsType() {

	}

	/**
	 * 控件类型名称 如input button
	 */
	private String type = "";

	/**
	 * 控件类型 例如input输入框可以是时间控件类型
	 */
	private String datetype = "";

	/**
	 * 控件属性名称 input中name属性的值 也是ID属性
	 */
	private String typename = "";
	/**
	 * 控件类型的 验证
	 */
	private Map<String, List<Map<String, String>>> prove = new HashMap<String, List<Map<String, String>>>();
	/**
	 * 
	 */
	private String value = "";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDatetype() {
		return datetype;
	}

	public void setDatetype(String datetype) {
		this.datetype = datetype;
	}

	public Map<String, List<Map<String, String>>> getProve() {
		return prove;
	}

	public void setProve(Map<String, List<Map<String, String>>> prove) {
		this.prove = prove;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datetype == null) ? 0 : datetype.hashCode());
		result = prime * result + ((prove == null) ? 0 : prove.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((typename == null) ? 0 : typename.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		CssModelControlsType other = (CssModelControlsType) obj;
		if (datetype == null) {
			if (other.datetype != null)
				return false;
		} else if (!datetype.equals(other.datetype))
			return false;
		if (prove == null) {
			if (other.prove != null)
				return false;
		} else if (!prove.equals(other.prove))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typename == null) {
			if (other.typename != null)
				return false;
		} else if (!typename.equals(other.typename))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CssModelControlsType [datetype=" + datetype + ", prove="
				+ prove + ", type=" + type + ", typename=" + typename
				+ ", value=" + value + "]";
	}
}
