/**
 * 
 */
package com.ucap.cloud.builder.model.rootConfigModel;

import java.util.HashMap;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @author yxk
 * <P>用户权限模型</P>
 */
@SuppressWarnings("serial")
public class AuthorityModel implements ModelRoot {

	/**
	 * 
	 */
	public AuthorityModel() {
		// TODO Auto-generated constructor stub
	}

	private String username;
	
	
	private String password;
	
	private Map<String,Authority> authority = new HashMap<String,Authority>();
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
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

	/**
	 * <P>确定用户名 是否有效</P>
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean isUser(String username,String password)
	{
		boolean b  = false;
		if(null==username||"".equals(username.trim()))	
		{
			return b;
		}
		if(null == password||"".equals(password.trim()))
		{
			return b;
		}
		if(username.equals(this.username)&&password.equals(this.password))
		{
			return true;
		}
		return b;
	}

	public Map<String, Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Map<String, Authority> authority) {
		this.authority = authority;
	}
	
	
	
}
