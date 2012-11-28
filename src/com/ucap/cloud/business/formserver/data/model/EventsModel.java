/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: EventsModel.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName EventsModel
 * @Description TODO 记录idf自带Js事件的模型
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class EventsModel implements ModelRoot{

	/**
	 * 
	 */
	public EventsModel() {
		// TODO Auto-generated constructor stub
	}
	public EventsModel(Element e){
		// 获取自带Js事件放入EventModel中
		String name = e.attributeValue("name");
		this.id = name;
		
	}
	/** 
	* @Fields id : TODO
	* 控件的ID
	*/
	private String id;
	/**
	 * 
	 */
	private DataEventLoader devl;
	public DataEventLoader getDevl() {
		return devl;
	}
	public void setDevl(DataEventLoader devl) {
		this.devl = devl;
	}
	/** 
	* @Fields eventC : TODO
	* 保存控件的JS自定义事件
	* 已事件的触发类型做KEY，事件的JS事件做值
	*/
	private Map<String,String> eventC = new HashMap<String, String>();
	
	

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Map<String, String> getEventC() {
		return eventC;
	}



	public void setEventC(Map<String, String> eventC) {
		this.eventC = eventC;
	}



	public void setEventC(String s,String ss){
		this.eventC.put(s, ss);
	}




	

}
