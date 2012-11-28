/**  
* @Project: cloudFairy
* @Title: Role.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-10-11 下午03:22:44
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.HashMap;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName Role
 * @Description TODO
 * @author sunjq
 * @date 2012-10-11
 */

@SuppressWarnings("serial")
public class RoleModel implements ModelRoot {

	/** 
	 * <p>Title:Role </p>
	 * <p>Description:保存角色的属性信息，不同角色登陆显示表单内容不同 </p> 
	 */

	public RoleModel() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Fields id : 角色的id
	*/
	private String id = "";
	
	/** 
	* @Fields name : 角色的名称
	*/
	private String name = "";
	/** 
	* @Fields controlRole : 分页的role配置信息，key为控件id
	*/
	private Map<String,RolesControlsModel> controlRole = new HashMap<String, RolesControlsModel>();

	
	public Map<String, RolesControlsModel> getControlRole() {
		return controlRole;
	}

	public void setControlRole(Map<String, RolesControlsModel> controlRole) {
		this.controlRole = controlRole;
	}
	public void setControlRole(String key, RolesControlsModel controlRole) {
		this.controlRole.put(key, controlRole);
	}
	
	/** 
	* @Fields pageRoles : 表单的不同页的信息,key为分页的名称
	*/
	private Map<String,RolesPagesModel> pageRoles = new HashMap<String, RolesPagesModel>();
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<String, RolesPagesModel> getPageRoles() {
		return pageRoles;
	}


	public void setPageRoles(Map<String, RolesPagesModel> pageRoles) {
		this.pageRoles = pageRoles;
	}
	public void setPageRoles(String pageNumber, RolesPagesModel pageRole) {
		this.pageRoles.put(pageNumber, pageRole);
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
