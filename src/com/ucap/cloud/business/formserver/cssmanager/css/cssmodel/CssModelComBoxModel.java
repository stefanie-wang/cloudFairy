/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelComBoxModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelComBoxModel  
 * @Description TODO 下拉框 列表框模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelComBoxModel implements ModelRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelComBoxModel() {

	}

	private String sreName = "";
	// 控件类型
	private String itemType = "";
	// 控件名称 dropList
	private String typename = "";
	// 控件属性name的值 类似于ID
	private String contname = "";
	// 下拉框的 选项值
	private Map<String, List<List<Map<String, String>>>> map = new HashMap<String, List<List<Map<String, String>>>>();

	public Map<String, List<List<Map<String, String>>>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<List<Map<String, String>>>> map) {
		this.map = map;
	}

	public String getSreName() {
		return sreName;
	}

	public void setSreName(String sreName) {
		this.sreName = sreName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getContname() {
		return contname;
	}

	public void setContname(String contname) {
		this.contname = contname;
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
				+ ((contname == null) ? 0 : contname.hashCode());
		result = prime * result
				+ ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((sreName == null) ? 0 : sreName.hashCode());
		result = prime * result
				+ ((typename == null) ? 0 : typename.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "CssModelComBoxModel [contname=" + contname + ", itemType="
				+ itemType + ", map=" + map + ", sreName=" + sreName
				+ ", typename=" + typename + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CssModelComBoxModel other = (CssModelComBoxModel) obj;
		if (contname == null) {
			if (other.contname != null)
				return false;
		} else if (!contname.equals(other.contname))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (sreName == null) {
			if (other.sreName != null)
				return false;
		} else if (!sreName.equals(other.sreName))
			return false;
		if (typename == null) {
			if (other.typename != null)
				return false;
		} else if (!typename.equals(other.typename))
			return false;
		return true;
	}
}
