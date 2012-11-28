/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: UserModel.java
 * @Package com.ucap.cloud.business.formserver.idf.model
 */
package com.ucap.cloud.business.formserver.idf.model;

import com.ucap.cloud.builder.model.ModelRoot;
/**
 * @ClassName UserModel
 * @Description TODO 用来存放用户信息的模型
 * @author yxk
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class UserModel implements ModelRoot {

	/**
	 * 
	 */
	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 保存用户名
	 */
	private String username = "";
	/**
	 * 保存用户登录密码
	 */
	private String password = "";
	
	private String roles = "";

	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/** 
	* @Title: isnull 
	* @Description: TODO 判断用户名是否为空
	* @return boolean   如果用户名为空则返回true，否则返回false
	* @throws 
	*/
	public boolean isnull()
	{
		if(null==this.username&&null==this.password)
		{
			return false;
		}else
		{
			return true;
		}
	}
	
	
	
}
