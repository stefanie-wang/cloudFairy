/**
 * 
 */
package com.ucap.cloud.builder.model.rootConfigModel;

import java.util.HashMap;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @author yxk
 * <P>放入spring环境中<P>
 */
@SuppressWarnings("serial")
public class AuthorityConfigModel implements ModelRoot{

	/**
	 * 
	 */
	public AuthorityConfigModel() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * key:username
	 * value:用户权限
	 */
	private Map<String,AuthorityModel> userroot = new HashMap<String,AuthorityModel>();

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据用户名和密码获取用户权限
	 * @param username
	 * @param password
	 * @return
	 */
	public AuthorityModel getUserroot(String username,String password)
	{
		AuthorityModel am = this.userroot.get(username);
		if(null!=am&&am.getPassword().equals(password))
		{
			return am;
		}
		return null;
	}
	
	public Map<String, AuthorityModel> getUserroot() {
		return userroot;
	}

	public void setUserroot(AuthorityModel am)
	{
		this.userroot.put(am.getUsername(),am);
	}
	
	public void setUserroot(Map<String, AuthorityModel> userroot) {
		this.userroot = userroot;
	}
	
	

}
