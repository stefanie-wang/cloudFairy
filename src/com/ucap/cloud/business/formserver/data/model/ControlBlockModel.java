/**  
* @Project: cloudFairy
* @Title: ControlBlockModel.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-9-17 上午09:55:36
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName ControlBlockModel
 * @Description TODO
 * @author sunjq
 * @date 2012-9-17
 */

@SuppressWarnings("serial")
public class ControlBlockModel implements ModelRoot{

	/** 
	 * <p>Title:ControlBlockModel </p>
	 * <p>Description:记录重复块内部控件的模型 </p> 
	 */

	public ControlBlockModel() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Fields insideControl : 以控件ID做Key
	*/
	private Map<String,BlockControTypeModel> insideControl = new HashMap<String, BlockControTypeModel>();
	//private Map<String,List<String>> insideCon = new HashMap<String, List<String>>();
	

	/* (非 Javadoc) 
	* <p>Title: compareTo</p>
	* <p>Description: </p>
	* @param o
	* @return 
	* @see java.lang.Comparable#compareTo(java.lang.Object) 
	*/
	
	public Map<String, BlockControTypeModel> getInsideControl() {
		return insideControl;
	}

	public void setInsideControl(Map<String, BlockControTypeModel> insideControl) {
		this.insideControl = insideControl;
	}
	public void setInsideControl(String id, BlockControTypeModel insideControl) {
		this.insideControl.put(id, insideControl);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*public Map<String, List<String>> getInsideCon() {
		return insideCon;
	}

	public void setInsideCon(Map<String, List<String>> insideCon) {
		this.insideCon = insideCon;
	}
	public void setInsideCon(String id, List<String> insideCon) {
		this.insideCon.put(id, insideCon);
	}*/

}
