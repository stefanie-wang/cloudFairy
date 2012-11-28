/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelPageModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelPageModel
 * @Description TODO 解析出来没一页的模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelPageModel implements ModelRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	// 不同类型位置的同一种控件集合 假设：input 重复块中的input和重复表中的input 的集合
	private List<List<Map<String, Object>>> list = new ArrayList<List<Map<String, Object>>>();
	/**
	 * 每页的重复表
	 */
	private List<CssModelTableModel> tablelist = new ArrayList<CssModelTableModel>();
	/**
	 * 每页的重复块
	 */
	private List<CssModelRepeatUnitModel> repeatLIst = new ArrayList<CssModelRepeatUnitModel>();
	/**
	 * 每页不同类型的model集合
	 */
	private Map<String, List<List<Map<String, Object>>>> pagemap = new HashMap<String, List<List<Map<String, Object>>>>();

	public List<List<Map<String, Object>>> getList() {
		return list;
	}

	public List<CssModelRepeatUnitModel> getRepeatLIst() {
		return repeatLIst;
	}

	public void setRepeatLIst(List<CssModelRepeatUnitModel> repeatLIst) {
		this.repeatLIst = repeatLIst;
	}

	public void setList(List<List<Map<String, Object>>> list) {
		this.list = list;
	}

	public List<CssModelTableModel> getTablelist() {
		return tablelist;
	}

	public void setTablelist(List<CssModelTableModel> tablelist) {
		this.tablelist = tablelist;
	}

	public Map<String, List<List<Map<String, Object>>>> getPagemap() {
		return pagemap;
	}

	public void setPagemap(Map<String, List<List<Map<String, Object>>>> pagemap) {
		this.pagemap = pagemap;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((pagemap == null) ? 0 : pagemap.hashCode());
		result = prime * result
				+ ((repeatLIst == null) ? 0 : repeatLIst.hashCode());
		result = prime * result
				+ ((tablelist == null) ? 0 : tablelist.hashCode());
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
		CssModelPageModel other = (CssModelPageModel) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (pagemap == null) {
			if (other.pagemap != null)
				return false;
		} else if (!pagemap.equals(other.pagemap))
			return false;
		if (repeatLIst == null) {
			if (other.repeatLIst != null)
				return false;
		} else if (!repeatLIst.equals(other.repeatLIst))
			return false;
		if (tablelist == null) {
			if (other.tablelist != null)
				return false;
		} else if (!tablelist.equals(other.tablelist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CssModelPageModel [list=" + list + ", pagemap=" + pagemap
				+ ", repeatLIst=" + repeatLIst + ", tablelist=" + tablelist
				+ "]";
	}
}
