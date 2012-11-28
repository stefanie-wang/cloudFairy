/**
 * 
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.HashMap;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName IdfUserModel
 * @Description TODO
 *              <P>
 *              存储每个用户的多套idf数据
 *              </P>
 * @author yxk
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class IdfUserModel implements ModelRoot {

	/**
	 * 
	 */
	public IdfUserModel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 存放用户信息
	 */
	private String userid;
	/**
	 * key idf name value idf 信息
	 */
	private Map<String, IdfMessage> idfmessage = new HashMap<String, IdfMessage>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public IdfMessage getIdfmessage(String key) {
		return this.idfmessage.get(key);
	}

	public Map<String, IdfMessage> getIdfmessage() {
		return idfmessage;
	}

	public void setIdfmessage(String key, IdfMessage idf) {
		this.idfmessage.put(key, idf);
	}

	public void setIdfmessage(Map<String, IdfMessage> idfmessage) {
		this.idfmessage = idfmessage;
	}

}
