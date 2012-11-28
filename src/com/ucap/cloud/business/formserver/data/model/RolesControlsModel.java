/**  
* @Project: cloudFairy
* @Title: RolesControlsModel.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-10-11 下午04:08:46
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName RolesControlsModel
 * @Description TODO
 * @author sunjq
 * @date 2012-10-11
 */

@SuppressWarnings("serial")
public class RolesControlsModel implements ModelRoot {

	/** 
	 * <p>Title:RolesControlsModel </p>
	 * <p>Description:记录不同角色对不同的配置信息 </p> 
	 */

	public RolesControlsModel() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Fields name : 控件的name
	*/
	private String name = "";
	/** 
	* @Fields type : 控件的类型
	*/
	private String type ="";
	/** 
	* @Fields readOnly : 控件的只读属性
	*/
	private String readOnly ="";
	/** 
	* @Fields hidden : 控件的隐藏属性
	*/
	private String hidden ="";
	/** 
	* @Fields printable : 控件的可打印属性
	*/
	private String printable = "";
	/** 
	* @Fields forbidden : 控件的保密属性
	*/
	private String forbidden ="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReadOnly() {
		return readOnly;
	}
	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getPrintable() {
		return printable;
	}
	public void setPrintable(String printable) {
		this.printable = printable;
	}
	public String getForbidden() {
		return forbidden;
	}
	public void setForbidden(String forbidden) {
		this.forbidden = forbidden;
	}
	/* (非 Javadoc) 
	* <p>Title: compareTo</p>
	* <p>Description: </p>
	* @param o
	* @return 
	* @see java.lang.Comparable#compareTo(java.lang.Object) 
	*/
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
