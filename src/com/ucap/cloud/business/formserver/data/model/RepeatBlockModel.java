/**  
* @Project: cloudFairy
* @Title: RepeatBlockModel.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-9-15 下午03:21:29
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName RepeatBlockModel
 * @Description 保存重复块的数据模型
 * @author sunjq
 * @date 2012-9-15
 */

@SuppressWarnings("serial")
public class RepeatBlockModel implements ModelRoot {

	/** 
	 * <p>Title:RepeatBlockModel </p>
	 * <p>Description:保存重复块的数据模型 </p> 
	 */

	public RepeatBlockModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/** 
	* @Fields showTitle : 是否显示标题
	*/
	private String showTitle = "";
	
	/** 
	* @Fields showNumber : 是否显示序号
	*/
	private String showNumber = "";
	
	/** 
	* @Fields pageControl : 保存重复表控件，以pagenumber做Key
	*/
	private Map<String,ControlBlockModel> pageControl = new HashMap<String, ControlBlockModel>();
	
	/** 
	* @Fields controllist : 记录重复块内的包含控件的ID
	*/
	private List<String> controllist = new ArrayList<String>();
	
	/** 
	* @Fields namepath : 重复块的namepath
	*/
	private String namepath = "";
	
	
	
	
	
	
	
	
	
	
	
	public String getNamepath() {
		return namepath;
	}

	public void setNamepath(String namepath) {
		this.namepath = namepath;
	}

	public void setControllist(String control) {
		this.controllist.add(control);
	}

	public List<String> getControllist() {
		return controllist;
	}

	public void setControllist(List<String> controllist) {
		this.controllist = controllist;
	}


	public Map<String, ControlBlockModel> getPageControl() {
		return pageControl;
	}

	public void setPageControl(Map<String, ControlBlockModel> pageControl) {
		this.pageControl = pageControl;
	}
	public void setPageControl(String name, ControlBlockModel pageControl) {
		this.pageControl.put(name, pageControl);
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(String showNumber) {
		this.showNumber = showNumber;
	}
	
	

}
