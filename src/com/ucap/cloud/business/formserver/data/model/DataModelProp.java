/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DataModelProp.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName DataModelProp 
 * @Description TODO 保存控件的属性模型
 * @author  sunjq
 * @date 2012-8-10
 */
public class DataModelProp {

	/**
	 * 
	 */
	public DataModelProp() {
		// TODO Auto-generated constructor stub
	}
	/** 
	* @Fields id : TODO
	* 控件的类型
	*/
	private String id ;
	/** 
	* @Fields props : TODO
	* 保存控件的属性
	*/
	private Map<String,String>  props = new HashMap<String,String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(String key ,String value) {
		this.props.put(key, value);
	}
	
	public void setProps(Map<String, String> props) {
		this.props = props;
	}
	

}
