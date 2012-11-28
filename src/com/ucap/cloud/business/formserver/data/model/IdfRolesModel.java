/**  
* @Project: cloudFairy
* @Title: RolesModel.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-10-11 下午03:17:49
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.HashMap;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName RolesModel
 * @Description TODO
 * @author sunjq
 * @date 2012-10-11
 */

@SuppressWarnings("serial")
public class IdfRolesModel implements ModelRoot {

	/** 
	 * <p>Title:RolesModel </p>
	 * <p>Description:保存表单角色的模型，一个表单可以拥有多个角色</p> 
	 */

	public IdfRolesModel() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Fields roles : 保存表单的角色信息，key为角色的ID
	*/
	private Map<String,RoleModel> roles = new HashMap<String, RoleModel>();

	
	
	public Map<String, RoleModel> getRoles() {
		return roles;
	}



	public void setRoles(Map<String, RoleModel> roles) {
		this.roles = roles;
	}
	public void setRoles(String key, RoleModel role) {
		this.roles.put(key, role);
	}



	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
