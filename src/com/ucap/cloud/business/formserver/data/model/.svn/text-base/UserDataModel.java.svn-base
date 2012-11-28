/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: UserDataModel.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */


package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.List;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName UserDataModel
 * @Description TODO
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class UserDataModel implements ModelRoot{

	/**
	 * 用于初始化数据的数据模型
	 */
	public UserDataModel() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *绑定的数据文件 
	 */
	private String datafile;
	
	
	/**
	 * 保存用户名
	 */
	private List<String> username = new ArrayList<String>();

	/**
	 * 绑定的idf
	 */
	private String idfname;
	
	public boolean isUser(String username)
	{
		return this.username.indexOf(username)>=0?true:false;
	}

	public List<String> getUsername() {
		return username;
	}

	public void setUsername(List<String> username) {
		this.username = username;
	}


	public String getIdfname() {
		return idfname;
	}

	public void setIdfname(String idfname) {
		this.idfname = idfname;
	}
	


	public String getDatafile() {
		return datafile;
	}

	public void setDatafile(String datafile) {
		this.datafile = datafile;
	}

	

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
