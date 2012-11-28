/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: RepeateTable.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName RepeateTable
 * @Description TODO
 * <p>
 * 重复表控件的数据模型
 * </p>
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class RepeateTable implements ModelRoot {

	/**
	 * 
	 */
	public RepeateTable() {
		// TODO Auto-generated constructor stub
	}
    public RepeateTable(Element controlsson){
    	
    	String st = controlsson.attributeValue("showTitle");
    	this.showTitle = st;
    	String namepath = controlsson.attributeValue("namepath");
    	if(namepath.startsWith("/ucapform")){
			namepath = namepath.substring(9);//截取namepath不要/ucapform
		}
    	this.namepath = namepath;
    }
	/** 
	* @Fields callist : TODO
	* 记录重复表的内部计算公式
	*/
	private List<RepeatCalculateModel> callist = new ArrayList<RepeatCalculateModel>();
	
	private int index = 1;

	private String showTitle ="";
	
	/** 
	* @Fields rep : TODO
	* 重复表的数据信息，以行号做KEY，list<String>表示该行的信息
	*/
	private Map<String,List<String>> rep = new HashMap<String, List<String>>();

	/** 
	* @Fields conindex : TODO
	* 保存重复表中控件的顺序
	*/
	private List<String> conindex = new ArrayList<String>();
	
	/** 
	* @Fields widths : 
	* 记录重复表每一列的宽度
	*/
	private List<String> widths = new ArrayList<String>();

	/** 
	* @Fields daterowsNum : 重复表的初始行数
	*/
	private int daterowsNum ;
	
	/** 
	* @Fields datecolsNum : 重复表的初始列数
	*/
	private int datecolsNum;
	/** 
	* @Fields rowsNum : TODO
	*  重复表行数
	*/
	private int rowsNum;
	/** 
	* @Fields colsNum : TODO
	* 重复表的列数
	*/
	private int colsNum;
	/** 
	* @Fields rowHeight : TODO
	* 循环域的高度
	*/
	private String rowHeight = "";
	/** 
	* @Fields namepath : TODO
	* 重复表的namepath
	*/
	private String namepath = "";

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		RepeateTable t = (RepeateTable) o;
		if (this.index > t.getIndex()) {
			return 1;
		}
		if (this.index < t.getIndex()) {
			return -1;
		}
		return 0;
	}

	public int getRowsNum() {
		return rowsNum;
	}

	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}

	public int getColsNum() {
		return colsNum;
	}

	public void setColsNum(int colsNum) {
		this.colsNum = colsNum;
	}

	public String getRowHeight() {
		return rowHeight;
	}

	public void setRowHeight(String rowHeight) {
		this.rowHeight = rowHeight;
	}

	public String getNamepath() {
		return namepath;
	}

	public void setNamepath(String namepath) {
		this.namepath = namepath;
	}

	
	public Map<String, List<String>> getRep() {
		return rep;
	}	
		
	public void setRep(Map<String, List<String>> rep) {
		this.rep = rep;
	}
		
	public void setRep(String row, List<String> rep) {
			this.rep.put(row, rep);
	}
		

    public List<String> getConindex() {
			return conindex;
	}

	public void setConindex(List<String> conindex) {
			this.conindex = conindex;
	}
	public void setConindex(String conname) {
		this.conindex.add(conname);
    }

	public List<RepeatCalculateModel> getCallist() {
		return callist;
	}

	public void setCallist(List<RepeatCalculateModel> callist) {
		this.callist = callist;
	}
	public void setCallist(RepeatCalculateModel callist) {
		this.callist.add(callist);
	}

	public List<String> getWidths() {
		return widths;
	}

	public void setWidths(List<String> widths) {
		this.widths = widths;
	}
	public void setWidths(String widths) {
		this.widths.add(widths);
	}
	public String getShowTitle() {
		return showTitle;
	}
	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}
	public int getDaterowsNum() {
		return daterowsNum;
	}
	public void setDaterowsNum(int daterowsNum) {
		this.daterowsNum = daterowsNum;
	}
	public int getDatecolsNum() {
		return datecolsNum;
	}
	public void setDatecolsNum(int datecolsNum) {
		this.datecolsNum = datecolsNum;
	}
	
	



}
