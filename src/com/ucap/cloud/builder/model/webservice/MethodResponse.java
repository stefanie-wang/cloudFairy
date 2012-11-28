/**
 * <br>
 * webservice Model
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: MethodResponse.java
 * @Package com.ucap.cloud.builder.model.webservice
*/
package com.ucap.cloud.builder.model.webservice;



import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;
import com.ucap.cloud.builder.util.Jsonparse;

/**
 * @author yxk
 *<p>封装返回结果的模型</p>
 */
@SuppressWarnings("serial")
public class MethodResponse implements ModelRoot {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(MethodResponse.class);
	
	public MethodResponse() {
		log.info(MethodResponse.class+"loader..");
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 要进行反馈的对象
	 */
	private Object responseObj = null;
	/**
	 * 反馈的报错信息
	 */
	private String errormessage;

	public Object getResponseObj() {
		return responseObj;
	}
     
	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	// 将结果转为json对象
	public String getResponseJson() {
		Jsonparse jp = new Jsonparse();
		return jp.getJSON(this.responseObj);
	}
}
