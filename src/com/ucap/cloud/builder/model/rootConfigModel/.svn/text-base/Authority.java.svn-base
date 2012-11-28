/**
 * 
 */
package com.ucap.cloud.builder.model.rootConfigModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @author yxk
 * <P>具体的用户权限</P>
 */
@SuppressWarnings("serial")
public class Authority implements ModelRoot {

	/**
	 * 
	 */
	public Authority() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 要进行操作的功能id
	 */
	private String objectId;
	
	/**
	 * 是否可以全体操作
	 */
	private boolean isAll;
	
	/**
	 * 不是全体操作时候的局部方法列表
	 */
	private List<String> methodlist = new ArrayList<String>();
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public boolean isAll() {
		return isAll;
	}

	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}

	public String getMethodlist(int i)
	{
		return this.methodlist.get(i);
	}
	
	public boolean removeMethod(String methodname)
	{
		return this.methodlist.remove(methodname);
	}
	/**
	 * 确定方法名是否存在
	 * @param methodname
	 * @return
	 */
	public boolean isMethod(String methodname)
	{
		int i = Collections.binarySearch(this.methodlist, methodname);
		return i>0?true:false;
	}
	
	public List<String> getMethodlist() {
		return methodlist;
	}

	public void setMethodlist(List<String> methodlist) {
		this.methodlist = methodlist;
	}

	public void setMethodlist(String methodid)
	{
		this.methodlist.add(methodid);
	}
	
}
