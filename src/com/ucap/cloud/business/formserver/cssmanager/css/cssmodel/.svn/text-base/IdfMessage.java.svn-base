/**
 * 
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;
import com.ucap.cloud.business.formserver.data.model.DMJson;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RoleModel;

/**
 * @ClassName ${IdfMessage}
 * @Description idf模型
 *              <P>
 *              存放解析完成的IDF文件的原始信息
 *              </P>
 * @author yxk
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class IdfMessage implements ModelRoot {

	public IdfMessage() {
		// TODO Auto-generated constructor stub
	}
   
	private DMJson dmj = new DMJson();
	
	public DMJson getDmj() {
		return dmj;
	}

	public void setDmj(DMJson dmj) {
		this.dmj = dmj;
	}

	public IdfMessage(String filename, DataModel dm, List<String> lists,
			List<String> listjsp) {
		this.idfname = filename;
		this.dm = dm;
		this.list = lists;
		this.listjsp = listjsp;
	}

	/**
	 * @Fields roles : 保存表单的角色信息，key为角色的ID
	 */
	private Map<String, RoleModel> roles = new HashMap<String, RoleModel>();
	/**
	 * 存放idf名字
	 */
	private String idfname;
	/**
	 * 存放jsp页面的集合
	 */
	private List<String> listjsp = new ArrayList<String>();
	/**
	 * 记录表单的分页信息
	 */
	private List<String> list = new ArrayList<String>();
	/**
	 * 放置json值
	 */
	private String json;
	/**
	 * 引用DataModel对象
	 */
	private DataModel dm;
	/** 存放表单中的附件路径,附件大小的集合,key为上传附件的名字 */
	private Map<String,String> fileMap=new HashMap<String, String>();

	public DataModel getDm() {
		return dm;
	}

	public void setDm(DataModel dm) {
		this.dm = dm;
	}

	public String getIdfname() {
		return idfname;
	}

	public void setIdfname(String idfname) {
		this.idfname = idfname;
	}

	public List<String> getListjsp() {
		return listjsp;
	}

	public void setListjsp(List<String> listjsp) {
		this.listjsp = listjsp;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Map<String, RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Map<String, RoleModel> roles) {
		this.roles = roles;
	}

	/**
	 * @return the fileMap
	 */
	public Map<String, String> getFileMap() {
		return fileMap;
	}

	/**
	 * @param fileMap the fileMap to set
	 */
	public void setFileMap(Map<String, String> fileMap) {
		this.fileMap = fileMap;
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

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		IdfMessage idf = new IdfMessage();
		idf.setIdfname(this.idfname);
		idf.setDm((DataModel) dm.clone());
		idf.setJson(this.json);
		idf.setList(this.list);
		idf.setListjsp(this.listjsp);
		idf.setRoles(this.roles);
		idf.setFileMap(this.fileMap);
		return idf;
	}

}
