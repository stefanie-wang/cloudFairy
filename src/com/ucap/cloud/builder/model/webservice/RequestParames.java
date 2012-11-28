/**
 * <br>
 * webservice Model
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: RequestParames.java
 * @Package com.ucap.cloud.builder.model.webservice
*/
package com.ucap.cloud.builder.model.webservice;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;


import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @author yxk
 *<p>封装所有请求参数的模型</p>
 */
@SuppressWarnings("serial")
public class RequestParames implements ModelRoot {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(RequestParames.class);
	
	public RequestParames() {
		// TODO Auto-generated constructor stub
		log.info(RequestParames.class+"loader..");
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
	 * 用户id或者叫资源id
	 */
	private String userid;
	
	private String pass;

	/**
	 * 请求对象id 次id必须在spring中存在
	 */
	private String objectid;

	/**
	 * 调用方法名
	 */
	private String methodname;

	/**
	 * 方法参数
	 */
	private MethodParams methodparams;

	/**
	 * 方法返回值对象
	 */
	private MethodResponse response;

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getMethodname() {
		return methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public MethodParams getMethodparams() {
		return methodparams;
	}

	public void setMethodparams(MethodParams methodparams) {
		this.methodparams = methodparams;
	}

	public MethodResponse getResponse() {
		return response;
	}

	public void setResponse(MethodResponse response) {
		this.response = response;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}